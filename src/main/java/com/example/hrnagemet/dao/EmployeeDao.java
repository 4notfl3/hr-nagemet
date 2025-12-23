package com.example.hrnagemet.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hrnagemet.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {


}