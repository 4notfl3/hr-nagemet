package com.example.hrnagemet.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hrnagemet.annotation.LogRecord;
import com.example.hrnagemet.common.Result;
import com.example.hrnagemet.dao.EmployeeDao;
import com.example.hrnagemet.entity.vo.EmployeeAdminVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author notfl
 * @date 2026/1/3 22:53
 */
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/employees")
@Tag(name = "员工分页查询")
public class PageController {
    @Autowired
    private EmployeeDao employeeDao;


    //查询所有员工
    @LogRecord("分页查询全员详细档案")
    @Operation(summary = "查询全员档案")
    @GetMapping
    public Result<IPage<EmployeeAdminVO>> selectAllEmployeePage(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String ename) {
        Page<EmployeeAdminVO> page = new Page<>(current, size);
        IPage<EmployeeAdminVO> result = employeeDao.selectAllEmployeePage(page,ename);
        return Result.success(result);
    }



}
