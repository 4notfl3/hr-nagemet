package com.example.hrnagemet.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.entity.vo.DeptStatisticsVO;
import com.example.hrnagemet.entity.vo.EmployeeAdminVO;
import com.example.hrnagemet.entity.vo.EmployeeDeptVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {
    //部门id查员工
    List<EmployeeDeptVO> selectEmployeeDeptList(@Param("ename") String ename, @Param("deptno") Integer deptno);

    //查询所有员工
    IPage<EmployeeAdminVO> selectAllEmployeePage(IPage<EmployeeAdminVO> page, @Param("ename") String ename);

    @Select("""
        SELECT 
            d.deptno, 
            d.dname, 
            COUNT(e.empno) AS totalEmp, 
            COALESCE(SUM(e.sal), 0) AS totalSal, 
            COALESCE(ROUND(AVG(e.sal), 2), 0) AS avgSal, 
            COALESCE(MAX(e.sal), 0) AS maxSal, 
            COALESCE(MIN(e.sal), 0) AS minSal, 
            COALESCE(SUM(e.comm), 0) AS totalComm, 
            -- 💡 核心修正：根据你的截图，判断 status 为 '在职' 的人数
            COUNT(CASE WHEN e.status = '在职' THEN 1 END) AS activeEmp, 
            COUNT(CASE WHEN e.job = 'MANAGER' THEN 1 END) AS managerCount 
        FROM dept d 
        LEFT JOIN emp e ON d.deptno = e.deptno 
        WHERE d.deleted = 0 
        GROUP BY d.deptno, d.dname
        ORDER BY d.deptno ASC
    """)
    List<DeptStatisticsVO> getDeptStatistics();

}