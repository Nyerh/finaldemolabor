package com.example.demo.mapper;

import com.example.demo.domain.entity.Equipment;

public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
}