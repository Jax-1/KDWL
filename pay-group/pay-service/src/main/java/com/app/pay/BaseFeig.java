package com.app.pay;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("auth-sevice")
public interface BaseFeig {
    @RequestMapping("/AuthUser/list")
    public Object getUserList();
}
