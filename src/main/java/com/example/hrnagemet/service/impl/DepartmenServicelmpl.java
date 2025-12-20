package com.example.hrnagemet.service.impl;

import com.example.hrnagemet.dao.DepartmenDao;
import com.example.hrnagemet.entity.Departmen;
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
    @Override
    public Departmen addDepartment(Departmen dept) {
        departmenDao.insertDept(dept);
        return dept;
    }

    //查询部门
    @Override
    public Departmen getDepartmentById(Integer deptno) {
        return departmenDao.deparById(deptno);
    }

    //删除部门
    @Override
    public String deleteDepartment(Integer deptno) {
        Departmen dept =  departmenDao.deparById(deptno);

        if (dept == null) {
            return "没有这个【"+deptno+"】部门编号";
        }
        int roew = departmenDao.deleteByDeptno(deptno);
        if (roew > 0) {
            return "部门【"+dept.getDname()+"】已被删除";
        }
        return "删除失败";
    }
    //修改部门信息
    @Override
    public String updateDeptInfo(Departmen dept){
        Departmen exist = departmenDao.deparById(dept.getDeptno());
        if (exist == null) {
            return "修改失败：部门不存在";
        }
        int rows = departmenDao.updateDept(dept);
        return  rows > 0 ? "部门信息已更新" : "修改失败";
    }


}
