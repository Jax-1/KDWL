package com.app.page.client;

import com.app.auth.dto.AuthUser;
import com.app.commom.result.ProcessResult;
import com.app.commom.util.Constant;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(Constant.AUTH_SERVICE)
public interface AuthFeignClient {
    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "authUser/selectUserInfoByUsername")
    AuthUser selectUserInfoByUsername(@RequestBody String username);

    /**
     * 添加用户
     * @param param
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "authUser/addAuthUser")
    public ProcessResult<AuthUser> addAuthUser(AuthUser param);

}
