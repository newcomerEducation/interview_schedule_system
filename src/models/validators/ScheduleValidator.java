package models.validators;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import models.Schedule;

public class ScheduleValidator {

    public static List<String> validate(Schedule s) {
        List<String> errors = new ArrayList<String>();

        String project_title_error = validateProjectTitle(s.getProject_title());
        if(!project_title_error.equals("")) {
            errors.add(project_title_error);
        }

        String ordering_company_error = validateOrderingCompany(s.getOrdering_company());
        if(!ordering_company_error.equals("")) {
            errors.add(ordering_company_error);
        }

        String first_datetime_error = validateDateTime(s.getFirst_interview_scheduled_date(),s.getFirst_interview_scheduled_time());
        if(!first_datetime_error.equals("")){
        errors.add(first_datetime_error);
        }

        String second_datetime_error = validateSecondDateTime(s.getD_SecondInterviewScheduledDate(),s.getD_SecondInterviewScheduledTime());
        if(!second_datetime_error.equals("")){
        	errors.add(second_datetime_error);
        }



        return errors;
    }

    private static String validateProjectTitle(String project_title) {
        if(project_title == null || project_title.equals("")) {
            return "案件名を入力してください";
        }
        return "";
    }

    private static String validateOrderingCompany(String ordering_company) {
        if(ordering_company == null || ordering_company.equals("")) {
            return "上位会社（発注元企業）を入力してください";
        }
        return "";
    }

    //日付時間入力のバリデーター
    private static String validateDateTime(Date first_interview_scheduled_date,LocalDateTime first_interview_scheduled_time){
    if(first_interview_scheduled_date ==null && first_interview_scheduled_time != null){
    	return "一次：日付を入力してください";
    } else if(first_interview_scheduled_date != null && first_interview_scheduled_time == null){
    	return "一次：時間を入力してください";
    } else {
    return "";
    }
    }

    private static String validateSecondDateTime(Date d_SecondInterviewScheduledDate,LocalDateTime d_SecondInterviewScheduledTime){
    	if(d_SecondInterviewScheduledDate == null && d_SecondInterviewScheduledTime != null){
    		return "二次：日付を入力してください";
    	} else if(d_SecondInterviewScheduledDate != null && d_SecondInterviewScheduledTime == null){
    		return "二次：時間を入力してください";
    	} else {
    		return "";
    	}
    }


}
