package com.example.demo.domain.entity;



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

    public Lab() {
    }

    public Lab(Integer lId, String lName, String lDesc, Integer lStatus) {
        this.lId = lId;
        this.lName = lName;
        this.lDesc = lDesc;
        this.lStatus = lStatus;
    }

    public Integer getlId() {
        return lId;
    }

    public Lab setlId(Integer lId) {
        this.lId = lId;
        return this;
    }

    public String getlName() {
        return lName;
    }

    public Lab setlName(String lName) {
        this.lName = lName;
        return this;
    }

    public String getlDesc() {
        return lDesc;
    }

    public Lab setlDesc(String lDesc) {
        this.lDesc = lDesc;
        return this;
    }

    public Integer getlStatus() {
        return lStatus;
    }

    public Lab setlStatus(Integer lStatus) {
        this.lStatus = lStatus;
        return this;
    }
}