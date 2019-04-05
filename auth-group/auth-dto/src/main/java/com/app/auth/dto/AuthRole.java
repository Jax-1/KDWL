package com.app.auth.dto;


import com.app.commom.dto.IBaseBean;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : AuthRole 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-04
 */
@TableName("t_auth_role")
public class AuthRole extends IBaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * role_name
     */
	@ApiModelProperty("role_name")
	private String descn;
    /**
     * 是否启用 0/1 启用/禁用
     */
	@ApiModelProperty("是否启用 0/1 启用/禁用")
	private Boolean enableFlg;


	public String getDescn() {
		return descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Boolean getEnableFlg() {
		return enableFlg;
	}

	public void setEnableFlg(Boolean enableFlg) {
		this.enableFlg = enableFlg;
	}


	@Override
	public String toString() {
		return "AuthRole{" +
			", descn=" + descn +
			", enableFlg=" + enableFlg +
			"}";
	}
}
