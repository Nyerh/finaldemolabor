package com.example.demo.domain.dto;

import com.example.demo.domain.entity.Equipment;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/2/3 21:52
 * @Description:
 */
@Data
@Builder
public class EquipmentDto {
    Integer count;
    List<Equipment> list;

    public EquipmentDto() {
    }
}
