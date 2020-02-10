package com.example.demo.mapper;

import com.example.demo.domain.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student selectByUsername(@Param("name") String name, @Param("password")String password);

    List<Student> selectAll(@Param("stu") Student student,@Param("page") Integer page,@Param("pageSize") Integer pageSize);

}