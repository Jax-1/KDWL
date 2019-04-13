package com.app.auth.dto;


    import com.baomidou.mybatisplus.annotations.TableField;
    import com.baomidou.mybatisplus.annotations.TableName;
    import com.app.commom.dto.IBaseBean;
    import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : AuthUser 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-05
 */
@TableName("t_auth_user")
public class AuthUser extends IBaseBean {

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
     * rand
     */
    @ApiModelProperty("password")
    private String rand;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRand() {
        return rand;
    }

    public void setRand(String rand) {
        this.rand = rand;
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

    public AuthRole getAuthRole() {
        return authRole;
    }

    public void setAuthRole(AuthRole authRole) {
        this.authRole = authRole;
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


}