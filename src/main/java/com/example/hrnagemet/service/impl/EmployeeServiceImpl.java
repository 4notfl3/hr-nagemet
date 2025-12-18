package com.example.hrnagemet.service.impl;

import com.example.hrnagemet.dao.EmployeeDao;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


//    添加员工是默认deptno为0
    @Override
    public Employee recruit(Employee emp) {

        emp.setHiredate(java.time.LocalDate.now());
        employeeDao.insertEmp(emp);

        return emp;
    }
//查询所有员工
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.selectEmp();
    }
//查询单个员工，查编号empno
    @Override
    public Employee getEmployeeById(Integer empno) {
        return employeeDao.findById(empno);
    }
}
