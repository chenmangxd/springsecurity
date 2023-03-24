package com.dm.swagger.controllers;

import com.dm.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class hellocontroller  {
    @RequestMapping("hello")
    @ResponseBody
    public String hello()
    {
        return "hello";
    }
    @PostMapping("/use")
    public User user() {
        return new User();
    }
    @ApiOperation("get测试")
    @GetMapping("/get")
    @ResponseBody
    public User hello2(@ApiParam("用户") User user) {
        int a=5/0;
        return user;
    }

    @ApiOperation("Hello控制接口")
    @GetMapping("/helloo")
    public String hello2(@ApiParam("用户名") String username) {
        return "hello" + username;
    }
}