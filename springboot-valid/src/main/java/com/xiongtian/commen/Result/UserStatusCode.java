package com.xiongtian.commen.Result;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/9 17:48
 */
public enum  UserStatusCode implements IStatusCode {
    ERR_2000(2000,"用户信息不存在"),

    ERR_2001(2001,"用户昵称格式错误")
    ;
    // 状态码
    private Integer status;

    // 状态码描述
    private String msg;

    UserStatusCode(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @Override
    public Integer getStatus() {
        return null;
    }

    @Override
    public String getMsg() {
        return null;
    }
}
