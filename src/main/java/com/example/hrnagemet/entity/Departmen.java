package com.example.hrnagemet.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@TableName("dept")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Departmen {
    @TableId(value = "deptno")
    private Integer deptno;
    private String dname;
    private String loc;

    @TableLogic //逻辑删除
    @TableField(fill = FieldFill.INSERT)
    private Integer deleted = 0;
}
