package com.xiongtian.common.Result;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/10 16:02
 */
public class UserResponceDto {
    // 简单视图，只返回最基数的属性
    public interface UserResponceSimpleDtoView extends BaseResponseDto.ResponseBaseDtoView {};

    // 详情视图，返回详细的属性参数
    public interface UserResponceDetailDtoView extends UserResponceSimpleDtoView {};


    /**
     * 用户名
     */
    @JsonView(UserResponceSimpleDtoView.class)
    public String userName;

    /**
     * 年龄
     */
    @JsonView(UserResponceDetailDtoView.class)
    private Integer age;

    /**
     * 性别
     */
    @JsonView(UserResponceDetailDtoView.class)
    private Integer gender;

    /**
     * 邮箱
     */
    @JsonView(UserResponceDetailDtoView.class)
    private String email;

    /**
     * 电话号码
     */
    @JsonView(UserResponceSimpleDtoView.class)
    private String phoneNum;

    /**
     * 修改人
     */
    @JsonView(UserResponceDetailDtoView.class)
    private String optUser;

    public UserResponceDto() {
    }

    public UserResponceDto(String userName, Integer age, Integer gender, String email, String phoneNum, String optUser) {
        this.userName = userName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNum = phoneNum;
        this.optUser = optUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getOptUser() {
        return optUser;
    }

    public void setOptUser(String optUser) {
        this.optUser = optUser;
    }
}
