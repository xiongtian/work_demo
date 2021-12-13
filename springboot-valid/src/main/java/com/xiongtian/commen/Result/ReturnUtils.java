package com.xiongtian.commen.Result;

import com.xiongtian.commen.exception.BaseException;
import org.springframework.http.HttpStatus;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/10 10:23
 * @See: 响应帮助类
 */
public class ReturnUtils {

    /**
     * 响应成功
     *
     * @return
     */
    public static BaseResponseDto<Void> success() {
        return new BaseResponseDto<Void>(BaseStatusCode.SUCCESS);
    }

    /**
     * 根据Http状态码返回
     *
     * @return
     */
    public static BaseResponseDto<Void> successByHttpStatus() {
        return new BaseResponseDto<Void>(HttpStatus.OK);
    }

    /**
     * 根据自定义的状态码返回
     * 有响应数据的成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResponseDto success(T data) {
        return new BaseResponseDto(BaseStatusCode.SUCCESS, data);
    }

    /**
     * 根据Http状态码返回
     *
     * @param data 响应的数据
     * @param <T> 响应的数据类型
     * @return 基础的响应对象
     */
    public static <T> BaseResponseDto successByHttpStatus(T data) {
        return new BaseResponseDto(HttpStatus.OK, data);
    }

    /**
     * 没有响应数据的失败
     * @param statusCode 状态码
     * @return
     */
    public static BaseResponseDto error(BaseStatusCode statusCode) {
        return new BaseResponseDto(statusCode);
    }

    /**
     * 有响应数据的失败
     *
     * @param statusCode 状态码
     * @param data 数据
     * @param <T>
     * @return
     */
    public static <T> BaseResponseDto error(BaseStatusCode statusCode, T data) {
        return new BaseResponseDto(statusCode, data);
    }

    /**
     * 异常后的响应
     *
     * @param baseException 异常
     * @return
     */
    public static BaseResponseDto error(BaseException baseException) {
        return new BaseResponseDto(baseException);
    }
}
