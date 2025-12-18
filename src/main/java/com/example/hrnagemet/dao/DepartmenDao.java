package com.example.hrnagemet.dao;

import com.example.hrnagemet.entity.Departmen;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmenDao {

    Integer getMaxDeptno();

    int insertDept(Departmen dept);

    Departmen deparById(Integer deptno);
}
