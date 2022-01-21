package com.xiongtian.test.vo;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/8 15:22
 */
public class Result<T> {

    private String msg;

    private T data;

    private int code;


    public Result(String msg, T data, int code) {
        this.msg = msg;
        this.data = data;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
