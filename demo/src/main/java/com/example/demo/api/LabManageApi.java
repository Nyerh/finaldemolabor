package com.example.demo.api;

import com.example.demo.constant.Msg;
import com.example.demo.constant.STATUS;
import com.example.demo.domain.dto.AddLabDto;
import com.example.demo.domain.dto.LabDto;
import com.example.demo.domain.dto.ModLabDto;
import com.example.demo.domain.entity.Lab;
import com.example.demo.service.LabService;
import com.example.demo.service.ManagerServiece;
import com.example.demo.service.StuService;
import com.example.demo.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/1/6 17:58
 * @Description:实验室模块
 */
@RestController
@RequestMapping("labManage")
@Slf4j
@Api(description = "实验室管理")
public class LabManageApi {

    @Resource
    LabService labService;
    @Resource
    ManagerServiece managerServiece;
    @Resource
    TeacherService teacherService;
    @Resource
    StuService stuService;


    @RequestMapping("showLabs")
    @ApiOperation("展示全部实验室信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "Integer", value = "页数"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "展示数"),
            @ApiImplicitParam(name = "id", dataType = "String", value = "编号"),
            @ApiImplicitParam(name = "desc", dataType = "String", value = "详情"),
            @ApiImplicitParam(name = "name", dataType = "String", value = "名字"),
            @ApiImplicitParam(name = "status", dataType = "Integer", value = "状态"),
    })
    public Msg showLabs(@RequestParam(value = "page") Integer page,
                        @RequestParam(value = "pageSize") Integer pageSize,
                        @RequestParam(value = "id",required = false) Integer id,
                        @RequestParam(value = "desc",required = false) String desc,
                        @RequestParam(value = "name",required = false) String name,
                        @RequestParam(value = "status",required = false) Integer status)
    {
        Lab lab = new Lab();
        lab.setlName(name);
        lab.setlDesc(desc);
        lab.setlId(id);
        lab.setlStatus(status);
        List<Lab> labs = labService.showAllLabs(lab,page, pageSize);
        Integer count = labService.getCount();
        LabDto labDto = new LabDto().setCount(count)
                .setLabs(labs);
        return new Msg().setItems(labDto)
                .setMsg("获取成功")
                .setState(STATUS.SUCCESS);
    }

    @RequestMapping("addLabs")
    @ApiOperation("添加实验室信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "Integer", value = "页数"),
            @ApiImplicitParam(name = "pageSize", dataType = "Integer", value = "展示数"),
            @ApiImplicitParam(name = "id", dataType = "String", value = "编号"),
            @ApiImplicitParam(name = "desc", dataType = "String", value = "详情"),
            @ApiImplicitParam(name = "name", dataType = "String", value = "名字"),
            @ApiImplicitParam(name = "status", dataType = "Integer", value = "状态"),
    })
    public Msg addLabs(@RequestBody AddLabDto addLabDto)
    {
        if(addLabDto==null)
        {
            return new Msg().setState(STATUS.NUM_ERR).setMsg("未接收到信息");
        }
        Lab lab = new Lab();
        BeanUtils.copyProperties(addLabDto,lab);
        Integer isTill = labService.addLab(lab);
        if(isTill==0)
        {
            return new Msg().builder()
                    .msg("添加失败")
                    .state(STATUS.ERROR)
                    .build();
        }
        return new Msg().builder()
                .msg("添加成功")
                .state(STATUS.SUCCESS)
                .build();
    }

    @RequestMapping("preOrderLab")
    @ApiOperation("预定实验室")
    public Msg preOrderLab(@RequestParam(value = "Id") Integer id,
                           @RequestParam(value = "userId") Integer userId)
    {
        //校验身份
        Integer examine = managerServiece.examine(userId);
        Integer teaExam = teacherService.examine(userId);
        if(examine==0&&teaExam==0)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("权限不足")
                    .build();
        }

        Integer i = labService.preOrder(id);
        if(i==0)
        {
            return new Msg().builder().state(STATUS.NUM_ERR)
                    .msg("预定失败")
                    .build();
        }
        return new Msg().builder().msg("预订成功")
                .state(STATUS.SUCCESS)
                .build();
    }

    @RequestMapping("examOrderLab")
    @ApiOperation("审核预定")
    public Msg examOrderLab(@RequestParam(value = "Id") Integer id,
                           @RequestParam(value = "userId") Integer userId)
    {
        //身份校验
        Integer examine = managerServiece.examine(userId);
        if(examine==0)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("权限不足")
                    .build();
        }
        Integer i = labService.examOrder(id);
        if(i==0)
        {
            return new Msg().builder().state(STATUS.NUM_ERR)
                    .msg("审核失败")
                    .build();
        }
        return new Msg().builder().msg("审核成功")
                .state(STATUS.SUCCESS)
                .build();
    }

    @RequestMapping("returnOrderLab")
    @ApiOperation("解除预约")
    public Msg returnOrderLab(@RequestParam(value = "Id") Integer id,
                            @RequestParam(value = "userId") Integer userId)
    {
        //身份校验
        Integer examine = managerServiece.examine(userId);
        Integer teaExam = teacherService.examine(userId);
        if(examine==0&&teaExam==0)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("权限不足")
                    .build();
        }
        Integer i = labService.returnOrder(id);
        if(i==0)
        {
            return new Msg().builder().state(STATUS.NUM_ERR)
                    .msg("解除预约失败")
                    .build();
        }
        return new Msg().builder().msg("解除预约成功")
                .state(STATUS.SUCCESS)
                .build();
    }


    @RequestMapping("delLab")
    @ApiOperation("删除实验室")
    public Msg delLab(@RequestParam(value = "Id") Integer id,
                      @RequestParam(value = "userId") Integer userId)
    {
        //身份校验
        Integer examine = managerServiece.examine(userId);
        if(examine==0)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("权限不足")
                    .build();
        }
        Integer i = labService.delLab(id);
        if(i==0)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("删除失败")
                    .build();
        }
        return new Msg().builder()
                .state(STATUS.SUCCESS)
                .msg("删除成功")
                .build();
    }


    @RequestMapping("modifyLab")
    @ApiOperation("修改实验室信息")
    public Msg modLab(@RequestBody ModLabDto modLabDto)
    {
        Lab lab = new Lab();
        Integer userId = modLabDto.getUserId();
        //身份校验
        //TODO
        BeanUtils.copyProperties(modLabDto,lab);
        Integer i = labService.modLab(lab);
        if(i==0)
        {
            return new Msg().builder().msg("修改信息失败").state(STATUS.NUM_ERR).build();
        }
        return new Msg().builder().msg("修改信息成功").state(STATUS.SUCCESS).build();
    }

    @RequestMapping("getById")
    @ApiOperation("根据ID获取目标实验室信息")
    public Msg getLabById(@RequestParam(value = "id") Integer id)
    {
        Lab byId = labService.getById(id);
        if(byId==null)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("获取失败")
                    .build();
        }
        return new Msg().builder()
                .items(byId)
                .state(STATUS.SUCCESS)
                .msg("获取成功")
                .build();
    }


}
