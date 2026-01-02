package com.example.hrnagemet.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hrnagemet.common.Result;
import com.example.hrnagemet.dao.EmployeeDao;
import com.example.hrnagemet.entity.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author notfl
 * @date 2025/12/30 13:05
 */
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/employees")
public class page {

    @Autowired
    private EmployeeDao employeeDao;

    //部门id查员工
    @GetMapping("/dept/{depnot}")
    private Result<IPage<EmployeeVO>>getEmployeePage(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String ename) {

    Page<EmployeeVO> page = new Page<>(current, size);

    IPage<EmployeeVO> result = employeeDao.selectEmployeeDetailPage(page,ename);
    return Result.success(result);
    }

}
