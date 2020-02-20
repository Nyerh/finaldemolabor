package com.example.demo.mapper;

import com.example.demo.domain.entity.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface EquipmentMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    Equipment selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);

    List<Equipment> selectAll(@Param("page") Integer page, @Param("pageSize")Integer pageSize);

    int countAll();

    int updateStatus(@Param("order") int order,@Param("status") int status);
}