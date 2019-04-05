package com.auth.core.service.impl;


import com.app.auth.dto.AuthUser;
import com.auth.core.dao.AuthUserMapper;
import com.auth.core.service.AuthUserService;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *   @description : AuthUser 服务实现类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-04
 */
@Service
public class AuthUserServiceImpl extends ServiceImpl<AuthUserMapper, AuthUser> implements AuthUserService {

    @Override
    public AuthUser selectUserInfo(String username){
        return baseMapper.selectUserInfo(username);
    }
	
}
