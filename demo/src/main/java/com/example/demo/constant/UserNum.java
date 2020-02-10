package com.example.demo.constant;

public enum UserNum {
    MANAGER(001,"管理员"),
    STUDENT(010,"学生"),
    TEACHER(011,"教师");


    private Integer state;
    private String detail;

    UserNum() {
    }

    UserNum(Integer state, String detail) {
        this.state = state;
        this.detail = detail;
    }

    public Integer getState() {
        return state;
    }

    public UserNum setState(Integer state) {
        this.state = state;
        return this;
    }

    public String getDetail() {
        return detail;
    }

    public UserNum setDetail(String detail) {
        this.detail = detail;
        return this;
    }
}
