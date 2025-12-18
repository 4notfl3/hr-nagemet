package com.example.hrnagemet.controller;

import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author notfl
 * @date 2025/12/17 20:00
 */
@RestController
public class ManagementController {
   @Autowired
    private EmployeeService employeeService;

   //员工入职
   @PostMapping("/recruit")
    public Employee recruit(@RequestBody Employee emp){
       return employeeService.recruit(emp);
   }




}

