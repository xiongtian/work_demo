package com.xiongtian.common.bean.dto;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/13 10:49
 */
public class ParamErrDto {
    private String field;
    private String defaultMessage;


    public ParamErrDto() {
    }

    public ParamErrDto(String field, String defaultMessage) {
        this.field = field;
        this.defaultMessage = defaultMessage;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public void setDefaultMessage(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }
}
