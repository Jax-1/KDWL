package com.app.auth.core.service;

import com.app.auth.dto.AuthUser;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.stereotype.Service;

/**
 *code is far away from bug with the animal protecting
 *   @description : AuthUser 服务接口
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-05
 */
@Service
public interface AuthUserService extends IService<AuthUser> {
        public AuthUser selectUserInfo(String username);

        }