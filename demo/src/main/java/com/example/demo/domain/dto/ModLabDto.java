package com.example.demo.domain.dto;


import org.springframework.stereotype.Component;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/2/3 20:05
 * @Description:
 */
@Component
public class ModLabDto {

    Integer userId;
    Integer lId;
    String lName;
    String lDesc;


    public ModLabDto() {
    }

    public ModLabDto(Integer userId, Integer lId, String lName, String lDesc) {
        this.userId = userId;
        this.lId = lId;
        this.lName = lName;
        this.lDesc = lDesc;
    }

    public Integer getUserId() {
        return userId;
    }

    public ModLabDto setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getlId() {
        return lId;
    }

    public ModLabDto setlId(Integer lId) {
        this.lId = lId;
        return this;
    }

    public String getlName() {
        return lName;
    }

    public ModLabDto setlName(String lName) {
        this.lName = lName;
        return this;
    }

    public String getlDesc() {
        return lDesc;
    }

    public ModLabDto setlDesc(String lDesc) {
        this.lDesc = lDesc;
        return this;
    }
}
