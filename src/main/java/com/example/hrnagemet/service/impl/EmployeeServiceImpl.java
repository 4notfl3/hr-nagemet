package com.example.hrnagemet.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hrnagemet.dao.EmployeeDao;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.entity.vo.DeptStatisticsVO;
import com.example.hrnagemet.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao,Employee> implements EmployeeService {

    @Override
    public List<DeptStatisticsVO> getDeptStatistics(){
        return baseMapper.getDeptStatistics();
    }



}
