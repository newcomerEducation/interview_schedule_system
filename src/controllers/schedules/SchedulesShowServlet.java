package controllers.schedules;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Schedule;
import utils.DBUtil;

/**
 * Servlet implementation class SchedulesShowServlet
 */
@WebServlet("/schedules/show")
public class SchedulesShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchedulesShowServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("HH:mm");

        Schedule s = em.find(Schedule.class, Integer.parseInt(request.getParameter("id")));


        em.close();


        //時間だけ切り離して別の変数としてセット
        LocalDateTime time = s.getFirst_interview_scheduled_time();
    	//if(time != null ){
    	//System.out.println(time);
    	String datetime = datetimeformatter.format(time);

    	request.setAttribute("datetime",  datetime);

    	 LocalDateTime secondTime = s.getD_SecondInterviewScheduledTime();
    	 String secondDateTime = datetimeformatter.format(secondTime);

    	 request.setAttribute("secondDateTime",  secondDateTime);


        request.setAttribute("schedule", s);
        request.setAttribute("_token", request.getSession().getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedules/show.jsp");
        rd.forward(request, response);
    }

}
