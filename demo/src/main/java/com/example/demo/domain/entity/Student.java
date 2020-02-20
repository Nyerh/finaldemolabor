package com.example.demo.domain.entity;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private Integer sId;

    private String sName;

    private String sSex;

    private String sClass;

    /**
    * 所属学院

    */
    private String sCol;

    /**
    * 学生学号
    */
    private Integer sSno;

    private String sPwd;

    public Student() {
    }

    public Student(Integer id, String name, String sex, String stuClass, Integer sno, String col) {
    }

    public Student(String name, String sex, String stuClass, Integer sno, String col) {
    }

    public Integer getsId() {
        return sId;
    }

    public Student setsId(Integer sId) {
        this.sId = sId;
        return this;
    }

    public String getsName() {
        return sName;
    }

    public Student setsName(String sName) {
        this.sName = sName;
        return this;
    }

    public String getsSex() {
        return sSex;
    }

    public Student setsSex(String sSex) {
        this.sSex = sSex;
        return this;
    }

    public String getsClass() {
        return sClass;
    }

    public Student setsClass(String sClass) {
        this.sClass = sClass;
        return this;
    }

    public String getsCol() {
        return sCol;
    }

    public Student setsCol(String sCol) {
        this.sCol = sCol;
        return this;
    }

    public Integer getsSno() {
        return sSno;
    }

    public Student setsSno(Integer sSno) {
        this.sSno = sSno;
        return this;
    }

    public String getsPwd() {
        return sPwd;
    }

    public Student setsPwd(String sPwd) {
        this.sPwd = sPwd;
        return this;
    }
}