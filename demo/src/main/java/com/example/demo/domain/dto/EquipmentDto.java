package com.example.demo.domain.dto;

import com.example.demo.domain.entity.Equipment;

import java.util.List;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/2/3 21:52
 * @Description:
 */

public class EquipmentDto {
    Integer count;
    List<Equipment> list;

    public EquipmentDto() {

    }

    public EquipmentDto(Integer count, List<Equipment> list) {
        this.count = count;
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public EquipmentDto setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Equipment> getList() {
        return list;
    }

    public EquipmentDto setList(List<Equipment> list) {
        this.list = list;
        return this;
    }
}
