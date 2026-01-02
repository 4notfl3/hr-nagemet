package com.example.hrnagemet.annotation;

import java.lang.annotation.*;

/**
 * @author notfl
 * @date 2026/1/2 10:39
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogRecord {
    String value() default "";
}
