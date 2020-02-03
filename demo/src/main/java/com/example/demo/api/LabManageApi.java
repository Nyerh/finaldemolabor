package com.example.demo.api;

import com.example.demo.constant.Msg;
import com.example.demo.constant.STATUS;
import com.example.demo.domain.dto.AddLabDto;
import com.example.demo.domain.dto.LabDto;
import com.example.demo.domain.dto.ModLabDto;
import com.example.demo.domain.entity.Lab;
import com.example.demo.service.LabService;
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
public class LabManageApi {

    @Resource
    LabService labService;


    @RequestMapping("showLabs")
    @ApiOperation("展示全部实验室信息")
    public Msg showLabs(@RequestParam(value = "page") Integer page,
                        @RequestParam(value = "pageSize") Integer pageSize)
    {
        List<Lab> labs = labService.showAllLabs(page, pageSize);
        Integer count = labService.getCount();
        LabDto labDto = new LabDto().setCount(count)
                .setLabs(labs);
        return new Msg().setItems(labDto)
                .setMsg("获取成功")
                .setState(STATUS.SUCCESS);
    }

    @RequestMapping("addLabs")
    @ApiOperation("添加实验室信息")
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
        //TODO
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


    @RequestMapping("delLab")
    @ApiOperation("删除实验室")
    public Msg delLab(@RequestParam(value = "Id") Integer id,
                      @RequestParam(value = "userId") Integer userId)
    {
        //身份校验
        //TODO
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
