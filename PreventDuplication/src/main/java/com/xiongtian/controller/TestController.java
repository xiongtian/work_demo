package com.xiongtian.controller;

import com.xiongtian.annotation.PreventDuplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2022/1/10 14:40
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test1")
    @PreventDuplication
    public String test1(){
        System.out.println("点击了一次！！");
        return "aaa";
    }

    @RequestMapping("/hello2")
    public String index(){
        return "hello Spring Boot33..";
    }
}
