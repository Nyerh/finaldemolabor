package com.example.demo.api;

import com.example.demo.constant.Msg;
import com.example.demo.constant.STATUS;
import com.example.demo.domain.entity.Student;
import com.example.demo.domain.entity.Teacher;
import com.example.demo.service.ManagerServiece;
import com.example.demo.service.StuService;
import com.example.demo.service.TeacherService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/2/9 14:28
 * @Description:
 */
@RestController
@RequestMapping("userManagerApi")
@Slf4j
public class UserManagerApi {

    @Resource
    ManagerServiece managerServiece;
    @Resource
    TeacherService teacherService;
    @Resource
    StuService stuService;


    @RequestMapping("manaLogin")
    @ApiOperation("管理员登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", dataType = "String", value = "用户名"),
            @ApiImplicitParam(name = "password", dataType = "String", value = "密码"),
    })
    public Msg manaLogin(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password)
    {
        Integer login = managerServiece.login(username, password);
        if(login==1)
        {
            return new Msg().builder().msg("管理员登录成功")
                    .state(STATUS.SUCCESS)
                    .build();
        }
        return new Msg().builder()
                .msg("账号或密码错误")
                .state(STATUS.NUM_ERR)
                .build();
    }

    @RequestMapping("stuLogin")
    @ApiOperation("学生登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", dataType = "String", value = "用户名"),
            @ApiImplicitParam(name = "password", dataType = "String", value = "密码"),
    })
    public Msg stuLogin(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password)
    {
        Integer login = stuService.login(username, password);
        if(login==1)
        {
            return new Msg().builder()
                    .msg("登录成功")
                    .state(STATUS.SUCCESS)
                    .build();
        }
        return new Msg().builder()
                .msg("登录失败")
                .state(STATUS.NUM_ERR)
                .build();
    }


    @RequestMapping("teacherLogin")
    @ApiOperation("教师登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", dataType = "String", value = "用户名"),
            @ApiImplicitParam(name = "password", dataType = "String", value = "密码"),
    })
    public Msg teacherLogin(@RequestParam(value = "username") String username,
                        @RequestParam(value = "password") String password)
    {
        Integer login = teacherService.login(username, password);
        if(login==1)
        {
            return new Msg().builder()
                    .msg("登录成功")
                    .state(STATUS.SUCCESS)
                    .build();
        }
        return new Msg().builder()
                .msg("登录失败")
                .state(STATUS.NUM_ERR)
                .build();
    }


    @RequestMapping("stuRegister")
    @ApiOperation("学生注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", dataType = "String", value = "用户名"),
            @ApiImplicitParam(name = "password", dataType = "String", value = "密码"),
            @ApiImplicitParam(name = "sex", dataType = "String", value = "性别"),
            @ApiImplicitParam(name = "stuClass", dataType = "String", value = "班级"),
            @ApiImplicitParam(name = "col", dataType = "String", value = "学院"),
            @ApiImplicitParam(name = "cno", dataType = "Integer", value = "学号"),
    })
    public Msg stuRegister(@RequestParam(value = "name") String name,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "sex") String sex,
                           @RequestParam(value = "stuClass") String stuClass,
                           @RequestParam(value = "col") String col,
                           @RequestParam(value = "sno") Integer sno)
    {
        Student student = new Student();
        student.setSClass(stuClass);
        student.setSCol(col);
        student.setSName(name);
        student.setSPwd(password);
        student.setSSex(sex);
        student.setSSno(sno);
        Integer register = stuService.register(student);
        if(register==1)
        {
            return new Msg().builder()
                    .msg("注册成功")
                    .state(STATUS.SUCCESS)
                    .build();
        }
        return new Msg().builder()
                .msg("注册失败")
                .state(STATUS.NUM_ERR)
                .build();
    }

    @RequestMapping("teacherRegister")
    @ApiOperation("教师注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", dataType = "String", value = "用户名"),
            @ApiImplicitParam(name = "password", dataType = "String", value = "密码"),
            @ApiImplicitParam(name = "tel", dataType = "String", value = "电话号码"),
            @ApiImplicitParam(name = "col", dataType = "String", value = "学院"),
            @ApiImplicitParam(name = "tno", dataType = "Integer", value = "职工号"),
    })
    public Msg teacherRegister(@RequestParam(value = "name") String name,
                               @RequestParam(value = "tel") String tel,
                               @RequestParam(value = "col") String col,
                               @RequestParam(value = "tno") Integer tno,
                               @RequestParam(value = "password") String password)
    {
        Teacher teacher = new Teacher();
        teacher.setTCol(col);
        teacher.setTName(name);
        teacher.setTTel(tel);
        teacher.setTTno(tno);
        teacher.setTPwd(password);
        Integer register = teacherService.register(teacher);
        if(register==1)
        {
            return new Msg().builder()
                    .msg("注册成功")
                    .state(STATUS.SUCCESS)
                    .build();
        }
        return new Msg().builder()
                .msg("注册失败")
                .state(STATUS.NUM_ERR)
                .build();
    }


    @RequestMapping("showStudentList")
    @ApiOperation("学生信息展示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", dataType = "String", value = "用户名"),
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "编号"),
            @ApiImplicitParam(name = "sex", dataType = "String", value = "性别"),
            @ApiImplicitParam(name = "stuClass", dataType = "String", value = "班级"),
            @ApiImplicitParam(name = "col", dataType = "String", value = "学院"),
            @ApiImplicitParam(name = "cno", dataType = "Integer", value = "学号"),
    })
    public Msg showStudentList(@RequestParam(value = "name") String name,
                               @RequestParam(value = "id")Integer id,
                               @RequestParam(value = "sex") String sex,
                               @RequestParam(value = "stuClass") String stuClass,
                               @RequestParam(value = "col") String col,
                               @RequestParam(value = "sno") Integer sno,
                               @RequestParam(value = "page") Integer page,
                               @RequestParam(value = "pageSize")Integer pageSize)
    {

        Student student = new Student(id,name, sex, stuClass, sno, col);
        List<Student> students = stuService.showStu(student,page,pageSize);
        return new Msg().builder()
                .items(students)
                .msg("获取成功")
                .state(STATUS.SUCCESS)
                .build();
    }


    @RequestMapping("showTeacherList")
    @ApiOperation("教师信息展示")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", dataType = "String", value = "用户名"),
            @ApiImplicitParam(name = "id", dataType = "Integer", value = "编号"),
            @ApiImplicitParam(name = "tel", dataType = "String", value = "电话号码"),
            @ApiImplicitParam(name = "col", dataType = "String", value = "学院"),
            @ApiImplicitParam(name = "tno", dataType = "Integer", value = "职工号"),
    })
    public Msg showTeacherList(@RequestParam(value = "name") String name,
                               @RequestParam(value = "id")Integer id,
                               @RequestParam(value = "tel") String tel,
                               @RequestParam(value = "col") String col,
                               @RequestParam(value = "tno") Integer tno,
                               @RequestParam(value = "page") Integer page,
                               @RequestParam(value = "pageSize")Integer pageSize)
    {
        Teacher teacher = new Teacher();
        teacher.setTId(id);
        teacher.setTCol(col);
        teacher.setTName(name);
        teacher.setTTel(tel);
        teacher.setTTno(tno);
        List<Teacher> teachers = teacherService.showTeacher(teacher, page, pageSize);
        return new Msg().builder()
                .state(STATUS.SUCCESS)
                .msg("获取成功")
                .items(teachers).build();
    }


    @RequestMapping("delStudent")
    @ApiOperation("删除所选学生信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuId", dataType = "Integer", value = "学生ID"),
    })
    public Msg delStudent(@RequestParam(value = "stuId") Integer stuId)
    {
        Integer delete = stuService.delStudent(stuId);
        if(delete==1)
        {
            return new Msg().builder()
                    .state(STATUS.SUCCESS)
                    .msg("删除成功")
                    .build();
        }
        return new Msg().builder()
                .state(STATUS.NUM_ERR)
                .msg("删除失败")
                .build();
    }

    @RequestMapping("delTeacher")
    @ApiOperation("删除所选教师信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teaId", dataType = "Integer", value = "教师ID"),
    })
    public Msg delTeacher(@RequestParam(value = "teaId") Integer teaId)
    {
        Integer delete = teacherService.delTeacher(teaId);
        if(delete==1)
        {
            return new Msg().builder()
                    .state(STATUS.SUCCESS)
                    .msg("删除成功")
                    .build();
        }
        return new Msg().builder()
                .state(STATUS.NUM_ERR)
                .msg("删除失败")
                .build();
    }
}
