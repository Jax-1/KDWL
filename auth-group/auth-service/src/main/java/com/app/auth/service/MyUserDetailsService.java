package com.app.auth.service;

import com.app.auth.dto.AuthUser;
import com.auth.core.service.AuthUserService;
import com.auth.core.service.impl.AuthUserServiceImpl;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {




    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AuthUserServiceImpl authUserService=new AuthUserServiceImpl();
        AuthUser authUser =new AuthUser();
        authUser.setUsername(s);
        AuthUser userModel = authUserService.selectOne(new EntityWrapper<AuthUser>(authUser));
        if (userModel == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        return new User(userModel.getUsername(), userModel.getPassword(),
                createAuthority("ADMIN,USER"));

    }
    //这里是将数据库的角色分割，构造GrantedAuthority
    private List<SimpleGrantedAuthority> createAuthority(String roles) {
        String[] roleArray = roles.split(",");
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for (String role : roleArray) {
            authorityList.add(new SimpleGrantedAuthority(role));
        }
        return authorityList;
    }
}