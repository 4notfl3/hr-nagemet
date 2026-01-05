package com.example.hrnagemet.controller;

import com.example.hrnagemet.annotation.LogRecord;
import com.example.hrnagemet.common.Result;
import com.example.hrnagemet.entity.Departmen;
import com.example.hrnagemet.service.DepartmenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author notfl
 * @date 2025/12/18 19:19
 */
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/departments")
@Tag(name = "部门基础功能")
public class DepartmenController {
    @Autowired
    private DepartmenService departmenService;


    //添加部门
    @LogRecord("添加部门")
    @Operation(summary = "添加部门信息")
    @PostMapping
    public Result<Departmen>  saveDepartmen(@RequestBody Departmen dept){
        Integer maxNo = departmenService.findMaxNoTotal();
        int nextNo = (maxNo != null) ? maxNo+ 10 : 10;
        dept.setDeptno(nextNo);
        departmenService.save(dept);
        return Result.success(dept);
    }

    //id查询部门
    @LogRecord("id查询部门")
    @Operation(summary = "id查询部门")
    @GetMapping("{deptno}")
    public Result<Departmen> getDepartmen(@PathVariable Integer deptno) {
        Departmen dept = departmenService.getById(deptno);
        return Result.success(dept);
    }

    //查询全部部门
    @LogRecord("查询全部部门")
    @Operation(summary = "查询所有部门")
    @GetMapping
    public Result<List<Departmen>> getAllDepartmen(){
        List<Departmen> list = departmenService.list();
        return Result.success(list);
    }

    //删除部门
    @LogRecord("删除部门")
    @Operation(summary = "删除部门",description = "删除部门后，原部门下的员工将转为'待分配'状态(deptno=0)")
    @DeleteMapping("/{deptno}")
    public Result<String> deleteDepartmen(@PathVariable Integer deptno) {
        boolean success = departmenService.deleteDeptAndResetEmployees(deptno);

        return success ? Result.success("部门已删除，相关员工已转入待分配池") :
                         Result.error("删除失败，部门编号不存在");
    }

    //修改部门信息
    @LogRecord("修改部门信息")
    @Operation(summary = "修改部门信息")
    @PutMapping
    public Result<Departmen> updateDepartmen(@RequestBody Departmen dept){
        boolean success = departmenService.updateById(dept);
        if (success) {
            return Result.success(departmenService.getById(dept.getDeptno()));
        }
        return Result.error(" 修改失败，部门编号不存在");
    }

    //恢复部门
    @LogRecord("恢复部门")
    @Operation(summary = "恢复部门",description = "恢复部门所有信息，")
    @PutMapping("/restore/{deptno}")
    public Result<String> restoreDept(@PathVariable Integer deptno) {
        boolean ok = departmenService.restoreDept(deptno);
        return ok ? Result.success("部门已重启") :
                Result.error("重启失败，编号不存在");
    }

}
