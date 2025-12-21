package com.example.hrnagemet.service;

import com.example.hrnagemet.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //员工入职
    Employee recruit(Employee emp);

    //查询所有员工
    List<Employee> getAllEmployees();

    //id查询员工
    Employee getEmployeeById(Integer empno);

    //修改员工部门
    String transferDepartment(Integer empno, Integer deptno);

    //删除员工
    String deleteEmployee(Integer empno);

    //修改员工信息
    String updateEmployee(Employee emp);

}
