package com.example.hrnagemet.service.impl;

import com.example.hrnagemet.dao.DepartmenDao;
import com.example.hrnagemet.entity.Departmen;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.service.DepartmenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author notfl
 * @date 2025/12/18 14:37
 */
@Service
public class DepartmenServicelmpl implements DepartmenService {

    @Autowired
    private DepartmenDao departmenDao;

    //添加部门
    public Departmen addDepartment(Departmen dept) {
        departmenDao.insertDept(dept);
        return dept;
    }

    //查询部门
    public Departmen getDepartmentById(Integer deptno) {
        return departmenDao.deparById(deptno);
    }
}
