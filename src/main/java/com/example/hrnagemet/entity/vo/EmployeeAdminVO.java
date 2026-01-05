package com.example.hrnagemet.entity.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author notfl
 * @date 2026/1/3 23:04
 */
@Data
@TableName(value = "emp", autoResultMap = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeAdminVO {
    private Integer empno;
    private String ename;
    private String dname;
    private Integer deptno;

    @Schema(description = "工资+奖金")
    private Double totalIncome;
    private Integer salaryGrade;
    private String contactInfo;
    private String subordinates;
}
