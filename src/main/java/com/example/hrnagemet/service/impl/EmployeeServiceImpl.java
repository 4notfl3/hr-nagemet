package com.example.hrnagemet.service.impl;

import com.example.hrnagemet.dao.DepartmenDao;
import com.example.hrnagemet.dao.EmployeeDao;
import com.example.hrnagemet.entity.Departmen;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmenDao departmenDao;


//添加员工是默认deptno为0
    @Override
    public Employee recruit(Employee emp) {
        log.info("开始入职新员工：{}", emp.getEname());
        emp.setHiredate(java.time.LocalDate.now());
        employeeDao.insertEmp(emp);
        log.info("员工入职成功，生成的工号为：{}",emp.getEmpno());
        return emp;
    }

//查询所有员工
    @Override
    public List<Employee> getAllEmployees() {
        log.info("查询员工名单");
        return employeeDao.selectEmp();
    }

//查询单个员工，查编号empno
    @Override
    public Employee getEmployeeById(Integer empno) {
        log.info("正在查询工号为 {} 的员工详情", empno);
        return employeeDao.findById(empno);
    }

//    修改员工部门
    @Override
    public String transferDepartment(Integer empno, Integer deptno){
        log.info("执行转岗操作: 工号 {} -> 部门号 {}", empno, deptno);
        Employee emp = getEmployeeById(empno);
        if (emp == null)return "没有这个员工";

        Departmen oldDept = departmenDao.deparById(emp.getDeptno());
        String oldDeptName = (oldDept != null) ? oldDept.getDname() : "无部门";

        Departmen newDept = departmenDao.deparById(deptno);
        if (newDept == null)return "没有这个部门";

        if(emp.getDeptno() == deptno){
            return "员工已在【"+oldDept.getDname()+"】，无需重复转岗";
        }

        int rows = departmenDao.updateEmployeeDept(empno,deptno);

        if(rows > 0){
            log.info("转岗成功: 员工【{}】已调往【{}】", emp.getEname(), newDept.getDname());
            return "员工【"+emp.getEname()+"】已从【"+oldDept.getDname()+"】转岗到【"+newDept.getDname()+"】";
        }
        return "调岗失败";
    }

    //修改员工信息
    @Override
    public String updateEmployee(Employee emp) {
        log.info("开始修改员工信息，工号: {}", emp.getEmpno());
        Employee  oldEmp = employeeDao.findById(emp.getEmpno());
        if (oldEmp == null){
            return "没有这个员工";
        }
        int rows = employeeDao.updateEmp(emp);
        return rows > 0 ? "员工【"+oldEmp.getEname()+"】信息已更新" : "修改失败";
    }

    //删除员工
    @Override
    public String deleteEmployee(Integer empno){
        log.info("准备删除员工，工号: {}", empno);
        Employee emp = employeeDao.findById(empno);
        if(emp == null){
            return "删除失败：员工编号"+empno+"不存在";
        }
        int rows = employeeDao.deleteEmpById(empno);
        if(rows > 0){
            log.info("员工【{}】已从系统移除", emp.getEname());
            return "员工【"+emp.getEname()+"】已被删除";
        }
        return "删除失败";
    }

}
