package com.app.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.spring.web.json.Json;

/**
 * @Class LoginRestController
 * @Author zhangjie
 * @Description //登录页面跳转
 * @Date 2019/4/1 16:00
 * @Version 1.0
 **/
@Controller
@RequestMapping("app")
public class LoginRestController {
    @RequestMapping("login")
    public String login(Model model,String error){

       return "login";
    }
    @ResponseBody
    @RequestMapping("hello")
    public Json hello(Model model){

        return new Json("aaaaaaaaa");
    }
    @ResponseBody
    @RequestMapping("h1")
    public Json h1(Model model){

        return new Json("bbbb");
    }
}
