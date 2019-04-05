package com.auth.core.service.impl;


import com.app.auth.dto.AuthUserRole;
import com.auth.core.dao.AuthUserRoleMapper;
import com.auth.core.service.AuthUserRoleService;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *   @description : AuthUserRole 服务实现类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-04
 */
@Service
public class AuthUserRoleServiceImpl extends ServiceImpl<AuthUserRoleMapper, AuthUserRole> implements AuthUserRoleService {
	
}
