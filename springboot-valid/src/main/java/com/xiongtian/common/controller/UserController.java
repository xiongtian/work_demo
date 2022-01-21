package com.xiongtian.common.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.xiongtian.common.Result.BaseResponseDto;
import com.xiongtian.common.Result.ResponseDataBody;
import com.xiongtian.common.Result.ReturnUtils;
import com.xiongtian.common.Result.UserResponceDto;
import com.xiongtian.common.bean.dto.UserRequestDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/8 17:17
 */
@RestController
@RequestMapping(value = "/user")
@ResponseDataBody
public class UserController {


    @PostMapping("/add")
    public String add(@Validated(UserRequestDto.UserRequestDtoAddValidate.class)@RequestBody  UserRequestDto userRequestDto) {
        System.out.println(userRequestDto.toString());
        // TODO 逻辑代码
        return "add ok";
    }

    @PutMapping("/update")
    public String update(@Validated(UserRequestDto.UserRequestDtoUpdateValidate.class) @RequestBody UserRequestDto userRequestDto) {
        System.out.println(userRequestDto.toString());
        // TODO 逻辑代码
        return "update ok";
    }

    @GetMapping("/get")
    @JsonView(BaseResponseDto.ResponseBaseDtoView.class)
    public BaseResponseDto<String> get() {
        System.out.println("ok ok ");
        // TODO 逻辑代码
        return ReturnUtils.success("111");
    }

    @GetMapping("getSimple")
// 指定JsonView的简单视图
    @JsonView(UserResponceDto.UserResponceSimpleDtoView.class)
    public BaseResponseDto getSimple() {
        UserResponceDto userResponceDto = new UserResponceDto();
        userResponceDto.setUserName("张三");
        userResponceDto.setAge(10);
        userResponceDto.setEmail("zhangsan@qq.com");
        userResponceDto.setGender(0);
        userResponceDto.setPhoneNum("13888888888");
        userResponceDto.setOptUser("admin");

        return ReturnUtils.success(userResponceDto);
    }

    @GetMapping("getDetail")
// 指定详细视图
    @JsonView(UserResponceDto.UserResponceDetailDtoView.class)
    public BaseResponseDto getDetail() {
        UserResponceDto userResponceDto = new UserResponceDto();
        // 内容和上面一样

        return ReturnUtils.success(userResponceDto);
    }

    @GetMapping("getSimple1")
    @JsonView(UserResponceDto.UserResponceSimpleDtoView.class)
    public UserResponceDto getSimple1() {
        UserResponceDto userResponceDto = new UserResponceDto();
        // ....
        return userResponceDto;
    }
}
