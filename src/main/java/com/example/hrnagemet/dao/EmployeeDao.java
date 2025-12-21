package com.example.hrnagemet.dao;


import com.example.hrnagemet.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeDao {

    //添加员工
    int insertEmp(Employee emp);

    //查询所有员工
    List<Employee> selectEmp();

    //id查询员工
    Employee findById(Integer empno);

    //删除员工
    int deleteEmpById(@Param("empno")  Integer empno);

    //修改员工信息
    int updateEmp(Employee emp);

}