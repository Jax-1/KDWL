package com.kdwl.invoice.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.kdwl.core.include.basic.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : Userinfo 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-14
 */
@TableName("t_userinfo")
public class Userinfo extends IBaseBean {

    private static final long serialVersionUID = 1L;

	private String uname;
	private String unametext;
	private String upasswd;
	private Integer utype;


	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUnametext() {
		return unametext;
	}

	public void setUnametext(String unametext) {
		this.unametext = unametext;
	}

	public String getUpasswd() {
		return upasswd;
	}

	public void setUpasswd(String upasswd) {
		this.upasswd = upasswd;
	}

	public Integer getUtype() {
		return utype;
	}

	public void setUtype(Integer utype) {
		this.utype = utype;
	}


	@Override
	public String toString() {
		return "Userinfo{" +
			", uname=" + uname +
			", unametext=" + unametext +
			", upasswd=" + upasswd +
			", utype=" + utype +
			"}";
	}
}
