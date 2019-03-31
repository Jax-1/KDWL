package com.app.auth.controller;

import com.app.commom.result.ProcessResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("登录验证")
public class LoginController {
    @ApiOperation(value = "系统登录验证",response = ProcessResult.class)
    @RequestMapping({"login"})
    public ProcessResult login(String loginKey,String psd){
        ProcessResult res= new ProcessResult<>();
        return res;
    }
    @ApiOperation(value = "第三方登录",response = ProcessResult.class)
    @RequestMapping({"token/login"})
    public ProcessResult token(@RequestParam(value = "APPKEY") String appKey, @RequestParam(value = "APPSECRET")String appSecret){
        ProcessResult res= new ProcessResult<>();
        return res;
    }
}
