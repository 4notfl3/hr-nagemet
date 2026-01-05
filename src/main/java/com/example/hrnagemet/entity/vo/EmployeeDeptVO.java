package com.example.hrnagemet.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author notfl
 * @date 2025/12/30 12:36
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDeptVO {
    private Integer empno;
    private String ename;
    private String job;          // 职位（需求要求）
    private String hiredate;     // 雇佣时间（需求要求）
    private String contactInfo;  // 手机号
    private String email;        // 邮箱
    private String managerName;  // 上级姓名

}
