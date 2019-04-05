package com.auth.core.service;


import com.app.auth.dto.AuthUser;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
 *code is far away from bug with the animal protecting
 *   @description : AuthUser 服务接口
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-04
 */
@Mapper
public interface AuthUserService extends IService<AuthUser> {

    public AuthUser selectUserInfo(String username);
	
}
