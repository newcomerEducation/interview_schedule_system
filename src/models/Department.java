package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "c_departments")
@NamedQueries({
    @NamedQuery(
            name = "getAllDepartments",
            query = "select d from Department as d order by d.id desc"
            ),
    @NamedQuery(
            name = "getDepartmentsCount",
            query = "select count(d) from Department as d"
            ),
    @NamedQuery(
            name = "checkRegisteredDepartmentCode",
            query = "select count(d) from Department as d where d.department_code = :department_code"
            ),
    @NamedQuery(
            name = "getAllDepartmentsNotDeleted",
            query = "select d from Department as d where d.is_deleted = 0 order by d.id desc"
            )
})
@Entity
public class Department {
	//旧バージョンのカラム名と対応するカラムのみ変更、変数名はいじってない2022/11/14中野
    @Id
    @Column(name = "i_DepartmentId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "v_DepartmentCode", length = 2, nullable = false, unique = true)
    private String department_code;

    @Column(name = "i_DepartmentName", nullable = false)
    private String department_name;

    @Column(name = "d_RegistDate", nullable = false)
    private Timestamp created_at;

    @Column(name = "d_LastUpdateDate", nullable = false)
    private Timestamp updated_at;

    @Column(name = "i_ValidFlag", nullable = false)
    private Integer is_deleted;

    @Column(name = "i_TenantId", nullable = false)
    private Integer i_TenantId;

 @Column(name = "i_RegistId", nullable = false)
     private Integer i_RegistId;

     @Column(name = "i_LastUpdateId", nullable = false)
      private Integer i_LastUpdateId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment_code() {
        return department_code;
    }

    public void setDepartment_code(String department_code) {
        this.department_code = department_code;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
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

   public Integer getI_TenantId() {
        return i_TenantId;
    }

    public void setI_TenantId(Integer i_TenantId) {
        this.i_TenantId = i_TenantId;
    }

    public Integer getI_RegistId() {
       return i_RegistId;
  }

   public void setI_RegistId(Integer i_RegistId) {
       this.i_TenantId = i_RegistId;
   }

    public Integer getI_LastUpdateId() {
      return i_LastUpdateId;
  }

   public void setI_LastUpdateId(Integer i_LastUpdateId) {
       this.i_LastUpdateId = i_LastUpdateId;
   }

}
