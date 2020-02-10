package com.example.demo.domain.entity;

import lombok.Data;

@Data
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

    public Student(String name, String sex, String stuClass, Integer sno, String col) {
    }
}