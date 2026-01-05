package com.example.hrnagemet.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.hrnagemet.dao.DepartmenDao;
import com.example.hrnagemet.entity.Departmen;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.service.DepartmenService;
import com.example.hrnagemet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author notfl
 * @date 2025/12/18 14:37
 */
@Service
public class DepartmenServiceImpl extends ServiceImpl<DepartmenDao, Departmen>implements DepartmenService {

    @Autowired
    private EmployeeService employeeService;

    //删除部门
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteDeptAndResetEmployees (Integer deptno) {
        employeeService.lambdaUpdate()
                .eq(Employee::getDeptno, deptno)
                .set(Employee::getDeptno, 0)
                .update();
        return this.removeById(deptno);
    }

    //恢复部门
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean restoreDept(Integer deptno) {
       int rows = baseMapper.restoreByDeptno(deptno);
       return rows > 0;
    }

    @Override
    public Integer findMaxNoTotal() {
        // 这里的 baseMapper 就是 DepartmenDao，可以直接调用自定义方法
        return baseMapper.getRealMaxDeptno();
    }

}
