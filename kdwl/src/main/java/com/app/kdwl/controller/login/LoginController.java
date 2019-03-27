package com.app.kdwl.controller.login;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
    @RequestMapping("login")
    public String toLoginPage(){
        return "login/login";
    }
}
