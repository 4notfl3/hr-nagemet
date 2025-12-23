package com.example.hrnagemet.controller;

import com.example.hrnagemet.common.Result;
import com.example.hrnagemet.entity.Departmen;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.service.DepartmenService;
import com.example.hrnagemet.service.EmployeeService;
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
public class DepartmenController {
    @Autowired
    private DepartmenService departmenService;

    @Autowired
    private EmployeeService employeeService;

    //添加部门
    @PostMapping
    private Result<Departmen>  saveDepartmen(@RequestBody Departmen dept){
        Departmen maxDept = departmenService.lambdaQuery()
                        .orderByDesc(Departmen::getDeptno)
                                .last("limit 1")
                                        .one();
        int netxNo = 10;
        if(maxDept != null){
            netxNo = maxDept.getDeptno()+10;
        }
        dept.setDeptno(netxNo);
        departmenService.save(dept);
        return Result.success(dept);
    }

    //id查询部门
    @GetMapping("{deptno}")
    public Result<Departmen> getDepartmen(@PathVariable Integer deptno) {
        Departmen dept = departmenService.getById(deptno);
        return Result.success(dept);
    }

    //查询全部部门
    @GetMapping
    public Result<List<Departmen>> getAllDepartmen(){
        List<Departmen> list = departmenService.list();
        return Result.success(list);
    }

    //删除部门
    @DeleteMapping("{deptno}")
    public Result<String> deleteDepartmen(@PathVariable Integer deptno) {
        long count = employeeService.lambdaQuery().eq(Employee::getDeptno, deptno).count();
        if (count > 0) {
            return Result.error("该部门下尚有员工，禁止删除！");
        }
        boolean success = departmenService.removeById(deptno);
        return success ? Result.success("删除成功") : Result.error("删除失败");
    }

    //修改部门信息
    @PutMapping
    public Result<Departmen> updateDepartmen(@RequestBody Departmen dept){
        boolean success = departmenService.updateById(dept);
        if (success) {
            return Result.success(departmenService.getById(dept.getDeptno()));
        }
        return Result.error(" 修改失败，部门编号不存在");
    }

}
