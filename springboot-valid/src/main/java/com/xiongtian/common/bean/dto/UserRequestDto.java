package com.xiongtian.common.bean.dto;

import com.xiongtian.common.validator.CaseCheck;
import com.xiongtian.common.validator.CaseMode;

import javax.validation.constraints.*;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/9 14:33
 */
public class UserRequestDto {

    /**
     * 用户名
     */
    @NotBlank(message = "姓名不能为空", groups = UserRequestDtoSimpleValidate.class)
    @CaseCheck(value = CaseMode.UPPER,message = "用户名必须大写字母",groups = UserRequestDtoSimpleValidate.class)
    public String userName;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空", groups = UserRequestDtoAddValidate.class)
    public String passWord;

    /**
     * 年龄
     */
    @NotNull(message = "年龄不能为空", groups = UserRequestDtoSimpleValidate.class)
    @Min(value = 0, message = "年龄不能小于0岁", groups = UserRequestDtoSimpleValidate.class)
    @Max(value = 120, message = "年龄不能大于120岁", groups = UserRequestDtoSimpleValidate.class)
    private Integer age;

    @NotBlank(message = "手机号码不能为空", groups = UserRequestDtoAddValidate.class)
    @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$", message = "号码格式不正确!")
    private String phoneNum;

    public UserRequestDto() {
    }

    public UserRequestDto(@NotBlank(message = "姓名不能为空") String userName, @NotBlank(message = "密码不能为空") String passWord, @NotNull(message = "年龄不能为空") @Min(value = 0, message = "年龄不能小于0岁") @Max(value = 120, message = "年龄不能大于120岁") Integer age, @NotBlank(message = "手机号码不能为空") @Pattern(regexp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$", message = "号码格式不正确!") String phoneNum) {
        this.userName = userName;
        this.passWord = passWord;
        this.age = age;
        this.phoneNum = phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    // 基础的校验接口，标识着所有操作都需要校验的字段
    public interface UserRequestDtoSimpleValidate {
    }

    // 修改的校验；继承自UserRequestDtoSimpleValidate
    // 也就是说指定为这个组的时候在满足当前校验规则的同时还得校验simple接口的属性
    public interface UserRequestDtoUpdateValidate extends UserRequestDtoSimpleValidate {
    }

    // 原理同上
    public interface UserRequestDtoAddValidate extends UserRequestDtoUpdateValidate {
    }

    @Override
    public String toString() {
        return "UserRequestDto{" +
                "userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
