package com.xiongtian.common.Result;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/9 17:10
 * @See：错误码的接口
 */
public interface IStatusCode {
    /**
     * 获取状态码
     * @return 返回
     */
    Integer getStatus();

    /**
     * 获取状态描述
     * @return 返回描述信息
     */
    String getMsg();
}
