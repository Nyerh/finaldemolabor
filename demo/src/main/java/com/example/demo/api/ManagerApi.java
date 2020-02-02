package com.example.demo.api;

import com.example.demo.constant.Msg;
import com.example.demo.constant.STATUS;
import com.example.demo.domain.dto.AddLabDto;
import com.example.demo.domain.dto.LabDto;
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
 * @Description:测试用
 */
@RestController
@RequestMapping("demoApi")
@Slf4j
public class ManagerApi {

    @Resource
    LabService labService;


    @RequestMapping("showLabs")
    @ApiOperation("展示实验室信息")
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
        return null;
    }


}
