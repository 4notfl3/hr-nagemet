package com.example.hrnagemet.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.entity.EmployeeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
    IPage<EmployeeVO> selectEmployeeDetailPage(IPage<EmployeeVO> page, @Param("ename") String ename);

}