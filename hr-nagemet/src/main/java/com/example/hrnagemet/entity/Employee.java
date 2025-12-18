package com.example.hrnagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer empno;
    private String ename;
    private String status;
    private String job;
    private Integer mgr;
    private LocalDate hiredate;
    private BigDecimal sal;
    private BigDecimal comm;
    private int deptno;

}
