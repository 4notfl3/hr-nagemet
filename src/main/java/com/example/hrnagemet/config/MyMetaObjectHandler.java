package com.example.hrnagemet.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author notfl
 * @date 2025/12/22 18:29
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    //自动将实体字段：hiredate填充为当天日期
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "hiredate", LocalDate.class, LocalDate.now());
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}

