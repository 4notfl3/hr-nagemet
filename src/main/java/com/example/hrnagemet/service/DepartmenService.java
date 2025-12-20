package com.example.hrnagemet.service;

import com.example.hrnagemet.entity.Departmen;

/**
 * @author notfl
 * @date 2025/12/18 14:37
 */
public interface DepartmenService {

    Departmen addDepartment(Departmen departmen);

    Departmen getDepartmentById(Integer deptno);

    String deleteDepartment(Integer deptno);

    String updateDeptInfo(Departmen dept);;
}
