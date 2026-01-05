package com.example.hrnagemet.controller;

import com.example.hrnagemet.common.Result;
import com.example.hrnagemet.entity.vo.DeptStatisticsVO;
import com.example.hrnagemet.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author notfl
 * @date 2026/1/5 15:43
 */
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/statistics")
@Tag(name = "报表统计功能")
public class StatisticsController {

    @Autowired
    private EmployeeService employeeService;

    //按部门汇总统计
    @Operation(summary = "按部门汇总统计数据")
    @GetMapping("/dept-summary")
    public Result<List<DeptStatisticsVO>> getDeptSummary(){
        return Result.success(employeeService.getDeptStatistics());
    }
}
