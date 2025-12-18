package com.example.hrnagemet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.hrnagemet.dao")
public class HrApp {

    public static void main(String[] args) {
        SpringApplication.run(HrApp.class, args);
    }

}
