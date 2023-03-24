package com.du.springsecurity.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @GetMapping("indew")
    @ResponseBody
    public String index()
    {
        return "success";
    }
    @GetMapping("/hello")
    @Secured({"admins","ROLE_dmx"})
    public String hello()
    {
        return "index";
    }


}