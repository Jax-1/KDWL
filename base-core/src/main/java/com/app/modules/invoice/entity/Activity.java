package com.app.modules.invoice.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.app.base.basic.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : Activity 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-17
 */
@TableName("t_activity")
public class Activity extends IBaseBean {

    private static final long serialVersionUID = 1L;

	private String kdno;
	private String teamtype;
	private String teamname;
	private String teamno;
	private String activitytext;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date recordtime;
	private String location;
	private String memo;


	public String getKdno() {
		return kdno;
	}

	public void setKdno(String kdno) {
		this.kdno = kdno;
	}

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

	public String getTeamno() {
		return teamno;
	}

	public void setTeamno(String teamno) {
		this.teamno = teamno;
	}

	public String getActivitytext() {
		return activitytext;
	}

	public void setActivitytext(String activitytext) {
		this.activitytext = activitytext;
	}

	public Date getRecordtime() {
		return recordtime;
	}

	public void setRecordtime(Date recordtime) {
		this.recordtime = recordtime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}


	@Override
	public String toString() {
		return "Activity{" +
			", kdno=" + kdno +
			", teamtype=" + teamtype +
			", teamname=" + teamname +
			", teamno=" + teamno +
			", activitytext=" + activitytext +
			", recordtime=" + recordtime +
			", location=" + location +
			", memo=" + memo +
			"}";
	}
}
