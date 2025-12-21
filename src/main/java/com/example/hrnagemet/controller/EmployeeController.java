package com.example.hrnagemet.controller;

import com.example.hrnagemet.common.Result;
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
    public Result<Employee> recruit(@RequestBody Employee emp){
       Employee result = employeeService.recruit(emp);
       return Result.success(result);
   }

   //查询所有员工
    @GetMapping("/employees")
    public Result<List<Employee>> employees(){
        List<Employee> list = employeeService.getAllEmployees();
       return Result.success(list);
    }

    //id查询员工
    @GetMapping("/employees/{empno}")
    public Result<Employee> getEmployeeById(@PathVariable Integer empno){
       Employee emp = employeeService.getEmployeeById(empno);
       if(emp == null){
           return Result.error("未找到编号为 " + empno + " 的员工");
       }
       return Result.success(emp);
    }

    //修改员工部门
    @PutMapping("/employees/transfer")
    public Result<String> transfer(@RequestParam Integer empno, @RequestParam Integer deptno) {
       String msg = employeeService.transferDepartment(empno,deptno);
        if (msg.contains("转岗到")) {
            return Result.success(msg);
        }
       return Result.error(msg);
    }

    //修改员工信息
    @PutMapping("employees")
    public Result<String> updateEmployee(@RequestBody Employee emp){
       String msg = employeeService.updateEmployee(emp);
       if (msg.contains("信息已更新")){
           return Result.success(msg);
       }
       return Result.error(msg);
    }

    //删除员工
    @DeleteMapping("/employees/{empno}")
    public Result<String> deleteEmployee(@PathVariable Integer empno){
       String msg = employeeService.deleteEmployee(empno);
       if (msg.equals("员工已被删除")){
           return Result.success(msg);
       }
       return Result.error(msg);
   }



}

