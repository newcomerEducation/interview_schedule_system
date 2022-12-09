package controllers.schedules;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
 * Servlet implementation class TopPageIndexServlet
 */
@WebServlet("/schedules/mySchedule")
public class ShowMyScheduleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMyScheduleServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Employee login_employee = (Employee)request.getSession().getAttribute("login_employee");

        int page;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }
        //ここから面談予定一覧

        DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("HH:mm");

        List<Schedule> schedules = em.createNamedQuery("getMyAllSchedules", Schedule.class)
                .setParameter("employee", login_employee)
                .setFirstResult(15 * (page - 1))
                .setMaxResults(15)
                .getResultList();



        for(Schedule schedule : schedules){
        	LocalDateTime time = schedule.getFirst_interview_scheduled_time();
        	if(time != null ){
        	System.out.println(time);
        	String datetime = datetimeformatter.format(time);

        	request.setAttribute("datetime",  datetime);
        }else if(time == null){
        	String datetime = null;
        	request.setAttribute("datetime",  datetime);
        }
        	}

       // Schedule schedule = new  Schedule();

        //LocalDateTime time = schedule.getFirst_interview_scheduled_time();

       // String datetime = datetimeformatter.format(time);



        long schedules_count = (long)em.createNamedQuery("getMySchedulesCount", Long.class)
                .setParameter("employee", login_employee)
                .getSingleResult();

        em.close();

        //request.setAttribute("datetime",  datetime);

        request.setAttribute("schedules", schedules);
        request.setAttribute("schedules_count", schedules_count);
        request.setAttribute("page", page);

        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }
        //ここまで

     //   RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/menu/menu.jsp");
       RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/topPage/index.jsp");
        rd.forward(request, response);
    }

}
