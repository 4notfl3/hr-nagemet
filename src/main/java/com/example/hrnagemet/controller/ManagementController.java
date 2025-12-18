package com.example.hrnagemet.controller;

import com.example.hrnagemet.dao.DepartmenDao;
import com.example.hrnagemet.entity.Departmen;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.service.EmployeeService;
import com.example.hrnagemet.service.impl.DepartmenServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author notfl
 * @date 2025/12/17 20:00
 */
@RestController
public class ManagementController {
   @Autowired
    private EmployeeService employeeService;
   @Autowired
    private DepartmenServicelmpl departmenServicelmpl;

    //员工入职
   @PostMapping("/recruit")
    public Employee recruit(@RequestBody Employee emp){
       return employeeService.recruit(emp);
   }

   //添加部门
    @PostMapping("/departments")
    public Departmen selectEmp(@RequestBody Departmen dept){
       return departmenServicelmpl.addDepartment(dept);
    }

   //查询所有员工
    @GetMapping("/employees")
    public List<Employee> employees(){
       return employeeService.getAllEmployees();
    }

    //查询单个员工
    @GetMapping("/employees/{empno}")
    public Employee getEmployeeById(@PathVariable Integer empno){
       return employeeService.getEmployeeById(empno);
    }

    //查询部门
    @GetMapping("/departman/{deptno}")
    public Departmen getDepartmentById(@PathVariable Integer deptno){
       return departmenServicelmpl.getDepartmentById(deptno);
    }

}

