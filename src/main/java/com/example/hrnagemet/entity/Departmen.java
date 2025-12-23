package com.example.hrnagemet.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("dept")
public class Departmen {
    @TableId(value = "deptno")
    private Integer deptno;
    private String dname;
    private String loc;
}
