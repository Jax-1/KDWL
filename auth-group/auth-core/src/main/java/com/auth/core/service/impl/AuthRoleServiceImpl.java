package com.auth.core.service.impl;


import com.app.auth.dto.AuthRole;
import com.auth.core.dao.AuthRoleMapper;
import com.auth.core.service.AuthRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *   @description : AuthRole 服务实现类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-04
 */
@Service
public class AuthRoleServiceImpl extends ServiceImpl<AuthRoleMapper, AuthRole> implements AuthRoleService {
	
}
