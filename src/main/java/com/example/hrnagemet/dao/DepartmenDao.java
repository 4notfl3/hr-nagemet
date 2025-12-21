package com.example.hrnagemet.dao;

import com.example.hrnagemet.entity.Departmen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DepartmenDao {

    //添加部门
    int insertDept(Departmen dept);

    //id查部门
    Departmen deparById(Integer deptno);

    //查询全部部门
    List<Departmen> getDepartments();

    //修改员工部门
    int updateEmployeeDept(@Param("empno") Integer empno, @Param("deptno") Integer deptno);

    //删除部门
    int deleteByDeptno(@Param("deptno") Integer deptno);

    //修改部门信息
    int updateDept(Departmen dept);
}
