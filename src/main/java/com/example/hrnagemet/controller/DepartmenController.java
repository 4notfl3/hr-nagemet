package com.example.hrnagemet.controller;

import com.example.hrnagemet.common.Result;
import com.example.hrnagemet.entity.Departmen;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.service.DepartmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author notfl
 * @date 2025/12/18 19:19
 */
@RestController
public class DepartmenController {
    @Autowired
    public DepartmenService departmenService;

    //添加部门
    @PostMapping("/departments")
    public Result<Departmen> selectEmp(@RequestBody Departmen dept){
        Departmen result = departmenService.addDepartment(dept);
        return Result.success(result);
    }

    //查询单个部门
    @GetMapping("/departments/{deptno}")
    public Result<Departmen> getDepartmentById(@PathVariable Integer deptno){
        Departmen result = departmenService.getDepartmentById(deptno);
        if (result == null){
            return Result.error("为查询到编号为："+deptno+"的部门");
        }
        return Result.success(result);
    }

    //查询全部部门
    @GetMapping("/departments")
    public Result<List<Departmen>> employees(){
        List<Departmen> result = departmenService.getAllDepartments();
        return Result.success(result);
    }

    //删除功能
    @DeleteMapping("/departments/{deptno}")
    public Result<String> deleteDepartmentById(@PathVariable Integer deptno){
        String result = departmenService.deleteDepartment(deptno);
        if (result.contains("已被删除")){
            return Result.success(result);
        }
        return Result.error(result);
    }

    //修改部门信息
    @PutMapping("/departments")
    public Result<String> updateDepartment(@RequestBody Departmen dept){
        String msg = departmenService.updateDeptInfo(dept);
        if (msg.contains("已更新")){
            return Result.success(msg);
        }
        return Result.error(msg);
    }

}
