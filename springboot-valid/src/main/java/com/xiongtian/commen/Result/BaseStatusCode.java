package com.xiongtian.commen.Result;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/9 17:00
 */
public enum  BaseStatusCode implements IStatusCode {


    SUCCESS(200,"成功！"),

    ERR_1000(100,"参数错误！"),

    ERR_9999(9999,"未知参数！")
    ;

    // 状态码
    private Integer status;

    // 状态码描述
    private String msg;

    BaseStatusCode(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @Override
    public Integer getStatus() {
        return status;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
