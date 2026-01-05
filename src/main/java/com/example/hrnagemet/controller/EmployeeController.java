package com.example.hrnagemet.controller;

import com.example.hrnagemet.annotation.LogRecord;
import com.example.hrnagemet.common.Result;
import com.example.hrnagemet.dao.EmployeeDao;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.entity.vo.EmployeeDeptVO;
import com.example.hrnagemet.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "员工基础功能")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeDao employeeDao;

    //添加员工
    @LogRecord("添加员工")
    @Operation(summary = "添加员工档案")
    @PostMapping
    public Result<Employee> addEmployee(@RequestBody Employee emp) {
        employeeService.save(emp);
        return Result.success(emp);
    }


    //id查询员工
    @LogRecord("id查询员工")
    @Operation(summary = "id查询员工档案")
    @GetMapping("/{empno}")
    public Result<Employee> getEmployee(@PathVariable Integer empno) {
        Employee emp = employeeService.getById(empno);
        return Result.success(emp);
    }

    //部门id查员工
    @LogRecord("按部门ID查询员工详情")
    @Operation(summary = "部门id查询员工")
    @GetMapping("/dept/{depno}")
    public Result<List<EmployeeDeptVO>>selectEmployeeDeptList(
            @PathVariable("depno") Integer depno,
            @RequestParam(required = false) String ename) {

        List<EmployeeDeptVO> result = employeeDao.selectEmployeeDeptList(ename,depno);
        return Result.success(result);
    }


    //修改员工部门
    @LogRecord("修改员工部门")
    @Operation(summary = "修改员工部门")
    @PutMapping("/transfer")
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
    @LogRecord("修改员工信息")
    @Operation(summary = "修改员工信息")
    @PutMapping
    public Result<Employee> updateEmployee(@RequestBody Employee emp) {
        boolean success = employeeService.updateById(emp);
        if (success) {
            return Result.success(employeeService.getById(emp.getEmpno()));
        }
        return Result.error("修改失败，员工编号不存在");
    }

    //删除员工
    @LogRecord("删除员工")
    @Operation(summary = "删除员工档案")
    @DeleteMapping("/{empno}")
    public Result<String> deleteEmployee(@PathVariable Integer empno) {
        boolean success = employeeService.removeById(empno);
        if (success) {
            return Result.success("删除成功");
        }
        return Result.error("员工编号不存在，删除失败");
    }

}

