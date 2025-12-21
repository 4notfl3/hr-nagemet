package com.example.hrnagemet.dao;

import com.example.hrnagemet.entity.Departmen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepartmenDao {

    int insertDept(Departmen dept);

    Departmen deparById(Integer deptno);

    List<Departmen> getDepartments();

    int updateEmployeeDept(@Param("empno") Integer empno, @Param("deptno") Integer deptno);

    int deleteByDeptno(@Param("deptno") Integer deptno);

    int updateDept(Departmen dept);
}
