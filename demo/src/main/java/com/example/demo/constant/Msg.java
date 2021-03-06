package com.example.demo.constant;

import lombok.Builder;
import lombok.Data;

/**
 * @author ：Beatrice
 * @date ：Created in 2020/1/6 18:00
 * @Description:返回类型规范
 */
@Data
@Builder
public class Msg {

    private int state;
    private String msg;
    private Object items;


    public Msg() {
    }

    public Msg(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public Msg(int state, String msg, Object items) {
        this.state = state;
        this.msg = msg;
        this.items = items;
    }

    public int getState() {
        return state;
    }

    public Msg setState(int state) {
        this.state = state;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Msg setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getItems() {
        return items;
    }

    public Msg setItems(Object items) {
        this.items = items;
        return this;
    }
}
