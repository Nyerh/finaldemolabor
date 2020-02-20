package com.example.demo.mapper;

import com.example.demo.domain.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface TeacherMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    Teacher selectByUsernamePwd(@Param("username") String username, @Param("password")String password);

    List<Teacher> selectAll(@Param("teacher") Teacher teacher,@Param("page") Integer page,@Param("pageSize")Integer pageSize);
}