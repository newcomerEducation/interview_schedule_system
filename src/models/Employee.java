package models;

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
@NamedQueries({
    @NamedQuery(
            name = "getAllEmployees",
            query = "SELECT e FROM Employee AS e ORDER BY e.id DESC"
            ),
    @NamedQuery(
            name = "getEmployeesCount",
            query = "SELECT COUNT(e) FROM Employee AS e"
            ),
    @NamedQuery(
            name = "checkRegisteredEmployeeCode",
            query = "SELECT COUNT(e) FROM Employee AS e WHERE e.employee_code = :employee_code"
            ),
    @NamedQuery(
            name = "checkLoginEmployeeCodeAndPassword",
            query = "SELECT e FROM Employee AS e WHERE e.is_deleted = 0 AND e.employee_code = :employee_code "
                    + "AND e.password = :pass"
            ),
    @NamedQuery(
            name = "getAllEmployeesNotDeleted",
            query = "SELECT e FROM Employee AS e WHERE e.is_deleted = 0 ORDER BY e.id DESC"
            ),
    @NamedQuery(
            name = "getAllSalesEmployeesNotDeleted",
            query = "SELECT e FROM Employee AS e WHERE e.is_deleted = 0 AND "
                    + "e.department.department_name like '営業%' ORDER BY e.id DESC"
            ),
    //後で変更 select v_PasswordSault from  c_userinfo where v_UserCode = '入力したユーザーコード';にしたい
    @NamedQuery(
            name = "getPasswordSault",
            query = "SELECT e.passwordSault FROM Employee AS e WHERE e.employee_code = :employee_code "
            ),
})
@Entity
public class Employee {
	//旧バージョンのカラム名と対応するカラムのみ変更、変数名はいじってない2022/11/14中野
    @Id
    @Column(name = "i_UserId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "v_UserCode", length = 4, nullable = false, unique = true)
    private String employee_code;

    @Column(name = "v_LastName", nullable = false)
    private String employee_name;
    //パスワードソルト
    @Column(name = "v_PasswordSault", nullable = false)
    private String  passwordSault;

    @Column(name = "v_Password", length = 64, nullable = false)
    private String password;

    @Column(name = "i_AuthId", nullable = false)
    private Integer admin_flag;

    @Column(name = "d_RegistDate", nullable = false)
    private Timestamp created_at;

    @Column(name = "d_LastUpdateDate", nullable = false)
    private Timestamp updated_at;
    //削除と有効が逆ならここの数値が逆
    @Column(name = "i_ValidFlag", nullable = false)
    private Integer is_deleted;

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

}
