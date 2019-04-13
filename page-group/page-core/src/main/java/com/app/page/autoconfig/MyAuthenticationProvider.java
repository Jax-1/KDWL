package com.app.page.autoconfig;


import com.app.auth.dto.AuthUser;
import com.app.commom.logger.LoggerFactory;
import com.app.commom.util.MD5Util;
import com.app.commom.util.Validate;
import com.app.page.dto.auth.AuthUserDTO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private CustomUserDetailsService userService;

    private final Logger logger = LoggerFactory.getLogger(MyAuthenticationProvider.class);

    /**
     * 自定义验证方式
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        AuthUserDTO user = (AuthUserDTO)userService.loadUserByUsername(username);

       //密码验证
        String prePsd=MD5Util.encoder(password,user.getRand());
        String oldPsd=user.getPassword();
        logger.info("用户："+username+"密码验证"+prePsd+"========="+oldPsd);
        if(!(Validate.notNull(prePsd)&&prePsd.equals(oldPsd))){
            logger.info("用户："+username+"密码错误！");
            throw new DisabledException("密码错误！");
        }
        logger.info("用户："+username+"登录验证成功！");
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}
