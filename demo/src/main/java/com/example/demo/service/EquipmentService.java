package com.example.demo.service;

import com.example.demo.constant.Msg;
import com.example.demo.domain.entity.Equipment;
import com.example.demo.domain.entity.Lab;
import com.example.demo.mapper.EquipmentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/1/31 14:53
 * @Description:设备管理
 */
@Service
public class EquipmentService {

    @Resource
    EquipmentMapper equipmentMapper;


    //添加设备
    public Integer addEquip(Equipment equipment)
    {
        return equipmentMapper.insertSelective(equipment);
    }

    //展示所有设备状态
    public List<Equipment> showAllEquipments(Integer page, Integer pageSize)
    {
        page=(page-1)*pageSize;
        List<Equipment> equipment = equipmentMapper.selectAll(page, pageSize);
        return equipment;
    }

    //修改设备状态值
    public Integer modifyEquipmentStatus(Integer eId,Integer eStatus)
    {
        return equipmentMapper.updateStatus(eId, eStatus);
    }

    //查询
    public Equipment getEquipmentById(Integer eId)
    {
        return equipmentMapper.selectByPrimaryKey(eId);
    }

    //删除
    public Integer delEquipment(Integer eId)
    {
        return equipmentMapper.deleteByPrimaryKey(eId);
    }

    public Integer getCount()
    {
        return equipmentMapper.countAll();
    }
}
