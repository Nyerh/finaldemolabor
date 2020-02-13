package com.example.demo.service;

import com.example.demo.domain.entity.Manager;
import com.example.demo.mapper.ManagerMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/1/31 14:53
 * @Description:
 */
@Service
public class ManagerServiece {

    @Resource
    ManagerMapper managerMapper;

    @Resource
    StudentMapper studentMapper;

    @Resource
    TeacherMapper teacherMapper;

    //管理员登录
    public Integer login(String name,String password)
    {
        Manager manager = new Manager();
        manager.setmName(name);
        manager.setmPwd(password);
        Manager login = managerMapper.selectByUsername(manager);
        if(login!=null)
        {
            return login.getmId();
        }
        return 0;
    }

    //管理员身份校验
    public Integer examine(Integer id)
    {
        Manager manager = managerMapper.selectByPrimaryKey(id);
        if(manager==null)
        {
            return 0;
        }
        return 1;
    }



}
