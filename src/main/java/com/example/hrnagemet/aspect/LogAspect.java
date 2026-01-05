package com.example.hrnagemet.aspect;

import com.example.hrnagemet.annotation.LogRecord;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

/**
 * @author notfl
 * @date 2026/1/2 10:37
 */
@Aspect
@Component
@Slf4j //使用lombok记录日志
public class LogAspect {
    @Pointcut("@annotation(com.example.hrnagemet.annotation.LogRecord)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        //获取请求属性
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes != null ? attributes.getRequest() : null;

        //获取方法上的注解值
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        LogRecord annotation = signature.getMethod().getAnnotation(LogRecord.class);
        String operationName = annotation != null ? annotation.value() : "未描述操作";


        // 执行原方法
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            log.error("[{}] 执行异常: {}", operationName, e.getMessage());
            throw e;
        }

        long endTime = System.currentTimeMillis();

        // 打印优化后的结构化日志
        log.info("================  操作日志  ================");
        log.info("操作名称   : {}", operationName);
        if (request != null) {
            log.info("请求 URL   : {}", request.getRequestURL());
            log.info("HTTP 方法  : {}", request.getMethod());
        }
        log.info("执行方法   : {}.{}", signature.getDeclaringTypeName(), signature.getName());
        log.info("请求参数   : {}", Arrays.toString(joinPoint.getArgs()));
        log.info("执行耗时   : {} ms", (endTime - startTime));
        log.info("返回结果   : {}", result);
        log.info("===========================================");

        return result;

    }

}
