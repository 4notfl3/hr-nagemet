package com.example.hrnagemet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author notfl
 * @date 2025/12/30 16:37
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){

        // 允许所有路径的跨域请求
        registry.addMapping("/**")
                // 允许来自前端开发服务器的地址
                .allowedOriginPatterns("http://localhost:5173", "http://127.0.0.1:5173")
                // 允许的 HTTP 方法
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                // 允许携带 Cookie 等凭证
                .allowCredentials(true)
                // 预检请求（OPTIONS）的缓存时间（秒）
                .maxAge(3600);
    }
}
