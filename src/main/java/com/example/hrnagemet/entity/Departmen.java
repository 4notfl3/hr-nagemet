package com.example.hrnagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departmen {
    private Integer deptno;
    private String dname;
    private String loc;
}
