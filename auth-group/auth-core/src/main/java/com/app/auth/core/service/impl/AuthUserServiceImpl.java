package com.app.auth.core.service.impl;

import com.app.auth.dto.AuthUser;
import com.app.auth.core.dao.AuthUserMapper;
import com.app.auth.core.service.AuthUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *   @description : AuthUser 服务实现类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-05
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements AuthUserService {
        @Override
        public AuthUser selectUserInfo(String username){
                return this.baseMapper.selectUserInfo(username);
        }
        }