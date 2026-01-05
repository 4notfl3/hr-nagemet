package com.example.hrnagemet.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author notfl
 * @date 2026/1/5 11:12
 */
@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("人事管理系统 API")
                        .description("包含员工档案、部门管理等接口文档")
                        .version("1.0"));
    }
}
