package com.example.hrnagemet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.entity.vo.DeptStatisticsVO;

import java.util.List;

/**
 * @author notfl
 * @date 2025/12/22 16:59
 */

public interface EmployeeService extends IService<Employee> {

    List<DeptStatisticsVO>  getDeptStatistics();

}
