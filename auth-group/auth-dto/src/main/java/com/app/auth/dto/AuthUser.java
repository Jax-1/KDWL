package com.app.auth.dto;


    import com.baomidou.mybatisplus.annotations.TableField;
    import com.baomidou.mybatisplus.annotations.TableName;
    import com.app.commom.dto.IBaseBean;
    import io.swagger.annotations.ApiModelProperty;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;

    import java.util.ArrayList;
    import java.util.Collection;
    import java.util.List;

/**
 *   @description : AuthUser 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-05
 */
@TableName("t_auth_user")
public class AuthUser extends IBaseBean implements UserDetails, GrantedAuthority {

private static final long serialVersionUID = 1L;

    /**
     * username
     */
    @ApiModelProperty("username")
        private String username;
    /**
     * password
     */
    @ApiModelProperty("password")
        private String password;
    /**
     * 登录方式
     */
    @ApiModelProperty("登录方式")
    @TableField("sign_type")
        private String signType;
    /**
     * OPID
     */
    @ApiModelProperty("OPID")
        private String openid;
    /**
     * 头像ID
     */
    @ApiModelProperty("头像ID")
        private String headImg;
    /**
     * 是否启用 0/1
     */
    @ApiModelProperty("是否启用 0/1")
    @TableField("enable_flg")
        private Boolean enableFlg;

    private AuthRole authRole;

    public AuthRole getAuthRole() {
        return authRole;
    }

    public void setAuthRole(AuthRole authRole) {
        this.authRole = authRole;
    }

    @Override
    public String getUsername() {
            return username;
            }

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

    public void setUsername(String username) {
            this.username = username;
            }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //  需将 List<Authority> 转成 List<SimpleGrantedAuthority>，否则前端拿不到角色列表名称
        List<SimpleGrantedAuthority> simpleAuthorities = new ArrayList<>();
        if(this.authRole.getName().contains(",")){
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
    public String getPassword() {
            return password;
            }
            public void setPassword(String password) {
            this.password = password;
            }

    public String getSignType() {
            return signType;
            }

        public void setSignType(String signType) {
            this.signType = signType;
            }

    public String getOpenid() {
            return openid;
            }

        public void setOpenid(String openid) {
            this.openid = openid;
            }

    public String getHeadImg() {
            return headImg;
            }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
            }

    public Boolean getEnableFlg() {
            return enableFlg;
            }

        public void setEnableFlg(Boolean enableFlg) {
            this.enableFlg = enableFlg;
            }


@Override
public String toString() {
        return "AuthUser{" +
                ", username=" + username +
                ", password=" + password +
                ", signType=" + signType +
                ", openid=" + openid +
                ", headImg=" + headImg +
                ", enableFlg=" + enableFlg +
        "}";
        }

    @Override
    public String getAuthority() {
        return authRole.getName();
    }
}