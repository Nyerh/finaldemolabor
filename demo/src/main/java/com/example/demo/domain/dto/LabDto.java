package com.example.demo.domain.dto;

import com.example.demo.domain.entity.Lab;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/2/2 20:14
 * @Description:
 */
@Component
public class LabDto {
    Integer count;
    List<Lab> labs;

    public LabDto() {
    }

    public LabDto(Integer count, List<Lab> labs) {
        this.count = count;
        this.labs = labs;
    }

    public Integer getCount() {
        return count;
    }

    public LabDto setCount(Integer count) {
        this.count = count;
        return this;
    }

    public List<Lab> getLabs() {
        return labs;
    }

    public LabDto setLabs(List<Lab> labs) {
        this.labs = labs;
        return this;
    }
}
