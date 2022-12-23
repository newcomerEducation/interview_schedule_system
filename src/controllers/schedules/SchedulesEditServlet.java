package controllers.schedules;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Schedule;
import utils.DBUtil;

/**
 * Servlet implementation class SchedulesEditServlet
 */
@WebServlet("/schedules/edit")
public class SchedulesEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SchedulesEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EntityManager em = DBUtil.createEntityManager();

		Schedule s = em.find(Schedule.class, Integer.parseInt(request.getParameter("id")));

		// 社員情報一覧表示のため社員情報テーブルのデータを取得する

		// 一般社員情報取得ロジックに変更
		em = DBUtil.createEntityManager();
		 List<Employee> employees = em.createNamedQuery("getAllEmployeesNotDeleted", Employee.class)
				.getResultList();

		em.close();

		Employee login_employee = (Employee) request.getSession().getAttribute("login_employee");
		//当事者でないと編集できない→管理者権限がないと編集できない機能に変更
			if (s != null && login_employee.getAdmin_flag() == 1) {
			request.setAttribute("employees", employees);

			request.setAttribute("schedule", s);
			request.setAttribute("_token", request.getSession().getId());
			request.getSession().setAttribute("schedule_id", s.getId());
		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedules/edit.jsp");
		rd.forward(request, response);
	}

}
