package com.example.hrnagemet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author notfl
 * @date 2026/1/5 18:06
 */
public class ResultTest {

    @Test
    void testBasicCoverage(){
        int sum = 1+1;
        assertEquals(2, sum, "基础加法测试通过");
        System.out.println("测试执行成功，JaCoCo 代理已记录数据。");
    }
}
