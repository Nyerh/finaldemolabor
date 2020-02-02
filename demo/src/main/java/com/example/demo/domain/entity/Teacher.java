package com.example.demo.domain.entity;

import lombok.Data;

@Data
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
}