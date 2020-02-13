package com.example.demo.domain.entity;


public class Manager {
    private Integer mId;

    private String mName;

    private String mTel;

    private String mPwd;

    public Manager() {
    }

    public Manager(Integer mId, String mName, String mTel, String mPwd) {
        this.mId = mId;
        this.mName = mName;
        this.mTel = mTel;
        this.mPwd = mPwd;
    }

    public Integer getmId() {
        return mId;
    }

    public Manager setmId(Integer mId) {
        this.mId = mId;
        return this;
    }

    public String getmName() {
        return mName;
    }

    public Manager setmName(String mName) {
        this.mName = mName;
        return this;
    }

    public String getmTel() {
        return mTel;
    }

    public Manager setmTel(String mTel) {
        this.mTel = mTel;
        return this;
    }

    public String getmPwd() {
        return mPwd;
    }

    public Manager setmPwd(String mPwd) {
        this.mPwd = mPwd;
        return this;
    }
}