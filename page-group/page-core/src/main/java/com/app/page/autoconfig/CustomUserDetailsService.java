package com.app.page.autoconfig;

import com.app.auth.dto.AuthUser;
import com.app.page.client.AuthFeignClient;
import com.app.page.dto.auth.AuthUserDTO;
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
        AuthUserDTO user = (AuthUserDTO)authUserService.selectUserInfoByUsername(s);
        if (user == null){
            throw new UsernameNotFoundException("用户 " + s + " 不存在！");
        }


        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("user"));
        return user;
    }
}