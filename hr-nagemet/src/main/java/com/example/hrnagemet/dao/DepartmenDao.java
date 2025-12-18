package com.example.hrnagemet.dao;

import com.example.hrnagemet.entity.Departmen;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmenDao {

    @Select("SELECT deptno, dname, loc FROM dept")
    List<Departmen> AllDepartmen();

    @Select("SELECT deptno, dname, loc FROM dept WHERE deptno = #{deptno}")
    Departmen selectByNo(Integer deptno);
}
