package com.example.demo.service;

import com.example.demo.domain.entity.Teacher;
import com.example.demo.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/1/31 14:53
 * @Description:
 */
@Service
public class TeacherService {


    @Resource
    TeacherMapper teacherMapper;

    //登录
    public Integer login(String name,String password)
    {
        Teacher teacher = teacherMapper.selectByUsernamePwd(name, password);
        if(null==teacher)
        {
            return 0;
        }
        return 1;
    }

    //注册
    public Integer register(Teacher teacher)
    {
        return teacherMapper.insertSelective(teacher);
    }

    //身份校验
    public Integer examine(Integer id)
    {
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        if(teacher==null)
        {
            return 0;
        }
        return 1;
    }

    //删除
    public Integer delTeacher(Integer id)
    {
        return teacherMapper.deleteByPrimaryKey(id);
    }

    //修改学生信息
    public Integer modifyTeacher(Teacher teacher)
    {
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    //批量查询信息
    public List<Teacher> showTeacher(Teacher teacher, Integer page, Integer pageSize)
    {
        page=(page-1)*pageSize;
        return teacherMapper.selectAll(teacher,page,pageSize);
    }
}
