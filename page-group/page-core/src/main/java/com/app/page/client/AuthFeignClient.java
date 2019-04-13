package com.app.page.client;

import com.app.auth.dto.AuthUser;
import com.app.commom.result.ProcessResult;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("auth-service")
public interface AuthFeignClient {
    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "authUser/selectUserInfoByUsername")
    public AuthUser selectUserInfoByUsername(String username);

    /**
     * 添加用户
     * @param param
     * @return
     */
//    @PostMapping("authUser/addAuthUser")
//    public ProcessResult<AuthUser> addAuthUser(AuthUser param);

}
