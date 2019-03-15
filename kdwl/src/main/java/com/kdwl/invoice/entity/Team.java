package com.kdwl.invoice.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.kdwl.core.include.basic.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : Team 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-14
 */
@TableName("t_team")
public class Team extends IBaseBean {

    private static final long serialVersionUID = 1L;

	private String teamtype;
	private String teamname;
	private String memo;
	private Integer flag;


	public String getTeamtype() {
		return teamtype;
	}

	public void setTeamtype(String teamtype) {
		this.teamtype = teamtype;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}


	@Override
	public String toString() {
		return "Team{" +
			", teamtype=" + teamtype +
			", teamname=" + teamname +
			", memo=" + memo +
			", flag=" + flag +
			"}";
	}
}
