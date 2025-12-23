package com.example.hrnagemet.controller;

import com.example.hrnagemet.common.Result;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author notfl
 * @date 2025/12/17 20:00
 */
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //添加员工
    @PostMapping
    public Result<Employee> addEmployee(@RequestBody Employee emp) {
        employeeService.save(emp);
        return Result.success(emp);
    }

    //查询所有员工
    @GetMapping
    public Result<List<Employee>> updateEmployee() {
        List<Employee> list = employeeService.list();
        return Result.success(list);
    }

    //id查询员工
    @GetMapping("{empno}")
    public Result<Employee> getEmployee(@PathVariable Integer empno) {
        Employee emp = employeeService.getById(empno);
        return Result.success(emp);
    }

    //修改员工部门
    @PutMapping("transfer")
    public Result<Employee> transferEmployee(@RequestBody Map<String,Integer> params) {
       Integer empno = params.get("empno");
       Integer deptno = params.get("deptno");

       employeeService.lambdaUpdate()
               .eq(Employee::getEmpno, empno)
               .set(Employee::getDeptno, deptno)
               .update();
       return Result.success(employeeService.getById(empno));
    }

    //修改员工信息
    @PutMapping
    public Result<Employee> updateEmployee(@RequestBody Employee emp) {
        boolean success = employeeService.updateById(emp);
        if (success) {
            return Result.success(employeeService.getById(emp.getEmpno()));
        }
        return Result.error("修改失败，员工编号不存在");

    }

    //删除员工
    @DeleteMapping("{empno}")
    public Result<Employee> deleteEmployee(@PathVariable Integer empno) {
        boolean success = employeeService.removeById(empno);
        if (success) {
            return Result.error("删除成功");
        }
        return Result.error("员工编号不存在，删除失败");
    }
}

