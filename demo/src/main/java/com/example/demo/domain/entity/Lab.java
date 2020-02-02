package com.example.demo.domain.entity;

import lombok.Data;

@Data
public class Lab {
    private Integer lId;

    private String lName;

    /**
     * 实验室描述
     */
    private String lDesc;

    /**
     * 1为未预约  2为审核中  3为已预约
     */
    private Integer lStatus;
}