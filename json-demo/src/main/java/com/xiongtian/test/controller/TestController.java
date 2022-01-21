package com.xiongtian.test.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.xiongtian.test.vo.Result;
import com.xiongtian.test.vo.User;
import com.xiongtian.test.vo.View;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/8 14:47
 */
@RestController
@RequestMapping("/test")
public class TestController {


    @GetMapping("/user")
    @JsonView(View.Summary.class)
    public Result<List<User>> getUsers() {
        User usre = new User(100L, "Brian", "Clozel", "brian@163.com", "beijing China", "111", "beijing", "china");
        List<User> users = new ArrayList<User>();
        users.add(usre);
        Result<List<User>> result = new Result<List<User>>("cg", users, 200);
        return result;
    }

    @GetMapping("/user-with-detail")
    @JsonView(View.SummaryWithDetail.class)
    public Result<List<User>> getUsersWithDetail() {
        User usre = new User(100L, "Brian", "Clozel", "brian@163.com", "beijing China", "111", "beijing", "china");
        List<User> users = new ArrayList<User>();
        users.add(usre);
        Result<List<User>> result = new Result<List<User>>("cg", users, 200);
        return result;
    }

    @GetMapping("/user1")

    public List<User> getUsers1() {
        User usre = new User(100L, "Brian", "Clozel", "brian@163.com", "beijing China", "111", "beijing", "china");
        List<User> users = new ArrayList<User>();
        users.add(usre);
        return users;
    }
    @GetMapping("/user2")

    public List<User> getUsers2() {
        User usre = new User(100L, "Brian", "Clozel", "brian@163.com", "beijing China", "111", "beijing", "china");
        List<User> users = new ArrayList<User>();
        users.add(usre);
        return users;
    }
}
