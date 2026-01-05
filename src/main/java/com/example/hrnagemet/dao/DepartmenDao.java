package com.example.hrnagemet.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hrnagemet.entity.Departmen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DepartmenDao extends BaseMapper<Departmen> {

    @Update("UPDATE dept SET deleted = 0 WHERE deptno = #{deptno}")
    int restoreByDeptno(@Param("deptno") Integer deptno);


    @Select("SELECT MAX(deptno) FROM dept")
    Integer getRealMaxDeptno();

}
