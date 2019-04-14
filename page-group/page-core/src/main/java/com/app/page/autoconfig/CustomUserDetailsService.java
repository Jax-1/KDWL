package com.app.page.autoconfig;

import com.app.auth.dto.AuthUser;
import com.app.page.client.AuthFeignClient;
import com.app.page.dto.auth.AuthUserDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    AuthFeignClient authUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("用户登录："+s);
        AuthUserDTO authUserDTO=new AuthUserDTO();
        AuthUser user = authUserService.selectUserInfoByUsername(s);
        BeanUtils.copyProperties(user, authUserDTO);
        authUserDTO.setAuthRole(user.getAuthRole());
        if (authUserDTO == null||authUserDTO.getUsername()==null){
            throw new UsernameNotFoundException("用户 " + s + " 不存在！");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("user"));
        return authUserDTO;
    }
}