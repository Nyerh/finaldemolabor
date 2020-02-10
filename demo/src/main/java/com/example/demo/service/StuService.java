package com.example.demo.service;

import com.example.demo.domain.entity.Student;
import com.example.demo.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/1/31 14:53
 * @Description:
 */
@Service
public class StuService {
    @Resource
    StudentMapper studentMapper;

    //学生登录
    public Integer login(String name,String password)
    {
        Student student = studentMapper.selectByUsername(name, password);
        if(null==student)
        {
            return 0;
        }
        return 1;
    }

    //注册
    public Integer register(Student student)
    {
        return studentMapper.insertSelective(student);
    }

    //身份校验
    public Integer examine(Integer id)
    {
        Student student = studentMapper.selectByPrimaryKey(id);
        if(student==null)
        {
            return 0;
        }
        return 1;
    }

    //删除学生
    public Integer delStudent(Integer id)
    {
        return studentMapper.deleteByPrimaryKey(id);
    }

    //修改学生信息
    public Integer modifyStu(Student student)
    {
        return studentMapper.updateByPrimaryKeySelective(student);
    }

    //批量查询学生信息
    public List<Student> showStu(Student stu,Integer page,Integer pageSize)
    {
        page=(page-1)*pageSize;
        return studentMapper.selectAll(stu,page,pageSize);
    }
}
