package com.app.page.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Class AuthLoginConfig
 * @Author zhangjie
 * @Description //TODO
 * @Date 2019/4/1 16:35
 * @Version 1.0
 **/
@Component
@ConfigurationProperties(prefix = "security")
public class AuthLoginConfig {
    private String loginPage;
    //form表单请求路径
    private String formRest;

    private List<String> antMatchers;

    private List<String> resources;

    private  String failureUrl;
    private String defaultSuccessUrl;

    public String getFailureUrl() {
        return failureUrl;
    }

    public void setFailureUrl(String failureUrl) {
        this.failureUrl = failureUrl;
    }

    public String getDefaultSuccessUrl() {
        return defaultSuccessUrl;
    }

    public void setDefaultSuccessUrl(String defaultSuccessUrl) {
        this.defaultSuccessUrl = defaultSuccessUrl;
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String getFormRest() {
        return formRest;
    }

    public void setFormRest(String formRest) {
        this.formRest = formRest;
    }

    public List<String> getAntMatchers() {
        return antMatchers;
    }

    public void setAntMatchers(List<String> antMatchers) {
        this.antMatchers = antMatchers;
    }

    public List<String> getResources() {
        return resources;
    }

    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "AuthLoginConfig{" +
                "loginPage='" + loginPage + '\'' +
                ", formRest='" + formRest + '\'' +
                ", antMatchers=" + antMatchers +
                ", resources=" + resources +
                '}';
    }
}
