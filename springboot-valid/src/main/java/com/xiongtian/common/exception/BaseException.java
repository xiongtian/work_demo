package com.xiongtian.common.exception;

import com.xiongtian.common.Result.BaseStatusCode;
import com.xiongtian.common.Result.IStatusCode;
import org.springframework.http.HttpStatus;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/10 10:43
 */
public class BaseException extends RuntimeException {

    /**
     * 错误码
     */
    private Integer error;

    /**
     * 错误描述
     */
    private String msg;

    /**
     * 错误后的响应信息
     */
    private Object data;

    /**
     * 根据错误码实例化异常
     *
     * @param statusCode 自定义错误码
     */
    public BaseException(IStatusCode statusCode) {
        // 校验是否传递了异常码
        if (null == statusCode) {
            setInfo(BaseStatusCode.ERR_9999);
        } else {
            setInfo(statusCode);
        }
    }

    /**
     * 根据http状态码抛出异常
     *
     * @param httpStatus
     */
    public BaseException(HttpStatus httpStatus) {
        if (null == httpStatus) {
            // 没有传递默认使用，未知异常
            setInfo(BaseStatusCode.ERR_9999);
        } else {
            setInfo(httpStatus);
        }
    }

    /**
     * 根据错误码实例化异常，并返回数据
     *
     * @param statusCode
     * @param data
     */
    public BaseException(IStatusCode statusCode, Object data) {
        // 检验是否传递了异常码
        if (null == statusCode) {
            // 如果没有统一设置为未知参数
            setInfo(BaseStatusCode.ERR_9999);
        } else {
            setInfo(statusCode);
        }

        // 校验数据是否为null
        if (null != data) {
            this.data = data;
        }
    }

    /**
     * 设置状态码及描述信息
     * 内部使用的方法
     *
     * @param statusCode
     */
    private void setInfo(IStatusCode statusCode) {
        if (null != statusCode) {
            this.error = statusCode.getStatus();
            this.msg = statusCode.getMsg();
        }
    }

    /**
     * 根据HttpStatus设置属性
     *
     * @param httpStatus
     */
    private void setInfo(HttpStatus httpStatus) {
        if (null != httpStatus) {
            this.error = httpStatus.value();
            this.msg = httpStatus.getReasonPhrase();
        }
    }

    public BaseException() {
    }

    public BaseException(Integer error, String msg, Object data) {
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    public BaseException(String message, Integer error, String msg, Object data) {
        super(message);
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    public BaseException(String message, Throwable cause, Integer error, String msg, Object data) {
        super(message, cause);
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    public BaseException(Throwable cause, Integer error, String msg, Object data) {
        super(cause);
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer error, String msg, Object data) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
        this.msg = msg;
        this.data = data;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
