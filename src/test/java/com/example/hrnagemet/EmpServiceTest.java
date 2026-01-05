package com.example.hrnagemet;

import com.example.hrnagemet.entity.Employee;
import com.example.hrnagemet.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author notfl
 * @date 2026/1/5 18:15
 */
@SpringBootTest
@Transactional //测试后自动回滚
public class EmpServiceTest {
    //Service 层测试

    @Autowired
    private EmployeeService employeeService;

    // 1. 查询测试 (ID查询)
    @Test
    @DisplayName("测试按ID查询员工")
    void testGetById() {
        Employee emp = employeeService.getById(7369); // 数据库中已有的 ID
        assertNotNull(emp);
        System.out.println("查询到的员工：" + emp.getEname());
    }

    // 2. 更新测试
    @Test
    @DisplayName("测试更新员工信息")
    void testUpdate() {
        Employee emp = employeeService.getById(7369);
        emp.setJob("高级架构师");
        boolean updated = employeeService.updateById(emp);
        assertTrue(updated);
    }

    // 3. 分页测试 (验证你的 mybatis-plus-jsqlparser 依赖)
    @Test
    @DisplayName("测试分页查询员工")
    void testPage() {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<Employee> page =
                employeeService.page(new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(1, 5));

        assertNotNull(page.getRecords());
        assertTrue(page.getTotal() > 0);
    }

    // 4. 按部门查询 (如果是自定义方法)
    @Test
    @DisplayName("测试按部门查询")
    void testLambdaQueryByDept() {
        java.util.List<Employee> list = employeeService.lambdaQuery()
                .eq(Employee::getDeptno, 20)
                .list();
        assertNotNull(list);
        System.out.println("20号部门人数：" + list.size());
    }

    // 5. 软删除测试 (如果配置了 logic-delete)
    @Test
    @DisplayName("测试员工删除")
    void testRemove() {
        boolean removed = employeeService.removeById(7369);
        assertTrue(removed);
        // 如果开启了软删除，数据库里这条记录其实还在，只是 status 变了
    }
}
