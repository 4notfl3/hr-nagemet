package com.example.hrnagemet.controller;

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
    public Departmen selectEmp(@RequestBody Departmen dept){
        return departmenService.addDepartment(dept);
    }

    //查询单个部门
    @GetMapping("/departments/{deptno}")
    public Departmen getDepartmentById(@PathVariable Integer deptno){
        return departmenService.getDepartmentById(deptno);
    }
    //查询全部部门
    @GetMapping("/departments")
    public List<Departmen> employees(){
        return departmenService.getAllDepartments();
    }
    //删除功能
    @DeleteMapping("/departments/{deptno}")
    public String deleteDepartmentById(@PathVariable Integer deptno){
        return departmenService.deleteDepartment(deptno);
    }
    //修改部门信息
    @PutMapping("/departments")
    public String updateDepartment(@RequestBody Departmen dept){
        return departmenService.updateDeptInfo(dept);
    }

}
