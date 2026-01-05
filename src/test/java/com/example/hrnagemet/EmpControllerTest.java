package com.example.hrnagemet;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author notfl
 * @date 2026/1/5 18:21
 */
@SpringBootTest
@AutoConfigureMockMvc
public class EmpControllerTest {
    //Controller 层测试

    @Autowired
    private MockMvc mockMvc;

    // 1. GET 详情测试 (你已经写了)
    @Test
    @DisplayName("REST测试：根据ID查询员工")
    void testGetEmployeeApi() throws Exception {
        mockMvc.perform(get("/employees/7369"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.ename").exists());
    }

    // 2. POST 新增测试 (测试 JSON 提交)
    @Test
    @DisplayName("REST测试：添加员工")
    void testAddEmployeeApi() throws Exception {
        String json = "{\"ename\":\"新员工\",\"job\":\"测试\",\"deptno\":20}";
        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }

    // 3. PUT 更新测试 (REST 语义中的修改)
    @Test
    @DisplayName("REST测试：修改员工部门")
    void testTransferEmployeeApi() throws Exception {
        // 对应你 Controller 中的 @PutMapping("/transfer")
        String json = "{\"empno\":7369, \"deptno\":30}";
        mockMvc.perform(put("/employees/transfer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.deptno").value(30));
    }

    // 4. DELETE 删除测试 (REST 语义中的删除)
    @Test
    @DisplayName("REST测试：删除员工")
    void testDeleteEmployeeApi() throws Exception {
        mockMvc.perform(delete("/employees/7900"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value(200));
    }
}
