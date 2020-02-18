package com.example.demo.api;

import com.example.demo.constant.Msg;
import com.example.demo.constant.STATUS;
import com.example.demo.domain.dto.EquipmentDto;
import com.example.demo.domain.entity.Equipment;
import com.example.demo.service.EquipmentService;
import com.example.demo.service.ManagerServiece;
import com.example.demo.service.StuService;
import com.example.demo.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/2/3 20:44
 * @Description:设备管理模块
 */
@RestController
@RequestMapping("equipmentManage")
@Slf4j
@Api(description = "设备管理")
public class EquipmentManageApi {

    @Resource
    EquipmentService equipmentService;
    @Resource
    ManagerServiece managerServiece;
    @Resource
    TeacherService teacherService;
    @Resource
    StuService stuService;


    @ApiOperation("展示设备列表")
    @RequestMapping("showList")
    public Msg showEquipments(Integer page,Integer pageSize)
    {
        List<Equipment> equipment = equipmentService.showAllEquipments(page, pageSize);
        Integer count = equipmentService.getCount();
        EquipmentDto equipmentDto = new EquipmentDto();
        equipmentDto.setCount(count);
        equipmentDto.setList(equipment);
        return new Msg().builder()
                .items(equipmentDto)
                .msg("获取成功")
                .state(STATUS.SUCCESS).build();
    }

    @ApiOperation("根据ID查找设备")
    @RequestMapping("getById")
    public Msg getEquipById(Integer eId)
    {
        Equipment equipmentById = equipmentService.getEquipmentById(eId);
        return new Msg().builder()
                .state(STATUS.SUCCESS)
                .msg("查询成功")
                .items(equipmentById)
                .build();
    }

    @ApiOperation("作废设备")
    @RequestMapping("cancelEquipment")
    public Msg cancelEquip(@RequestParam(value = "eId") Integer eId,
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
        Integer i = equipmentService.modifyEquipmentStatus(eId, 4);
        if(i==0)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("作废失败")
                    .build();
        }
        return new Msg().builder()
                .state(STATUS.SUCCESS)
                .msg("已作废")
                .build();
    }

    @ApiOperation("租借设备申请")
    @RequestMapping("orderEquipment")
    public Msg orderEquip(@RequestParam(value = "eId") Integer eId,
                          @RequestParam(value = "userId") Integer userId)
    {
        //身份校验
        Integer examine = managerServiece.examine(userId);
        Integer stuExam = stuService.examine(userId);
        if(examine==0&&stuExam==0)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("权限不足")
                    .build();
        }
        Equipment equipmentById = equipmentService.getEquipmentById(eId);
        if (1!=equipmentById.geteStatus())
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("该设备不可租借")
                    .build();
        }
        Integer i = equipmentService.modifyEquipmentStatus(eId, 2);
        if(i==0)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("租借失败")
                    .build();
        }
        return new Msg().builder()
                .state(STATUS.SUCCESS)
                .msg("租借成功")
                .build();
    }

    @ApiOperation("使用设备")
    @RequestMapping("useEquipment")
    public Msg useEquip(@RequestParam(value = "eId") Integer eId,
                        @RequestParam(value = "userId") Integer userId)
    {
        Integer examine = managerServiece.examine(userId);
        Integer stuExam = stuService.examine(userId);
        if(examine==0&&stuExam==0)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("权限不足")
                    .build();
        }
        Equipment equipmentById = equipmentService.getEquipmentById(eId);
        if (equipmentById.geteStatus()!=2)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("该设备不允许使用")
                    .build();
        }
        Integer i = equipmentService.modifyEquipmentStatus(eId, 3);
        if(i==0)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("操作错误")
                    .build();
        }
        return new Msg().builder()
                .state(STATUS.SUCCESS)
                .msg("操作成功")
                .build();
    }

    @ApiOperation("归还设备")
    @RequestMapping("returnEquipment")
    public Msg returnEquip(@RequestParam(value = "eId") Integer eId,
                           @RequestParam(value = "userId") Integer userId)
    {
        Integer examine = managerServiece.examine(userId);
        Integer stuExam = stuService.examine(userId);
        if(examine==0&&stuExam==0)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("权限不足")
                    .build();
        }
        Equipment equipmentById = equipmentService.getEquipmentById(eId);
        if (equipmentById.geteStatus()!=3)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("该设备不允许归还")
                    .build();
        }
        Integer i = equipmentService.modifyEquipmentStatus(eId, 1);
        if(i==0)
        {
            return new Msg().builder()
                    .state(STATUS.NUM_ERR)
                    .msg("操作错误")
                    .build();
        }
        return new Msg().builder()
                .state(STATUS.NUM_ERR)
                .msg("归还成功")
                .build();
    }
}
