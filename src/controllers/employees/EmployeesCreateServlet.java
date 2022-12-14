package controllers.employees;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;

import models.Department;
import models.Employee;
import models.validators.EmployeeValidator;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class EmployeeCreateServlet
 */
@WebServlet("/employees/create")
public class EmployeesCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesCreateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Employee e = new Employee();

            e.setEmployee_code(request.getParameter("employee_code"));
            e.setEmployee_name(request.getParameter("employee_name"));
            //パスワードソルトの発行
            try{
            String str = RandomStringUtils.randomAlphanumeric(16);
            e.setPasswordSault(str);
            }catch(Exception ex){
            	System.out.println(ex);
            }

            e.setPassword(
                    EncryptUtil.getPasswordEncrypt(
                            request.getParameter("password"),
                            e.getPasswordSault()
                          )
                    );
            e.setAdmin_flag(Integer.parseInt(request.getParameter("admin_flag")));

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            e.setCreated_at(currentTime);
            e.setUpdated_at(currentTime);
            e.setIs_deleted(0);
            //ここからセッターを足す（暫定値を入れてある、現在値が動作に与える影響はないので適当）
            //int型→0 String型→"a" Date型→Date.valueOf("2022-11-21")
            e.setI_TenantId(0);
            e.setV_LastNameRuby("a");
            e.setV_FirstName("a");
            e.setV_v_FirstNameRuby("a");
            e.setI_GenderId(0);
            e.setI_Age(0);
            e.setD_BirthDay(Date.valueOf("2022-11-21"));
            e.setI_CountryId(0);
            e.setD_HiredDate(Date.valueOf("2022-11-21"));
            e.setI_Yoe(0);
            e.setV_PostalCode("a");
            e.setV_Address1("a");
            e.setI_RegistId(0);
            e.setI_LastUpdateId(0);


            // Department情報の設定
            Department department = em.find(Department.class,
                    Integer.parseInt(request.getParameter("department_id")));
            e.setDepartment(department);

            List<String> errors = EmployeeValidator.validate(e, true, true);
            if(errors.size() > 0) {

                // 部署名一覧表示のため部署情報テーブルのデータを取得する
                List<Department> departments = em.createNamedQuery("getAllDepartmentsNotDeleted", Department.class)
                        .getResultList();
                em.close();
                request.setAttribute("departments", departments);

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("employee", e);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employees/new.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(e);
                em.getTransaction().commit();
                request.getSession().setAttribute("flush", "登録が完了しました。");
                em.close();

                response.sendRedirect(request.getContextPath() + "/employees/index");
            }

        }
    }

}
