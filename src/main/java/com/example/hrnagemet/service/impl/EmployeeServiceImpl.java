package com.example.hrnagemet.service.impl;

import com.example.hrnagemet.dao.DepartmenDao;
import com.example.hrnagemet.dao.EmployeeDao;
import com.example.hrnagemet.entity.Departmen;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmenDao departmenDao;


//添加员工是默认deptno为0
    @Override
    public Employee recruit(Employee emp) {
        emp.setHiredate(java.time.LocalDate.now());
        employeeDao.insertEmp(emp);
        return emp;
    }

//查询所有员工
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.selectEmp();
    }

//查询单个员工，查编号empno
    @Override
    public Employee getEmployeeById(Integer empno) {
        return employeeDao.findById(empno);
    }

//    修改员工部门
    @Override
    public String transferDepartment(Integer empno, Integer deptno){
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
            return "员工【"+emp.getEname()+"】已从【"+oldDept.getDname()+"】转岗到【"+newDept.getDname()+"】";
        }
        return "调岗失败";
    }

    //删除员工
    @Override
    public String deleteEmployee(Integer empno){
        Employee emp = employeeDao.findById(empno);
        if(emp == null){
            return "删除失败：员工编号"+empno+"不存在";
        }
        int rows = employeeDao.deleteEmpById(empno);
        if(rows > 0){
            return "员工【"+emp.getEname()+"】已被删除";
        }
        return "删除失败";
    }

}
