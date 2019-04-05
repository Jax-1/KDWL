package com.auth.core.service;


import com.app.auth.dto.AuthRole;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
 *code is far away from bug with the animal protecting
 *   @description : AuthRole 服务接口
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-04
 */
@Mapper
public interface AuthRoleService extends IService<AuthRole> {
	
}
