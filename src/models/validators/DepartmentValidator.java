package models.validators;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import models.Department;
import utils.DBUtil;
import utils.RegexUtil;

public class DepartmentValidator {

    public static List<String> validate(Department d, Boolean departmentCodeDuplicateCheckFlag) {
        List<String> errors = new ArrayList<String>();

        String department_code_error = validateDepartmentCode(
                d.getDepartment_code(),
                departmentCodeDuplicateCheckFlag);
        if(!department_code_error.equals("")) {
            errors.add(department_code_error);
        }

        String department_name_error = validateDepartmentName(d.getDepartment_name());
        if(!department_name_error.equals("")) {
            errors.add(department_name_error);
        }

        return errors;
    }

    // 部署コード
    private static String validateDepartmentCode(
            String department_code,
            Boolean departmentCodeDuplicateCheckFlag) {
        // 必須入力チェック
        if(department_code == null || department_code.equals("")) {
            return "部署コードを入力してください";
        }

        // 型桁チェック
        if(department_code.length() != 2 || !RegexUtil.halfWidthNumberCheck(department_code)) {
            return "部署コードは半角数字2桁で入力してください";
        }

        // すでに登録されている部署コードとの重複チェック
        if(departmentCodeDuplicateCheckFlag) {
            EntityManager em = DBUtil.createEntityManager();
            long departments_count = (long)em.createNamedQuery("checkRegisteredDepartmentCode", Long.class)
                    .setParameter("department_code", department_code).getSingleResult();
            em.close();
            if(departments_count > 0) {
                return "入力された部署コードの情報はすでに存在しています";
            }
        }

        return "";
    }

    // 部署名の必須入力チェック
    private static String validateDepartmentName(String department_name) {
        if(department_name == null || department_name.equals("")) {
            return "部署名を入力してください";
        }

        return "";
    }

}
