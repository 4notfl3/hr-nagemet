package com.example.hrnagemet.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import lombok.Data;

/**
 * @author notfl
 * @date 2025/12/30 12:36
 */
@Data
@TableName(value = "emp", autoResultMap = true)
public class EmployeeVO {
    private Integer empno;
    private String ename;
    private String dname;
    private Double totalIncome;//总收入（sal+comm）
    private Integer salaryGrade;
    private String subordinates;
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Object emergencyContacts;
}
