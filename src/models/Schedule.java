package models;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "c_InterviewTran")
@NamedQueries({ @NamedQuery(name = "getAllSchedules", query = "SELECT s FROM Schedule AS s ORDER BY s.id DESC"),
		@NamedQuery(name = "getSchedulesCount", query = "SELECT COUNT(s) FROM Schedule AS s"),

		@NamedQuery(name = "getMyAllSchedules", query = "SELECT s FROM Schedule AS s WHERE s.employee = :employee ORDER BY s.id DESC"),

		@NamedQuery(name = "getMySchedulesCount", query = "SELECT COUNT(s) FROM Schedule AS s WHERE s.employee = :employee"), })
@Entity
public class Schedule {
	@Id
	@Column(name = "i_ProjectNo")

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	// 追加
	@Column(name = "v_OrderedCompany_SalesName", length = 255, nullable = false)
	private String v_OrderedCompany_SalesName;

	// 追加
	@Column(name = "i_TenantId")
	private Integer i_TenantId;

	// 本人面談希望
 	@Column(name = "i_EmployeeComfirmed", length = 255, nullable = false)
	private int aspiration_situation;

	// 追加
	@Column(name = "v_EmployeeComfirmedResultNG", length = 255, nullable = false)
	private String v_EmployeeComfirmedResultNG;

	// 追加
	@Column(name = "v_AccountingSlackLink", length = 255, nullable = false)
	private String v_AccountingSlackLink;

	@ManyToOne
	// 不安あり(外部キー？）
	@JoinColumn(name = "i_EmployeeId", nullable = false)
	private Employee employee;


	@ManyToOne
	@JoinColumn(name = "i_DepartmentId", nullable = false)
	//	private Department department;
	//@Column(name = "i_DepartmentId", nullable = false)
	private Department department;

	@Column(name = "v_ProjectTitle", length = 255, nullable = false)
	private String project_title;

	@Column(name = "v_ProjectPlace", length = 255)
	private String place;
	// ??
	// @Column(name = "vendor", length = 255)
	// private String vendor;
	// 得意先会社名
	@Column(name = "v_OrderedCompanyName", length = 255, nullable = false)
	private String ordering_company;


	//外部キー
	@ManyToOne
	//営業担当呼び出し
	@JoinColumn(name = "i_UserId", nullable = false)
	//@Column(name = "i_UserId", nullable = false)
	private Employee sales_employee;
	//private Employee sales_employee;

	@Column(name = "d_IntroduceDate")
	private Date introduce_date;

	@Lob
	@Column(name = "v_ProjectOverview", nullable = false)
	private String project_overview;

	@Column(name = "i_InterviewsCountPlan")
	private Integer number_of_interviews;

	@Column(name = "i_ProjectPriorityRank")
	private Integer priority;

	//旧バージョンInt型
	//@Column(name = "v_InterviewSituation")
	 //private String;


	@Column(name = "v_InterviewSituation")
	private int interview_situation;

	//上のと同じ？
	//@Column(name = "v_InterviewSituation")
	//private String pass_fail_status;

	@Column(name = "d_FirstInterviewScheduledDate")
	private Date first_interview_scheduled_date;

	@Column(name = "d_FirstInterviewScheduledTime")
	private LocalDateTime first_interview_scheduled_time;

	@Column(name = "v_FirstInterviewFormat")
	private int first_interview_format;

	@Column(name = "v_FirstInterviewTool", length = 255)
	private String first_interview_tool;

	@Column(name = "v_FirstInterviewUrl", length = 255)
	private String first_interview_url;

	@Column(name = "v_FirstInterviewId", length = 255)
	private String first_interview_id;

	@Column(name = "v_FirstInterviewPW", length = 255)
	private String first_interview_password;

	// 対応なし
	// @Column(name = "first_interview_date")
	 //private Date first_interview_date;

	// 対応なし
	 //@Column(name = "first_interview_time")
	 //private Time first_interview_time;

	// 変更なし
	 @Column(name = "d_SecondInterviewScheduledDate")
	 private Date d_SecondInterviewScheduledDate;

	// 変更なし
	 @Column(name = "d_SecondInterviewScheduledTime")
	 private LocalDateTime d_SecondInterviewScheduledTime;
	// 変更なし
	 @Column(name = "v_SecondInterviewFormat", length = 255)
	 private int v_SecondInterviewFormat;
	// 変更なし
	 @Column(name = "v_SecondInterviewTool", length = 255)
	 private String v_SecondInterviewTool;
	// 変更なし
	 @Column(name = "v_SecondInterviewUrl", length = 255)
	 private String v_SecondInterviewUrl;
	// 変更なし
	 @Column(name = "v_SecondInterviewId", length = 255)
	 private String v_SecondInterviewId;
	// 変更なし
	 @Column(name = "v_SecondInterviewPW", length = 255)
	 private String v_SecondInterviewPW;


	// 対応なし
	// @Lob
	// @Column(name = "supplement", nullable = false)
	// private String supplement;

	// 追加
	@Column(name = "v_InterviewResultNG", length = 255)
	private String v_InterviewResultNG;

	@Column(name = "i_RegistId", nullable = false)
	private Integer i_RegistId;

	@Column(name = "d_RegistDate", nullable = false)
	private Timestamp created_at;

	@Column(name = "i_LastUpdateId", nullable = false)
	private Integer i_LastUpdateId;

	@Column(name = "d_LastUpdateDate", nullable = false)
	private Timestamp updated_at;

	@Column(name = "i_DeletedFlag", nullable = false)
	private Integer is_deleted;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

	public String getProject_title() {
		return project_title;
	}

	public void setProject_title(String project_title) {
		this.project_title = project_title;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	// public String getVendor() {
	// return vendor;
	// }

	// public void setVendor(String vendor) {
	// this.vendor = vendor;
	// }

	public String getOrdering_company() {
		return ordering_company;
	}

	public void setOrdering_company(String ordering_company) {
		this.ordering_company = ordering_company;
	}

	public Employee getSales_employee() {
		return sales_employee;
	}

	public void setSales_employee(Employee loginEmployee) {
		this.sales_employee = loginEmployee;
	}



	public Date getIntroduce_date() {
		return introduce_date;
	}

	public void setIntroduce_date(Date introduce_date) {
		this.introduce_date = introduce_date;
	}

	public String getProject_overview() {
		return project_overview;
	}

	public void setProject_overview(String project_overview) {
		this.project_overview = project_overview;
	}

	public Integer getNumber_of_interviews() {
		return number_of_interviews;
	}

	public void setNumber_of_interviews(Integer number_of_interviews) {
		this.number_of_interviews = number_of_interviews;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	 public int getAspiration_situation() {
	 return aspiration_situation;
	 }

	 public void setAspiration_situation(int aspiration_situation) {
	 this.aspiration_situation = aspiration_situation;
	 }

	 public int getInterview_situation() {
	 return interview_situation;
	 }

	 public void setInterview_situation(int interview_situation) {
	 this.interview_situation = interview_situation;
	 }


	//無用の長物
	//public Integer getPass_fail_status() {
		//return pass_fail_status;
	//}

//	public void setPass_fail_status(Integer pass_fail_status) {
	//	this.pass_fail_status = pass_fail_status;
	//}

	public Date getFirst_interview_scheduled_date() {
		return first_interview_scheduled_date;
	}

	public void setFirst_interview_scheduled_date(Date first_interview_scheduled_date) {
		this.first_interview_scheduled_date = first_interview_scheduled_date;
	}

	public LocalDateTime getFirst_interview_scheduled_time() {
		return first_interview_scheduled_time;
	}

	public void setFirst_interview_scheduled_time(LocalDateTime first_interview_scheduled_time) {
		this.first_interview_scheduled_time = first_interview_scheduled_time;
	}

	public int getFirst_interview_format() {
		return first_interview_format;
	}

	public void setFirst_interview_format(int first_interview_format) {
		this.first_interview_format = first_interview_format;
	}

	public String getFirst_interview_tool() {
		return first_interview_tool;
	}

	public void setFirst_interview_tool(String first_interview_tool) {
		this.first_interview_tool = first_interview_tool;
	}

	public String getFirst_interview_url() {
		return first_interview_url;
	}

	public void setFirst_interview_url(String first_interview_url) {
		this.first_interview_url = first_interview_url;
	}

	public String getFirst_interview_id() {
		return first_interview_id;
	}

	public void setFirst_interview_id(String first_interview_id) {
		this.first_interview_id = first_interview_id;
	}

	public String getFirst_interview_password() {
		return first_interview_password;
	}

	public void setFirst_interview_password(String first_interview_password) {
		this.first_interview_password = first_interview_password;
	}



	 public Date getD_SecondInterviewScheduledDate() {
	 return d_SecondInterviewScheduledDate;
	 }

	 public void setD_SecondInterviewScheduledDate(Date
	 d_SecondInterviewScheduledDate) {
	 this.d_SecondInterviewScheduledDate = d_SecondInterviewScheduledDate;
	 }

	 public LocalDateTime getD_SecondInterviewScheduledTime() {
	 return d_SecondInterviewScheduledTime;
	 }

	 public void setD_SecondInterviewScheduledTime(LocalDateTime
	 second_interview_scheduled_time) {
	 this.d_SecondInterviewScheduledTime = second_interview_scheduled_time;
	 }

	 public int getV_SecondInterviewFormat() {
	 return v_SecondInterviewFormat;
	 }

	 public void setV_SecondInterviewFormat(int v_SecondInterviewFormat) {
	 this.v_SecondInterviewFormat = v_SecondInterviewFormat;
	 }

	 public String getV_SecondInterviewTool() {
	 return v_SecondInterviewTool;
	 }

	 public void setV_SecondInterviewTool(String v_SecondInterviewTool) {
	 this.v_SecondInterviewTool = v_SecondInterviewTool;
	 }

	 public String getV_SecondInterviewUrl() {
	 return v_SecondInterviewUrl;
	 }

	 public void setV_SecondInterviewUrl(String v_SecondInterviewUrl) {
	 this.v_SecondInterviewUrl = v_SecondInterviewUrl;
	 }

	public String getV_SecondInterviewId() {
	return v_SecondInterviewId;
	 }

	 public void setV_SecondInterviewId(String v_SecondInterviewId) {
	 this.v_SecondInterviewId = v_SecondInterviewId;
	 }

	 public String getV_SecondInterviewPW() {
	 return v_SecondInterviewPW;
	 }

	 public void setV_SecondInterviewPW(String
	v_SecondInterviewPW) {
	 this.v_SecondInterviewPW = v_SecondInterviewPW;
	 }

	// public Date getSecond_interview_date() {
	// return second_interview_date;
	// }

	// public void setSecond_interview_date(Date second_interview_date) {
	// this.second_interview_date = second_interview_date;
	// }

	// public Time getSecond_interview_time() {
	// return second_interview_time;
	// }

	// public void setSecond_interview_time(Time second_interview_time) {
	// this.second_interview_time = second_interview_time;
	// }

	// public String getSupplement() {
	// return supplement;
	// }

	// public void setSupplement(String supplement) {
	// this.supplement = supplement;
	// }

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public Integer getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(Integer is_deleted) {
		this.is_deleted = is_deleted;
	}

	 public String getV_AccountingSlackLink() {
	 return v_AccountingSlackLink;
	 }

	 public void setV_AccountingSlackLink(String v_AccountingSlackLink) {
	 this.v_AccountingSlackLink = v_AccountingSlackLink;
	 }

	 public String getV_EmployeeComfirmedResultNG(){
		 return v_EmployeeComfirmedResultNG;
	 }

	public void setV_EmployeeComfirmedResultNG(String v_EmployeeComfirmedResultNG) {
		this.v_EmployeeComfirmedResultNG = v_EmployeeComfirmedResultNG;

	}

	public Integer getI_RegistId() {
		return i_RegistId;
	}

	public void setI_RegistId(Integer i_RegistId) {
		this.i_RegistId = i_RegistId;
	}


	public Integer getI_LastUpdateId() {
		return i_LastUpdateId;
	}

	public void setI_LastUpdateId(Integer i_LastUpdateId) {
		this.i_LastUpdateId = i_LastUpdateId;
	}

	public String getV_OrderedCompany_SalesName() {
		return v_OrderedCompany_SalesName;
	}

	public void setV_OrderedCompany_SalesName(String v_OrderedCompany_SalesName) {
		this.v_OrderedCompany_SalesName = v_OrderedCompany_SalesName;
	}

	public Integer getI_TenantId() {
		return i_TenantId;
	}

	public void setI_TenantId(Integer i_TenantId) {
		this.i_TenantId = i_TenantId;
	}



	public String getV_InterviewResultNG(){
		 return v_InterviewResultNG;
	 }

	public void setV_InterviewResultNG(String v_InterviewResultNG) {
		this.v_InterviewResultNG = v_InterviewResultNG;

	}

// i_DepartmentId

}
