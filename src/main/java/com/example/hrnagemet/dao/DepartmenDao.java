package com.example.hrnagemet.dao;

import com.example.hrnagemet.entity.Departmen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DepartmenDao {

    int insertDept(Departmen dept);

    Departmen deparById(Integer deptno);


    int updateEmployeeDept(@Param("empno") Integer empno, @Param("deptno") Integer deptno);
}
