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
//    @PostMapping("/transfer")
//    public String transfer(Integer emp,Integer deptno){
//       boolean success=employeeService.transferDepartment(emp,deptno);
//       if(success){
//           return "调岗成功";
//       }
//       else{
//           return "调岗失败，没有此员工或者岗位";
//       }
//    }
    // 必须明确指定为 @PutMapping，且路径要匹配
    @PutMapping("/employees/transfer")
    public String transfer(@RequestParam Integer empno, @RequestParam Integer deptno) {
        boolean success = employeeService.transferDepartment(empno, deptno);
        return success ? "调岗成功" : "调岗失败，没有此员工或者岗位";

    }


}

