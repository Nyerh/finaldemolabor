package com.example.demo.domain.entity;


import org.springframework.stereotype.Component;

@Component
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

    public Equipment() {
    }

    public Equipment(Integer eId, String eName, String eModel, Integer eSum, Double ePrice, String eIntime, Integer eStatus, Integer lId) {
        this.eId = eId;
        this.eName = eName;
        this.eModel = eModel;
        this.eSum = eSum;
        this.ePrice = ePrice;
        this.eIntime = eIntime;
        this.eStatus = eStatus;
        this.lId = lId;
    }

    public Integer geteId() {
        return eId;
    }

    public Equipment seteId(Integer eId) {
        this.eId = eId;
        return this;
    }

    public String geteName() {
        return eName;
    }

    public Equipment seteName(String eName) {
        this.eName = eName;
        return this;
    }

    public String geteModel() {
        return eModel;
    }

    public Equipment seteModel(String eModel) {
        this.eModel = eModel;
        return this;
    }

    public Integer geteSum() {
        return eSum;
    }

    public Equipment seteSum(Integer eSum) {
        this.eSum = eSum;
        return this;
    }

    public Double getePrice() {
        return ePrice;
    }

    public Equipment setePrice(Double ePrice) {
        this.ePrice = ePrice;
        return this;
    }

    public String geteIntime() {
        return eIntime;
    }

    public Equipment seteIntime(String eIntime) {
        this.eIntime = eIntime;
        return this;
    }

    public Integer geteStatus() {
        return eStatus;
    }

    public Equipment seteStatus(Integer eStatus) {
        this.eStatus = eStatus;
        return this;
    }

    public Integer getlId() {
        return lId;
    }

    public Equipment setlId(Integer lId) {
        this.lId = lId;
        return this;
    }
}