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

import models.Schedule;
import utils.DBUtil;

/**
 * Servlet implementation class SchedulesIndexServlet
 */
@WebServlet("/schedules/index")
public class SchedulesIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchedulesIndexServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        int page;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        } catch (Exception e) {
            page = 1;
        }

      //  DateTimeFormatter datetimeformatter = DateTimeFormatter.ofPattern("HH:mm");

        List<Schedule> schedules = em.createNamedQuery("getAllSchedules", Schedule.class)
                .setFirstResult(15 * (page - 1))
                .setMaxResults(15)
                .getResultList();

     // 一時面談時間
     	//	List<String> DateTimeList = new ArrayList<String>();
     	//	String datetime = "";

     	//	for (Schedule schedule : schedules) {
     	//		LocalDateTime time = schedule.getFirst_interview_scheduled_time();
     	//		if (time != null) {
     				// System.out.println(time);
     	//			datetime = datetimeformatter.format(time);

     				// request.setAttribute("datetime", datetime);
     	//		} else if (time == null) {
     				// datetime = "";
     				// request.setAttribute("datetime", datetime);
     		//	}
     	//		DateTimeList.add(datetime);
     	//	}

     		// 二次面談時間
     		//List<String> SecondDateTimeList = new ArrayList<String>();
     		//String secondDatetime = "";

     		//for (Schedule schedule : schedules) {
     		//	LocalDateTime secondTime = schedule.getD_SecondInterviewScheduledTime();

     		//	if (secondTime != null) {
     				// System.out.println(time);
     		//		secondDatetime = datetimeformatter.format(secondTime);

     		//	} else if (secondTime == null) {
     		//		// secondDatetime = "";
     		//	}
     		//	SecondDateTimeList.add(secondDatetime);
     		//}


        long schedules_count = (long)em.createNamedQuery("getSchedulesCount", Long.class)
                .getSingleResult();

        em.close();

      //  request.setAttribute("DateTimeList", DateTimeList);
		//request.setAttribute("SecondDateTimeList", SecondDateTimeList);
        request.setAttribute("schedules", schedules);
        request.setAttribute("schedules_count", schedules_count);
        request.setAttribute("page", page);
        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/schedules/index.jsp");
        rd.forward(request, response);

    }

}
