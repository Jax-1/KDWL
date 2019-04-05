package com.auth.core.dao;


import com.app.auth.dto.AuthUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 *   @description : AuthUser Mapper 接口
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-04
 */
@Mapper
public interface AuthUserMapper extends BaseMapper<AuthUser> {

    public AuthUser selectUserInfo(String username);

}