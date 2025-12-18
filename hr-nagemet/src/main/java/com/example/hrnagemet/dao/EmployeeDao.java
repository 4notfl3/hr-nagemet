package com.example.hrnagemet.dao;


import com.example.hrnagemet.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface EmployeeDao {
    /**
     * 新增员工
     * useGeneratedKeys 会在插入成功后，将自动生成的 empno 写回给 emp 对象
     */
    @Insert("INSERT INTO emp (ename, status, job, mgr, hiredate, sal, comm, deptno) " +
            "VALUES (#{ename}, #{status}::emp_status, #{job}, #{mgr}, #{hiredate}, #{sal}, #{comm}, #{deptno})")
    @Options(useGeneratedKeys = true, keyProperty = "empno")

    int insertEmp(Employee emp);
}