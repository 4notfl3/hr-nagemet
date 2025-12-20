package com.example.hrnagemet.controller;

import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author notfl
 * @date 2025/12/17 20:00
 */
@RestController
public class EmployeeController {
   @Autowired
    private EmployeeService employeeService;

    //员工入职
   @PostMapping("/recruit")
    public Employee recruit(@RequestBody Employee emp){
       return employeeService.recruit(emp);
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

    //修改员工部门
    @PutMapping("/employees/transfer")
    public String transfer(@RequestParam Integer empno, @RequestParam Integer deptno) {
       return employeeService.transferDepartment(empno,deptno);
    }
    //修改员工信息
    @PutMapping("employees")
    public String updateEmployee(@RequestBody Employee emp){
       return employeeService.updateEmployee(emp);
    }

    //删除员工
    @DeleteMapping("/employees/{empno}")
    public String deleteEmployee(@PathVariable Integer empno){return employeeService.deleteEmployee(empno);}



}

