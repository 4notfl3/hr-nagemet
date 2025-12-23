package com.example.hrnagemet.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@TableName("emp")
public class Employee {
    @TableId (value = "empno",type = IdType.AUTO)
    private Integer empno;
    private String ename;

    @TableField(value = "status", jdbcType = JdbcType.OTHER)
    private String status;
    private String job;
    private Integer mgr;

    @TableField(fill = FieldFill.INSERT)
    private LocalDate hiredate;
    private BigDecimal sal;
    private BigDecimal comm;
    private Integer deptno;

}
