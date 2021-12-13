package com.xiongtian.commen.bean;

import com.xiongtian.commen.Result.IStatusCode;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/9 17:49
 */
public enum  DeviceStatusCode implements IStatusCode {


    ERR_3000(3000,"设备id有误"),
    ERR_3001(3001,"设备名称格式错误"),
    ERR_3002(3002,"设备MAC地址无效")
    ;

    // 状态码
    private Integer status;

    // 状态码描述
    private String msg;

     DeviceStatusCode(Integer status, String msg) {
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
