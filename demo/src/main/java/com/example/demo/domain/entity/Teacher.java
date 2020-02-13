package com.example.demo.domain.entity;


public class Teacher {
    private Integer tId;

    private String tName;

    /**
    * 教师职工号
    */
    private Integer tTno;

    /**
    * 教师所属学院
    */
    private String tCol;

    private String tTel;

    private String tPwd;

    public Teacher() {
    }

    public Teacher(Integer tId, String tName, Integer tTno, String tCol, String tTel, String tPwd) {
        this.tId = tId;
        this.tName = tName;
        this.tTno = tTno;
        this.tCol = tCol;
        this.tTel = tTel;
        this.tPwd = tPwd;
    }

    public Integer gettId() {
        return tId;
    }

    public Teacher settId(Integer tId) {
        this.tId = tId;
        return this;
    }

    public String gettName() {
        return tName;
    }

    public Teacher settName(String tName) {
        this.tName = tName;
        return this;
    }

    public Integer gettTno() {
        return tTno;
    }

    public Teacher settTno(Integer tTno) {
        this.tTno = tTno;
        return this;
    }

    public String gettCol() {
        return tCol;
    }

    public Teacher settCol(String tCol) {
        this.tCol = tCol;
        return this;
    }

    public String gettTel() {
        return tTel;
    }

    public Teacher settTel(String tTel) {
        this.tTel = tTel;
        return this;
    }

    public String gettPwd() {
        return tPwd;
    }

    public Teacher settPwd(String tPwd) {
        this.tPwd = tPwd;
        return this;
    }
}