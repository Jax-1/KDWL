package com.app.page.dto.auth;

import com.app.auth.dto.AuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthUserDTO extends AuthUser  implements UserDetails, GrantedAuthority {

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //  需将 List<Authority> 转成 List<SimpleGrantedAuthority>，否则前端拿不到角色列表名称
        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
        if(this.getAuthRole().getName().contains(",")){
            simpleAuthorities.add(new SimpleGrantedAuthority(this.getAuthority()));
        }
        String [] roles=this.getAuthority().split(",");
        for (String role:roles
        ) {
            simpleAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return simpleAuthorities;
    }
    @Override
    public String getAuthority() {
        return this.getAuthRole().getName();
    }

}
