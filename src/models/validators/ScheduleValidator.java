package models.validators;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import models.Schedule;

public class ScheduleValidator {


	//大幅に変更。詳細は000.先行開発→030.製造→面談予定登録機能_必須項目対応表を参照
	public static List<String> validate(Schedule s) {
		List<String> errors = new ArrayList<String>();

		String project_title_error = validateProjectTitle(s.getProject_title());
		if (!project_title_error.equals("")) {
			errors.add(project_title_error);
		}

		String ordering_company_error = validateOrderingCompany(s.getOrdering_company());
		if (!ordering_company_error.equals("")) {
			errors.add(ordering_company_error);
		}

		String number_of_interviews_error = validateNumberOfInterviews(s.getNumber_of_interviews());
		if (!number_of_interviews_error.equals("")) {
			errors.add(number_of_interviews_error);
		}

		String first_datetime_error = validateDateTime(s.getFirst_interview_scheduled_date(),
				s.getFirst_interview_scheduled_time());
		if (!first_datetime_error.equals("")) {
			errors.add(first_datetime_error);
		}

		String second_datetime_error = validateSecondDateTime(s.getD_SecondInterviewScheduledDate(),
				s.getD_SecondInterviewScheduledTime());
		if (!second_datetime_error.equals("")) {
			errors.add(second_datetime_error);
		}

		String validateEmployeeComfirmed2_error = validateEmployeeComfirmed2(s.getInterview_situation(),
				s.getV_EmployeeComfirmedResultNG(), s.getV_InterviewResultNG());
		if (!validateEmployeeComfirmed2_error.equals("")) {
			errors.add(validateEmployeeComfirmed2_error);
		}

		String validateEmployeeComfirmed3_error = validateEmployeeComfirmed3(s.getInterview_situation(),
				s.getV_EmployeeComfirmedResultNG(), s.getV_InterviewResultNG(), s.getFirst_interview_scheduled_date(),
				s.getFirst_interview_scheduled_time(), s.getFirst_interview_format(), s.getFirst_interview_tool(),
				s.getFirst_interview_url(), s.getFirst_interview_id(), s.getFirst_interview_password());
		if (!validateEmployeeComfirmed3_error.equals("")) {
			errors.add(validateEmployeeComfirmed3_error);

		}

		String validateEmployeeComfirmed4_error = validateEmployeeComfirmed4(s.getInterview_situation(),
				s.getV_EmployeeComfirmedResultNG(), s.getV_InterviewResultNG(), s.getFirst_interview_scheduled_date(),
				s.getFirst_interview_scheduled_time(), s.getFirst_interview_format(), s.getFirst_interview_tool(),
				s.getFirst_interview_url(), s.getFirst_interview_id(), s.getFirst_interview_password());
		if (!validateEmployeeComfirmed4_error.equals("")) {
			errors.add(validateEmployeeComfirmed4_error);

		}

		String validateEmployeeComfirmed5_error = validateEmployeeComfirmed5(s.getInterview_situation(),
				s.getV_EmployeeComfirmedResultNG(), s.getV_InterviewResultNG(), s.getFirst_interview_scheduled_date(),
				s.getFirst_interview_scheduled_time(), s.getFirst_interview_format(), s.getFirst_interview_tool(),
				s.getFirst_interview_url(), s.getFirst_interview_id(), s.getFirst_interview_password());
		if (!validateEmployeeComfirmed5_error.equals("")) {
			errors.add(validateEmployeeComfirmed5_error);

		}

		String validateEmployeeComfirmed6_error = validateEmployeeComfirmed6(s.getInterview_situation(),
				s.getV_EmployeeComfirmedResultNG(), s.getV_InterviewResultNG(), s.getFirst_interview_scheduled_date(),
				s.getFirst_interview_scheduled_time(), s.getFirst_interview_format(), s.getFirst_interview_tool(),
				s.getFirst_interview_url(), s.getFirst_interview_id(), s.getFirst_interview_password(),
				s.getNumber_of_interviews(), s.getD_SecondInterviewScheduledDate(),
				s.getD_SecondInterviewScheduledTime(), s.getV_SecondInterviewFormat(), s.getV_SecondInterviewTool(),
				s.getV_SecondInterviewUrl(), s.getV_SecondInterviewId(), s.getV_SecondInterviewPW());
		if (!validateEmployeeComfirmed6_error.equals("")) {
			errors.add(validateEmployeeComfirmed6_error);

		}

		String validateEmployeeComfirmed7_error = validateEmployeeComfirmed7(s.getInterview_situation(),
				s.getV_EmployeeComfirmedResultNG(), s.getV_InterviewResultNG(), s.getFirst_interview_scheduled_date(),
				s.getFirst_interview_scheduled_time(), s.getFirst_interview_format(), s.getFirst_interview_tool(),
				s.getFirst_interview_url(), s.getFirst_interview_id(), s.getFirst_interview_password(),
				s.getNumber_of_interviews(), s.getD_SecondInterviewScheduledDate(),
				s.getD_SecondInterviewScheduledTime(), s.getV_SecondInterviewFormat(), s.getV_SecondInterviewTool(),
				s.getV_SecondInterviewUrl(), s.getV_SecondInterviewId(), s.getV_SecondInterviewPW());
		if (!validateEmployeeComfirmed7_error.equals("")) {
			errors.add(validateEmployeeComfirmed7_error);

		}

		String validateEmployeeComfirmed8_error = validateEmployeeComfirmed8(s.getInterview_situation(),
				s.getV_EmployeeComfirmedResultNG(), s.getV_InterviewResultNG(), s.getFirst_interview_scheduled_date(),
				s.getFirst_interview_scheduled_time(), s.getFirst_interview_format(), s.getFirst_interview_tool(),
				s.getFirst_interview_url(), s.getFirst_interview_id(), s.getFirst_interview_password(),
				s.getNumber_of_interviews(), s.getD_SecondInterviewScheduledDate(),
				s.getD_SecondInterviewScheduledTime(), s.getV_SecondInterviewFormat(), s.getV_SecondInterviewTool(),
				s.getV_SecondInterviewUrl(), s.getV_SecondInterviewId(), s.getV_SecondInterviewPW());
		if (!validateEmployeeComfirmed8_error.equals("")) {
			errors.add(validateEmployeeComfirmed8_error);

		}

		String validateEmployeeComfirmed9_error = validateEmployeeComfirmed9(s.getV_EmployeeComfirmedResultNG(),
				s.getInterview_situation(), s.getV_InterviewResultNG());
		if (!validateEmployeeComfirmed9_error.equals("")) {
			errors.add(validateEmployeeComfirmed9_error);

		}

		String validateEmployeeComfirmed10_error = validateEmployeeComfirmed10(s.getInterview_situation(),
				s.getV_EmployeeComfirmedResultNG(), s.getV_InterviewResultNG(), s.getFirst_interview_scheduled_date(),
				s.getFirst_interview_scheduled_time(), s.getFirst_interview_format(), s.getFirst_interview_tool(),
				s.getFirst_interview_url(), s.getFirst_interview_id(), s.getFirst_interview_password(),
				s.getNumber_of_interviews(), s.getD_SecondInterviewScheduledDate(),
				s.getD_SecondInterviewScheduledTime(), s.getV_SecondInterviewFormat(), s.getV_SecondInterviewTool(),
				s.getV_SecondInterviewUrl(), s.getV_SecondInterviewId(), s.getV_SecondInterviewPW());
		if (!validateEmployeeComfirmed10_error.equals("")) {
			errors.add(validateEmployeeComfirmed10_error);

		}

		String validateEmployeeComfirmed11_error = validateEmployeeComfirmed11(s.getInterview_situation(),
				s.getV_EmployeeComfirmedResultNG(), s.getV_InterviewResultNG(), s.getFirst_interview_scheduled_date(),
				s.getFirst_interview_scheduled_time(), s.getFirst_interview_format(), s.getFirst_interview_tool(),
				s.getFirst_interview_url(), s.getFirst_interview_id(), s.getFirst_interview_password(),
				s.getNumber_of_interviews(), s.getD_SecondInterviewScheduledDate(),
				s.getD_SecondInterviewScheduledTime(), s.getV_SecondInterviewFormat(), s.getV_SecondInterviewTool(),
				s.getV_SecondInterviewUrl(), s.getV_SecondInterviewId(), s.getV_SecondInterviewPW());
		if (!validateEmployeeComfirmed11_error.equals("")) {
			errors.add(validateEmployeeComfirmed11_error);

		}

		return errors;
	}

	private static String validateProjectTitle(String project_title) {
		if (project_title == null || project_title.equals("")) {
			return "案件名を入力してください";
		}
		return "";
	}

	private static String validateOrderingCompany(String ordering_company) {
		if (ordering_company == null || ordering_company.equals("")) {
			return "得意先会社名を入力してください";
		}
		return "";
	}

	private static String validateNumberOfInterviews(Integer number_of_interviews) {
		if (number_of_interviews == null) {
			return "面談回数を入力してください";
		}
		return "";
	}

	// 日付時間入力のバリデーター
	private static String validateDateTime(Date first_interview_scheduled_date,
			LocalDateTime first_interview_scheduled_time) {
		if (first_interview_scheduled_date == null && first_interview_scheduled_time != null) {
			return "一次：日付を入力してください";
		} else if (first_interview_scheduled_date != null && first_interview_scheduled_time == null) {
			return "一次：時間を入力してください";
		} else {
			return "";
		}
	}

	private static String validateSecondDateTime(Date d_SecondInterviewScheduledDate,
			LocalDateTime d_SecondInterviewScheduledTime) {
		if (d_SecondInterviewScheduledDate == null && d_SecondInterviewScheduledTime != null) {
			return "二次：日付を入力してください";
		} else if (d_SecondInterviewScheduledDate != null && d_SecondInterviewScheduledTime == null) {
			return "二次：時間を入力してください";
		} else {
			return "";
		}
	}

	private static String validateEmployeeComfirmed2(int interview_situation, String v_EmployeeComfirmedResultNG,
			String v_InterviewResultNG) {
		if (interview_situation == 2) {
			if (!(v_EmployeeComfirmedResultNG.equals("")) || !(v_InterviewResultNG.equals(""))) {
				return "面談ステータス：面談日程調整中の場合、本人面談辞退理由と見送り理由は記述できません";
			}
		}
		return "";
	}

	private static String validateEmployeeComfirmed3(int interview_situation, String v_EmployeeComfirmedResultNG,
			String v_InterviewResultNG, Date first_interview_scheduled_date,
			LocalDateTime first_interview_scheduled_time, int first_interview_format, String first_interview_tool,
			String first_interview_url, String first_interview_id, String first_interview_password) {
		if (interview_situation == 3) {
			if (!(v_EmployeeComfirmedResultNG.equals("")) || !(v_InterviewResultNG.equals(""))) {
				return "面談ステータス：面談日程確定(一次)の場合、本人面談辞退理由と見送り理由は記述できません";
			} else if (first_interview_scheduled_date == null || first_interview_scheduled_time == null
					|| first_interview_format == 0) {
				return "面談ステータス：面談日程確定(一次)の場合、日時、形式を入力してください。";
			} else if (first_interview_format == 2) {
				if (first_interview_tool.equals("") || first_interview_url.equals("") || first_interview_id.equals("")
						|| first_interview_password.equals("")) {
					return "形式：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}
			}
		}
		return "";
	}

	private static String validateEmployeeComfirmed4(int interview_situation, String v_EmployeeComfirmedResultNG,
			String v_InterviewResultNG, Date first_interview_scheduled_date,
			LocalDateTime first_interview_scheduled_time, int first_interview_format, String first_interview_tool,
			String first_interview_url, String first_interview_id, String first_interview_password) {
		if (interview_situation == 4) {
			if (!(v_EmployeeComfirmedResultNG.equals("")) || !(v_InterviewResultNG.equals(""))) {
				return "面談ステータス：面談結果待ち(一次)の場合、本人面談辞退理由と見送り理由は記述できません";
			} else if (first_interview_scheduled_date == null || first_interview_scheduled_time == null
					|| first_interview_format == 0) {
				return "面談ステータス：面談結果待ち(一次)の場合、日時、形式を入力してください。";
			} else if (first_interview_format == 2) {
				if (first_interview_tool.equals("") || first_interview_url.equals("") || first_interview_id.equals("")
						|| first_interview_password.equals("")) {
					return "形式：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}
			}
		}
		return "";
	}

	private static String validateEmployeeComfirmed5(int interview_situation, String v_EmployeeComfirmedResultNG,
			String v_InterviewResultNG, Date first_interview_scheduled_date,
			LocalDateTime first_interview_scheduled_time, int first_interview_format, String first_interview_tool,
			String first_interview_url, String first_interview_id, String first_interview_password) {
		if (interview_situation == 5) {
			if (!(v_EmployeeComfirmedResultNG.equals("")) || !(v_InterviewResultNG.equals(""))) {
				return "面談ステータス：一次面談実施済みの場合、本人面談辞退理由と見送り理由は記述できません";
			} else if (first_interview_scheduled_date == null || first_interview_scheduled_time == null
					|| first_interview_format == 0) {
				return "面談ステータス：一次面談実施済みの場合、一次面談の日時、形式を入力してください。";
			} else if (first_interview_format == 2) {
				if (first_interview_tool.equals("") || first_interview_url.equals("") || first_interview_id.equals("")
						|| first_interview_password.equals("")) {
					return "形式：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}
			}
		}
		return "";
	}

	private static String validateEmployeeComfirmed6(int interview_situation, String v_EmployeeComfirmedResultNG,
			String v_InterviewResultNG, Date first_interview_scheduled_date,
			LocalDateTime first_interview_scheduled_time, int first_interview_format, String first_interview_tool,
			String first_interview_url, String first_interview_id, String first_interview_password,
			Integer number_of_interviews, Date d_SecondInterviewScheduledDate,
			LocalDateTime d_SecondInterviewScheduledTime, int v_SecondInterviewFormat, String v_SecondInterviewTool,
			String v_SecondInterviewUrl, String v_SecondInterviewId, String v_SecondInterviewPW) {
		if (interview_situation == 6 && number_of_interviews >= 2) {
			if (!(v_EmployeeComfirmedResultNG.equals("")) || !(v_InterviewResultNG.equals(""))) {
				return "面談ステータス：二次面談日程確定の場合、本人面談辞退理由と見送り理由は記述できません";
			} else if (first_interview_scheduled_date == null || first_interview_scheduled_time == null
					|| first_interview_format == 0) {
				return "面談ステータス：二次面談日程確定の場合、一次面談の日時、形式は空欄にできません。";
			} else if (!(first_interview_scheduled_date.equals("null"))
					&& !(first_interview_scheduled_time.equals("null")) && first_interview_format == 2) {
				if (first_interview_tool.equals("") || first_interview_url.equals("") || first_interview_id.equals("")
						|| first_interview_password.equals("")) {
					return "形式（一次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";

				}
			} else if ((interview_situation == 6 && number_of_interviews >= 2 && d_SecondInterviewScheduledDate == null) || (interview_situation == 6 && number_of_interviews >= 2 && d_SecondInterviewScheduledTime == null)
					|| (interview_situation == 6 && number_of_interviews >= 2 && v_SecondInterviewFormat == 0)) {
				return "面談ステータス：二次面談日程確定済みの場合、二次面談の日時、形式は空欄にできません。";
			} else if (v_SecondInterviewFormat == 2) {
				if (v_SecondInterviewTool.equals("") || v_SecondInterviewUrl.equals("")
						|| v_SecondInterviewId.equals("") || v_SecondInterviewPW.equals("")) {
					return "形式（二次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";

				}
			}
		} else if (interview_situation == 6 && number_of_interviews != null && number_of_interviews < 2) {
			return "面談回数が正しくありません。";
		}
		return "";
	}

	private static String validateEmployeeComfirmed7(int interview_situation, String v_EmployeeComfirmedResultNG,
			String v_InterviewResultNG, Date first_interview_scheduled_date,
			LocalDateTime first_interview_scheduled_time, int first_interview_format, String first_interview_tool,
			String first_interview_url, String first_interview_id, String first_interview_password,
			Integer number_of_interviews, Date d_SecondInterviewScheduledDate,
			LocalDateTime d_SecondInterviewScheduledTime, int v_SecondInterviewFormat, String v_SecondInterviewTool,
			String v_SecondInterviewUrl, String v_SecondInterviewId, String v_SecondInterviewPW) {
		if (interview_situation == 7 && number_of_interviews >= 2) {
			if (!(v_EmployeeComfirmedResultNG.equals("")) || !(v_InterviewResultNG.equals(""))) {
				return "面談ステータス：二次面談結果待ちの場合、本人面談辞退理由と見送り理由は記述できません";
			} else if (first_interview_scheduled_date == null || first_interview_scheduled_time == null
					|| first_interview_format == 0) {
				return "面談ステータス：二次面談結果待ちの場合、一次面談の日時、形式は空欄にできません。";
			} else if (first_interview_format == 2) {
				if (first_interview_tool.equals("") || first_interview_url.equals("") || first_interview_id.equals("")
						|| first_interview_password.equals("")) {
					return "形式（一次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}

				} else if ((interview_situation == 7 && number_of_interviews >= 2 && d_SecondInterviewScheduledDate == null) ||(interview_situation == 7 && number_of_interviews >= 2 && d_SecondInterviewScheduledTime == null)
						||(interview_situation == 7 && number_of_interviews >= 2&& v_SecondInterviewFormat == 0)) {
					return "面談ステータス：二次面談結果待ちの場合、二次面談の日時、形式は空欄にできません。";
				} else if (v_SecondInterviewFormat == 2) {
					if (v_SecondInterviewTool.equals("") || v_SecondInterviewUrl.equals("")
							|| v_SecondInterviewId.equals("") || v_SecondInterviewPW.equals("")) {
						return "形式（二次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";

				}
			}
		} else if (interview_situation == 7 && number_of_interviews != null && number_of_interviews < 2) {
			return "面談予定回数が正しくありません。";
		}
		return "";
	}

	private static String validateEmployeeComfirmed8(int interview_situation, String v_EmployeeComfirmedResultNG,
			String v_InterviewResultNG, Date first_interview_scheduled_date,
			LocalDateTime first_interview_scheduled_time, int first_interview_format, String first_interview_tool,
			String first_interview_url, String first_interview_id, String first_interview_password,
			Integer number_of_interviews, Date d_SecondInterviewScheduledDate,
			LocalDateTime d_SecondInterviewScheduledTime, int v_SecondInterviewFormat, String v_SecondInterviewTool,
			String v_SecondInterviewUrl, String v_SecondInterviewId, String v_SecondInterviewPW) {
		if (interview_situation == 8 && number_of_interviews >= 2) {
			if (!(v_EmployeeComfirmedResultNG.equals(""))) {
				return "面談ステータス：見送りの場合、本人面談辞退理由は記述できません";
			} else if (first_interview_scheduled_date == null || first_interview_scheduled_time == null
					|| first_interview_format == 0) {
				return "面談ステータス：見送りの場合、一次面談の日時、形式は空欄にできません。";
			} else if (first_interview_format == 2) {
				if (first_interview_tool.equals("") || first_interview_url.equals("") || first_interview_id.equals("")
						|| first_interview_password.equals("")) {
					return "形式（一次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}
			} else if (d_SecondInterviewScheduledDate == null || d_SecondInterviewScheduledTime == null
					|| v_SecondInterviewFormat == 0) {
				return "面談ステータス：見送りの場合、二次面談の日時、形式は空欄にできません。";
			} else if (v_SecondInterviewFormat == 2) {
				if (v_SecondInterviewTool.equals("") || v_SecondInterviewUrl.equals("")
						|| v_SecondInterviewId.equals("") || v_SecondInterviewPW.equals("")) {
					return "形式（二次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}
			} else if (v_InterviewResultNG.equals("")) {
				return "面談ステータス：見送りの場合、見送り理由を入力してください";
			}
		} else if (interview_situation == 8 && number_of_interviews == 1) {
			if (!(v_EmployeeComfirmedResultNG.equals(""))) {
				return "面談ステータス：見送りの場合、本人面談辞退理由は記述できません";
			} else if (first_interview_scheduled_date == null || first_interview_scheduled_time == null
					|| first_interview_format == 0) {
				return "面談ステータス：見送りの場合、一次面談の日時、形式は空欄にできません。";
			} else if (first_interview_format == 2) {
				if (first_interview_tool.equals("") || first_interview_url.equals("") || first_interview_id.equals("")
						|| first_interview_password.equals("")) {
					return "形式（一次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}
			} else if (v_InterviewResultNG.equals("")) {
				return "面談ステータス：見送りの場合、見送り理由を入力してください";
			}
		}
		return "";
	}

	private static String validateEmployeeComfirmed9(String v_EmployeeComfirmedResultNG, int interview_situation,
			String v_InterviewResultNG) {
		if (interview_situation == 9) {
			if (!(v_InterviewResultNG.equals(""))) {
				return "面談ステータス：本人辞退の場合、見送り理由は記入できません";
			} else if (v_EmployeeComfirmedResultNG.equals("")) {
				return "面談ステータス：本人辞退の場合、本人面談辞退理由を記入してください。";
			}
		}
		return "";
	}

	private static String validateEmployeeComfirmed10(int interview_situation, String v_EmployeeComfirmedResultNG,
			String v_InterviewResultNG, Date first_interview_scheduled_date,
			LocalDateTime first_interview_scheduled_time, int first_interview_format, String first_interview_tool,
			String first_interview_url, String first_interview_id, String first_interview_password,
			Integer number_of_interviews, Date d_SecondInterviewScheduledDate,
			LocalDateTime d_SecondInterviewScheduledTime, int v_SecondInterviewFormat, String v_SecondInterviewTool,
			String v_SecondInterviewUrl, String v_SecondInterviewId, String v_SecondInterviewPW) {
		if (interview_situation == 10 && number_of_interviews >= 2) {
			if (!(v_EmployeeComfirmedResultNG.equals("")) || !(v_InterviewResultNG.equals(""))) {
				return "参画日調整中の場合、本人面談辞退理由と見送り理由は記述できません";
			} else if (first_interview_scheduled_date == null || first_interview_scheduled_time == null
					|| first_interview_format == 0) {
				return "参画日調整中の場合、一次面談の日時、形式は空欄にできません。";
			} else if (first_interview_format == 2) {
				if (first_interview_tool.equals("") || first_interview_url.equals("") || first_interview_id.equals("")
						|| first_interview_password.equals("")) {
					return "形式（一次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}
			} else if (d_SecondInterviewScheduledDate == null || d_SecondInterviewScheduledTime == null
					|| v_SecondInterviewFormat == 0) {
				return "面談回数が２以上かつ面談ステータス：参画日調整中の場合、二次面談の日時、形式は空欄にできません。";
			} else if (v_SecondInterviewFormat == 2) {
				if (v_SecondInterviewTool.equals("") || v_SecondInterviewUrl.equals("")
						|| v_SecondInterviewId.equals("") || v_SecondInterviewPW.equals("")) {
					return "形式（二次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}
			}
		} else if (interview_situation == 10 && number_of_interviews == 1) {
			if (!(v_EmployeeComfirmedResultNG.equals("")) || !(v_InterviewResultNG.equals(""))) {
				return "参画日調整中の場合、本人面談辞退理由と見送り理由は記述できません";
			} else if (first_interview_scheduled_date == null || first_interview_scheduled_time == null
					|| first_interview_format == 0) {
				return "参画日調整中の場合、一次面談の日時、形式は空欄にできません。";
			} else if (first_interview_format == 2) {
				if (first_interview_tool.equals("") || first_interview_url.equals("") || first_interview_id.equals("")
						|| first_interview_password.equals("")) {
					return "形式（一次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}
			}
		}
		return "";
	}

	private static String validateEmployeeComfirmed11(int interview_situation, String v_EmployeeComfirmedResultNG,
			String v_InterviewResultNG, Date first_interview_scheduled_date,
			LocalDateTime first_interview_scheduled_time, int first_interview_format, String first_interview_tool,
			String first_interview_url, String first_interview_id, String first_interview_password,
			Integer number_of_interviews, Date d_SecondInterviewScheduledDate,
			LocalDateTime d_SecondInterviewScheduledTime, int v_SecondInterviewFormat, String v_SecondInterviewTool,
			String v_SecondInterviewUrl, String v_SecondInterviewId, String v_SecondInterviewPW) {
		if (interview_situation == 11 && number_of_interviews >= 2) {
			if (!(v_EmployeeComfirmedResultNG.equals("")) || !(v_InterviewResultNG.equals(""))) {
				return "参画日決定の場合、本人面談辞退理由と見送り理由は記述できません";
			} else if (first_interview_scheduled_date == null || first_interview_scheduled_time == null
					|| first_interview_format == 0) {
				return "参画日決定の場合、一次面談の日時、形式は空欄にできません。";
			} else if (first_interview_format == 2) {
				if (first_interview_tool.equals("") || first_interview_url.equals("") || first_interview_id.equals("")
						|| first_interview_password.equals("")) {
					return "形式（一次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}
			} else if (d_SecondInterviewScheduledDate == null || d_SecondInterviewScheduledTime == null
					|| v_SecondInterviewFormat == 0) {
				return "面談回数が２以上かつ面談ステータス：参画日決定の場合、二次面談の日時、形式は空欄にできません。";
			} else if (v_SecondInterviewFormat == 2) {
				if (v_SecondInterviewTool.equals("") || v_SecondInterviewUrl.equals("")
						|| v_SecondInterviewId.equals("") || v_SecondInterviewPW.equals("")) {
					return "形式（二次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}
			}
		} else if (interview_situation == 11 && number_of_interviews == 1) {
			if (!(v_EmployeeComfirmedResultNG.equals("")) || !(v_InterviewResultNG.equals(""))) {
				return "参画日決定の場合、本人面談辞退理由と見送り理由は記述できません";
			} else if (first_interview_scheduled_date == null || first_interview_scheduled_time == null
					|| first_interview_format == 0) {
				return "参画日決定の場合、一次面談の日時、形式は空欄にできません。";
			} else if (first_interview_format == 2) {
				if (first_interview_tool.equals("") || first_interview_url.equals("") || first_interview_id.equals("")
						|| first_interview_password.equals("")) {
					return "形式（一次）：オンラインの場合、ツール・URL・ID・パスワードは全て入力してください。";
				}
			}
		}
		return "";
	}

}
