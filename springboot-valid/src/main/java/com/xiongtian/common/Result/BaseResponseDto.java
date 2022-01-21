package com.xiongtian.common.Result;

import com.fasterxml.jackson.annotation.JsonView;
import com.xiongtian.common.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/9 17:53
 * @See: 基础的响应对象
 */
public class BaseResponseDto<T> {

    /**
     * 响应数据最外层的视图，也是所有响应视图的父类
     */
    public interface ResponseBaseDtoView {
    }

    /**
     * 状态码
     */
    @JsonView(BaseResponseDto.ResponseBaseDtoView.class)
    private Integer status;

    /**
     * 状态描述
     */
    @JsonView(ResponseBaseDtoView.class)
    private String msg;

    /**
     * 响应数据
     */
    @JsonView(ResponseBaseDtoView.class)
    private T data;


    public BaseResponseDto() {
    }

    /**
     * 只有状态码和响应
     *
     * @param statusCode
     */
    public BaseResponseDto(IStatusCode statusCode) {
        if (null != statusCode) {
            this.status = statusCode.getStatus();
            this.msg = statusCode.getMsg();
        }
    }

    /**
     * 有状态码且有参数的响应
     *
     * @param statusCode
     * @param data
     */
    public BaseResponseDto(IStatusCode statusCode, T data) {
        if (null != statusCode) {
            this.status = statusCode.getStatus();
            this.msg = statusCode.getMsg();
        }
        if (null != data) {
            this.data = data;
        }
    }

    /**
     * 根据HttpStatus响应
     *
     * @param httpStatus http请求状态码
     */
    public BaseResponseDto(HttpStatus httpStatus) {
        if (null != httpStatus) {
            this.status = httpStatus.value();
            this.msg = httpStatus.getReasonPhrase();
        }
    }

    /**
     * 根据http状态码返回，并返回额外数据
     * @param httpStatus http状态码
     * @param data 数据
     */
    public BaseResponseDto(HttpStatus httpStatus, T data) {
        if (null != httpStatus) {
            this.status = httpStatus.value();
            this.msg = httpStatus.getReasonPhrase();
        }
        if (null != data) {
            this.data = data;
        }
    }

    /**
     * 根据异常响应错误码
     *
     * @param baseException 异常对象
     */
    public BaseResponseDto(BaseException baseException) {
        if (null != baseException) {
            this.status = baseException.getError();
            this.msg = baseException.getMsg();
            this.data = (T) baseException.getData();
        }
    }

}
