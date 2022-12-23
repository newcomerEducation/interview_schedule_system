package controllers.schedules;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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
import models.validators.ScheduleValidator;
import utils.DBUtil;

/**
 * Servlet implementation class SchedulesCreateServlet
 */
@WebServlet("/schedules/create")
public class SchedulesCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SchedulesCreateServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String _token = request.getParameter("_token");
		if (_token != null && _token.equals(request.getSession().getId())) {
			EntityManager em = DBUtil.createEntityManager();

			Schedule s = new Schedule();

			// Employee情報の設定
			s.setEmployee((Employee) request.getSession().getAttribute("login_employee"));

			// ログインユーザーのIDを取得、格納
			Employee loginEmployee = new Employee();
			loginEmployee = s.getEmployee();
			s.setSales_employee(loginEmployee);

			// 更新機能では非活性、登録者id
			s.setI_RegistId(loginEmployee.getId());
			// 更新機能でidを入れる
			s.setI_LastUpdateId(0);

			// テナントは現状０のみ、追加開発でいじるかも
			s.setI_TenantId(0);

			s.setProject_title(request.getParameter("project_title"));
			s.setPlace(request.getParameter("place"));
			s.setOrdering_company(request.getParameter("ordering_company"));
			s.setV_OrderedCompany_SalesName(request.getParameter("v_OrderedCompany_SalesName"));

			// Employee情報の設定
			Employee employee = em.find(Employee.class, Integer.parseInt(request.getParameter("employee_id")));
			s.setEmployee(employee);
			s.setDepartment(employee.getDepartment());

			Date introduce_date = new Date(System.currentTimeMillis());
			String introduce_date_str = request.getParameter("introduce_date");
			if (introduce_date_str != null && !introduce_date_str.equals("")) {
				introduce_date = Date.valueOf(request.getParameter("introduce_date"));
			}
			s.setIntroduce_date(introduce_date);

			s.setProject_overview(request.getParameter("project_overview"));

			Integer number_of_interviews = null;
			String number_of_interviews_str = request.getParameter("number_of_interviews");
			if (number_of_interviews_str != null && !number_of_interviews_str.equals("")) {
				number_of_interviews = Integer.parseInt(request.getParameter("number_of_interviews"));
			}
			s.setNumber_of_interviews(number_of_interviews);

			Integer priority = null;
			String priority_str = request.getParameter("priority");
			if (priority_str != null && !priority_str.equals("")) {
				priority = Integer.parseInt(request.getParameter("priority"));
			}
			s.setPriority(priority);

			Integer aspiration_situation = null;
			String aspiration_situation_str = request.getParameter("aspiration_situation");
			if (aspiration_situation_str != null && !aspiration_situation_str.equals("")) {
				aspiration_situation = Integer.parseInt(request.getParameter("aspiration_situation"));
			}
			s.setAspiration_situation(aspiration_situation);

			s.setV_EmployeeComfirmedResultNG(request.getParameter("v_EmployeeComfirmedResultNG"));

			s.setV_AccountingSlackLink(request.getParameter("v_AccountingSlackLink"));

			Integer interview_situation = null;
			String interview_situation_str = request.getParameter("interview_situation");
			if (interview_situation_str != null && !interview_situation_str.equals("")) {
				interview_situation = Integer.parseInt(request.getParameter("interview_situation"));
			}
			s.setInterview_situation(interview_situation);

			Date first_interview_scheduled_date = null;
			String first_interview_scheduled_date_str = request.getParameter("first_interview_scheduled_date");
			if (first_interview_scheduled_date_str != null && !first_interview_scheduled_date_str.equals("")) {
				first_interview_scheduled_date = Date.valueOf(request.getParameter("first_interview_scheduled_date"));
			}
			s.setFirst_interview_scheduled_date(first_interview_scheduled_date);

			// だいぶ作り替えた
			// バリデーター作成済み
			LocalDateTime first_interview_scheduled_time = null;

			if (first_interview_scheduled_date == null) {
				String firstDate = "1111-11-11";
				String firstTime = request.getParameter("first_interview_scheduled_time");
				// String first_interview_scheduled_time_str =
				// request.getParameter("first_interview_scheduled_time");
				if (firstTime != null && !firstTime.equals("")) {
					first_interview_scheduled_time = LocalDateTime.parse(firstDate + "T" + firstTime);
				} // else {
					// first_interview_scheduled_time =null;
					// }
			} else if (first_interview_scheduled_date != null) {
				String firstDate = first_interview_scheduled_date.toString();

				String firstTime = request.getParameter("first_interview_scheduled_time");

				if (firstTime != null && !firstTime.equals("")) {
					first_interview_scheduled_time = LocalDateTime.parse(firstDate + "T" + firstTime);
				}
			}
			s.setFirst_interview_scheduled_time(first_interview_scheduled_time);

			Integer first_interview_format = null;
			String first_interview_format_str = request.getParameter("first_interview_format");
			if (first_interview_format_str != null && !first_interview_format_str.equals("")) {
				first_interview_format = Integer.parseInt(request.getParameter("first_interview_format"));
			}
			s.setFirst_interview_format(first_interview_format);

			s.setFirst_interview_tool(request.getParameter("first_interview_tool"));
			s.setFirst_interview_url(request.getParameter("first_interview_url"));
			s.setFirst_interview_id(request.getParameter("first_interview_id"));
			s.setFirst_interview_password(request.getParameter("first_interview_password"));

			Date second_interview_scheduled_date = null;
			String second_interview_scheduled_date_str = request.getParameter("d_SecondInterviewScheduledDate");
			if (second_interview_scheduled_date_str != null && !second_interview_scheduled_date_str.equals("")) {
				second_interview_scheduled_date = Date.valueOf(request.getParameter("d_SecondInterviewScheduledDate"));
			}
			s.setD_SecondInterviewScheduledDate(second_interview_scheduled_date);

			LocalDateTime second_interview_scheduled_time = null;
			if (second_interview_scheduled_date == null) {
				String secondDate = "1111-11-11";
				String secondTime = request.getParameter("d_SecondInterviewScheduledTime");

				if (secondTime != null && !secondTime.equals("")) {
					second_interview_scheduled_time = LocalDateTime.parse(secondDate + "T" + secondTime);
				}
			} else if (second_interview_scheduled_date != null) {

				String secondDate = second_interview_scheduled_date.toString();
				String secondTime = request.getParameter("d_SecondInterviewScheduledTime");

				if (secondTime != null && !secondTime.equals("")) {
					second_interview_scheduled_time = LocalDateTime.parse(secondDate + "T" + secondTime);

				}
			}

			s.setD_SecondInterviewScheduledTime(second_interview_scheduled_time);

			Integer v_SecondInterviewFormat = null;
			String v_SecondInterviewFormat_str = request.getParameter("v_SecondInterviewFormat");
			if (v_SecondInterviewFormat_str != null && !v_SecondInterviewFormat_str.equals("")) {
				v_SecondInterviewFormat = Integer.parseInt(request.getParameter("v_SecondInterviewFormat"));

			}

			s.setV_SecondInterviewFormat(v_SecondInterviewFormat);

			s.setV_SecondInterviewTool(request.getParameter("v_SecondInterviewTool"));
			s.setV_SecondInterviewUrl(request.getParameter("v_SecondInterviewUrl"));
			s.setV_SecondInterviewId(request.getParameter("v_SecondInterviewId"));
			s.setV_SecondInterviewPW(request.getParameter("v_SecondInterviewPW"));

			s.setV_InterviewResultNG(request.getParameter("v_InterviewResultNG"));

			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			s.setCreated_at(currentTime);
			s.setUpdated_at(currentTime);
			s.setIs_deleted(0);

			// 入力確認バリデータ
			List<String> errors = ScheduleValidator.validate(s);
			if (errors.size() > 0) {

				// 社員情報一覧表示のため社員情報テーブルのデータを取得する
				// 一般社員のリスト取得クエリに変更
				List<Employee> employees = em.createNamedQuery("getAllGeneralEmployeesNotDeleted", Employee.class)

						.getResultList();
				request.setAttribute("employees", employees);

				em.close();

				request.setAttribute("_token", request.getSession().getId());
				request.setAttribute("schedule", s);
				request.setAttribute("errors", errors);

				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedules/new.jsp");
				rd.forward(request, response);
			} else {
				em.getTransaction().begin();
				em.persist(s);
				em.getTransaction().commit();
				em.close();
				request.getSession().setAttribute("flush", "登録が完了しました。");

				response.sendRedirect(request.getContextPath() + "/schedules/index");
			}

		}
	}

}
