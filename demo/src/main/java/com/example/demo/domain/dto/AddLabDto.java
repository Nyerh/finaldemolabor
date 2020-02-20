package com.example.demo.domain.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/2/2 20:24
 * @Description:
 */
@Component
public class AddLabDto {
    Integer userId;
    String name;
    String desc;

    public AddLabDto() {
    }

    public AddLabDto(Integer userId, String name, String desc) {
        this.userId = userId;
        this.name = name;
        this.desc = desc;
    }

    public Integer getUserId() {
        return userId;
    }

    public AddLabDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public AddLabDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public AddLabDto setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
