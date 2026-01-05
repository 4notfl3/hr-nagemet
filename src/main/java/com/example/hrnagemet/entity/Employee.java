package com.example.hrnagemet.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@TableName(value = "emp",autoResultMap = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @TableField(value = "emergency_contacts",typeHandler = JacksonTypeHandler.class)
    private Object emergencyContacts;

    private Long contact_info;
    private String email;

}
