package com.app.auth.dto;


import com.app.commom.dto.IBaseBean;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : AuthUserRole 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-04
 */
@TableName("t_auth_user_role")
public class AuthUserRole extends IBaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 用户表_id
     */
	@ApiModelProperty("用户表_id")
	@TableField("user_id")
	private Integer userId;
    /**
     * 角色表_id
     */
	@ApiModelProperty("角色表_id")
	@TableField("role_id")
	private Integer roleId;


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	@Override
	public String toString() {
		return "AuthUserRole{" +
			", userId=" + userId +
			", roleId=" + roleId +
			"}";
	}
}
