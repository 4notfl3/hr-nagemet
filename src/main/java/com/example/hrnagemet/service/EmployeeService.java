package com.example.hrnagemet.service;

import com.example.hrnagemet.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee recruit(Employee emp);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Integer empno);
}
