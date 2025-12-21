package com.example.hrnagemet.service;

import com.example.hrnagemet.entity.Departmen;

import java.util.List;

/**
 * @author notfl
 * @date 2025/12/18 14:37
 */
public interface DepartmenService {

    //添加部门
    Departmen addDepartment(Departmen departmen);

    //查询单个部门
    Departmen getDepartmentById(Integer deptno);

    //删除功能
    String deleteDepartment(Integer deptno);

    //修改部门信息
    String updateDeptInfo(Departmen dept);;

    //查询全部部门
    List<Departmen> getAllDepartments();
}
