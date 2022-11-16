package controllers.login;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    // ログイン画面を表示
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("hasError", false);
        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    // ログイン処理を実行
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 認証結果を格納する変数
        Boolean check_result = false;
        //入力された文字列を格納する変数、パスワードは平文として格納
        String employee_code = request.getParameter("employee_code");
        String plain_pass = request.getParameter("password");

        //Employee型の変数eを定義
        Employee e = null;

        //入力された文字列が空欄でないとき
        if(employee_code != null && !employee_code.equals("") && plain_pass != null && !plain_pass.equals("")) {
        	//DB接続
            EntityManager em = DBUtil.createEntityManager();
            
            //DBからpasswordSaultを持ってくる
            //String passwordSault = Employee.javaで定義したselect文を実行、変数に値を格納
            //String passwordSault = em.createNamedQuery("getPasswordSault", Employee.class);
            //passwordという変数に平文とpepperという文字列を渡している→passwordSatltに変更する
            String password = EncryptUtil.getPasswordEncrypt(
                    plain_pass,
                    (String)this.getServletContext().getAttribute("pepper")
                    );

            // 社員番号とパスワードが正しいかチェックする
            try {
                e = em.createNamedQuery("checkLoginEmployeeCodeAndPassword", Employee.class)
                        .setParameter("employee_code", employee_code)
                        .setParameter("pass", password)
                        .getSingleResult();
            } catch (NoResultException ex) {}

            em.close();

            if(e != null) {
                check_result = true;
            }
        }

        if(!check_result) {
            // 認証できなかったらログイン画面に戻る
            request.setAttribute("_token", request.getSession().getId());
            request.setAttribute("hasError", true);
            request.setAttribute("employee_code", employee_code);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login/login.jsp");
            rd.forward(request, response);
        } else {
            // 認証できたらログイン状態にしてトップページへリダイレクト
            request.getSession().setAttribute("login_employee", e);

            request.getSession().setAttribute("flush", "ログインしました。");
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

}
