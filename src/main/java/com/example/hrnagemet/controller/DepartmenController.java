package com.example.hrnagemet.controller;

import com.example.hrnagemet.entity.Departmen;
import com.example.hrnagemet.service.impl.DepartmenServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author notfl
 * @date 2025/12/18 19:19
 */
@RestController
public class DepartmenController {
    @Autowired
    public DepartmenServicelmpl departmenServicelmpl;

    //添加部门
    @PostMapping("/departments")
    public Departmen selectEmp(@RequestBody Departmen dept){
        return departmenServicelmpl.addDepartment(dept);
    }

    //查询部门
    @GetMapping("/departman/{deptno}")
    public Departmen getDepartmentById(@PathVariable Integer deptno){
        return departmenServicelmpl.getDepartmentById(deptno);
    }
    //删除功能
    @DeleteMapping("/departman/{deptno}")
    public String deleteDepartmentById(@PathVariable Integer deptno){
        return departmenServicelmpl.deleteDepartment(deptno);
    }
}
