package com.example.hrnagemet.service.impl;

import com.example.hrnagemet.dao.DepartmenDao;
import com.example.hrnagemet.entity.Departmen;
import com.example.hrnagemet.service.DepartmenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author notfl
 * @date 2025/12/18 14:37
 */
@Service
public class DepartmenServicelmpl implements DepartmenService {

    private static final Logger log = LoggerFactory.getLogger(DepartmenServicelmpl.class);

    @Autowired
    private DepartmenDao departmenDao;



    //添加部门
    @Override
    public Departmen addDepartment(Departmen dept) {
        log.info("尝试创建新部门: {}", dept.getDname());
        departmenDao.insertDept(dept);
        log.info("部门创建成功，ID: {}", dept.getDeptno());
        return dept;
    }

    //查询全部部门
    @Override
    public List<Departmen> getAllDepartments() {
        log.info("获取所有部门列表");
        return departmenDao.getDepartments();
    }

    //id查部门
    @Override
    public Departmen getDepartmentById(Integer deptno) {
        log.info("正在查询编号为 {} 的部门详情", deptno);
        return departmenDao.deparById(deptno);
    }

    //删除部门
    @Override
    public String deleteDepartment(Integer deptno) {
        log.info("尝试删除部门，编号: {}", deptno);
        Departmen dept =  departmenDao.deparById(deptno);

        if (dept == null) {
            return "没有这个【"+deptno+"】部门编号";
        }
        int roew = departmenDao.deleteByDeptno(deptno);
        if (roew > 0) {
            log.warn("注意：部门【{}】已被删除", dept.getDname());
            return "部门【"+dept.getDname()+"】已被删除";
        }
        return "删除失败";
    }
    //修改部门信息
    @Override
    public String updateDeptInfo(Departmen dept){
        log.info("开始更新部门信息，编号: {}", dept.getDeptno());
        Departmen exist = departmenDao.deparById(dept.getDeptno());
        if (exist == null) {
            return "修改失败：部门不存在";
        }
        int rows = departmenDao.updateDept(dept);
        log.info("部门 {} 信息更新完成", dept.getDname());
        return  rows > 0 ? "部门信息已更新" : "修改失败";
    }


}
