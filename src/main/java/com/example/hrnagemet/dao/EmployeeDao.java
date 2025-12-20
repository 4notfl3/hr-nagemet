package com.example.hrnagemet.dao;


import com.example.hrnagemet.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeDao {

    int insertEmp(Employee emp);

    List<Employee> selectEmp();

    Employee findById(Integer empno);

    int deleteEmpById(@Param("empno")  Integer empno);

}