package models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "c_userinfo")
@NamedQueries({ @NamedQuery(name = "getAllEmployees", query = "SELECT e FROM Employee AS e ORDER BY e.id DESC"),

	@NamedQuery(name = "getEmployeesCount", query = "SELECT COUNT(e) FROM Employee AS e"),

	@NamedQuery(name = "checkRegisteredEmployeeCode", query = "SELECT COUNT(e) FROM Employee AS e WHERE e.employee_code = :employee_code"),

	@NamedQuery(name = "checkLoginEmployeeCodeAndPassword", query = "SELECT e FROM Employee AS e WHERE e.is_deleted = 0 AND e.employee_code = :employee_code "
				+ "AND e.password = :pass"),

	@NamedQuery(name = "getAllEmployeesNotDeleted", query = "SELECT e FROM Employee AS e WHERE e.is_deleted = 0 ORDER BY e.id DESC"),

	@NamedQuery(name = "getAllSalesEmployeesNotDeleted", query = "SELECT e FROM Employee AS e WHERE e.is_deleted = 0 AND "
				+ "e.department.department_name like '営業%' ORDER BY e.id DESC"),

	@NamedQuery(name = "getAllGeneralEmployeesNotDeleted" , query = "SELECT e FROM Employee AS e WHERE e.is_deleted = 0 AND e.admin_flag = 0 ORDER BY e.id DESC"),

	//ログイン時に使用したかったクエリ
	@NamedQuery(name = "getPasswordSault", query = "SELECT e FROM Employee AS e WHERE e.is_deleted = 0 ORDER BY e.id DESC"
		// query = "SELECT e.passwordSault FROM Employee e WHERE e.employee_code
		// = :employee_code "
		), })
@Entity
public class Employee {
	// 新しいDBに併せ、カラム名の変更。変数名はそのまま2022/11/14中野
	@Id
	@Column(name = "i_UserId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "v_UserCode", length = 4, nullable = false, unique = true)
	private String employee_code;

	@Column(name = "v_LastName", nullable = false)
	private String employee_name;

	@Column(name = "v_LastNameRuby", nullable = false)
	private String v_LastNameRuby;

	@Column(name = "v_FirstName", nullable = false)
	private String v_FirstName;

	@Column(name = "v_FirstNameRuby", nullable = false)
	private String v_FirstNameRuby;

	@Column(name = "i_GenderId", nullable = false)
	private Integer i_GenderId;

	@Column(name = "i_Age", nullable = false)
	private Integer i_Age;

	@Column(name = "d_BirthDay", nullable = false)
	private Date d_BirthDay;

	@Column(name = "i_CountryId", nullable = false)
	private Integer i_CountryId;

	@Column(name = "d_HiredDate", nullable = false)
	private Date d_HiredDate;

	@Column(name = "i_Yoe", nullable = false)
	private Integer i_Yoe;

	@Column(name = "v_PostalCode", nullable = false)
	private String v_PostalCode;

	@Column(name = "v_Address1", nullable = false)
	private String v_Address1;

	@Column(name = "i_RegistId", nullable = false)
	private Integer i_RegistId;

	@Column(name = "i_LastUpdateId", nullable = false)
	private Integer i_LastUpdateId;

	// パスワードソルト
	@Column(name = "v_PasswordSault", nullable = false)
	private String passwordSault;

	@Column(name = "v_Password", length = 64, nullable = false)
	private String password;

	@Column(name = "i_AuthId", nullable = false)
	private Integer admin_flag;

	@Column(name = "d_RegistDate", nullable = false)
	private Timestamp created_at;

	@Column(name = "d_LastUpdateDate", nullable = false)
	private Timestamp updated_at;

	@Column(name = "i_ValidFlag", nullable = false)
	private Integer is_deleted;

	@Column(name = "i_TenantId", nullable = false)
	private Integer i_TenantId;

	@ManyToOne
	@JoinColumn(name = "i_DepartmentId", nullable = false)
	private Department department;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// passwordSaultのゲッター、セッター
	public String getPasswordSault() {
		return passwordSault;
	}

	public void setPasswordSault(String passwordSault) {
		this.passwordSault = passwordSault;
	}

	public Integer getAdmin_flag() {
		return admin_flag;
	}

	public void setAdmin_flag(Integer admin_flag) {
		this.admin_flag = admin_flag;
	}

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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Integer getI_TenantId() {
		return i_TenantId;
	}

	public void setI_TenantId(Integer i_TenantId) {
		this.i_TenantId = i_TenantId;
	}

	public String getV_LastNameRuby() {
		return v_LastNameRuby;
	}

	public void setV_LastNameRuby(String v_LastNameRuby) {
		this.v_LastNameRuby = v_LastNameRuby;
	}

	public String getV_FirstName() {
		return v_FirstName;
	}

	public void setV_FirstName(String v_FirstName) {
		this.v_FirstName = v_FirstName;
	}

	public String getV_FirstNameRuby() {
		return v_FirstName;
	}

	public void setV_v_FirstNameRuby(String v_FirstNameRuby) {
		this.v_FirstNameRuby = v_FirstNameRuby;
	}

	public Integer getI_GenderId() {
		return i_GenderId;
	}

	public void setI_GenderId(Integer i_GenderId) {
		this.i_GenderId = i_GenderId;
	}

	public Integer getI_Age() {
		return i_GenderId;
	}

	public void setI_Age(Integer i_Age) {
		this.i_Age = i_Age;
	}

	public Date getD_BirthDay() {
		return d_BirthDay;
	}

	public void setD_BirthDay(Date d_BirthDay) {
		this.d_BirthDay = d_BirthDay;
	}

	public Integer getI_CountryId() {
		return i_CountryId;
	}

	public void setI_CountryId(Integer i_CountryId) {
		this.i_CountryId = i_CountryId;
	}

	public Date getD_HiredDate() {
		return d_HiredDate;
	}

	public void setD_HiredDate(Date d_HiredDate) {
		this.d_HiredDate = d_HiredDate;
	}

	public Integer getI_Yoe() {
		return i_Yoe;
	}

	public void setI_Yoe(Integer i_Yoe) {
		this.i_Yoe = i_Yoe;
	}

	public String getV_PostalCode() {
		return v_FirstName;
	}

	public void setV_PostalCode(String v_PostalCode) {
		this.v_PostalCode = v_PostalCode;
	}

	public String getV_Address1() {
		return v_Address1;
	}

	public void setV_Address1(String v_Address1) {
		this.v_Address1 = v_Address1;
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

}
