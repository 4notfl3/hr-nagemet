package com.example.hrnagemet.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author notfl
 * @date 2026/1/5 15:14
 */
@Data
public class DeptStatisticsVO {
    private Integer deptno;       // 部门编号
    private String dname;          // 部门名称
    private Long totalEmp;         // 员工总数
    private BigDecimal totalSal;   // 部门总薪资
    private BigDecimal avgSal;     // 部门平均薪资
    private BigDecimal maxSal;     // 部门最高薪资
    private BigDecimal minSal;     // 部门最低薪资
    private BigDecimal totalComm;  // 部门总佣金
    private Long activeEmp;        // 在职人数
    private Long managerCount;     // 经理人数
}
