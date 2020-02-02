package com.example.demo.domain.entity;

import lombok.Data;

@Data
public class Equipment {
    private Integer eId;

    private String eName;

    /**
    * 设备型号
    */
    private String eModel;

    /**
    * 设备数量
    */
    private Integer eSum;

    /**
    * 单价
    */
    private Double ePrice;

    /**
    * 入库时间
    */
    private String eIntime;

    /**
    * 1为在库 2为在用 3为借出 4为报废
    */
    private Integer eStatus;

    /**
    * 实验室id
    */
    private Integer lId;
}