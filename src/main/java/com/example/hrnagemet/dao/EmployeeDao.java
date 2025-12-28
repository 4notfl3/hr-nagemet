package com.example.hrnagemet.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hrnagemet.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {


}