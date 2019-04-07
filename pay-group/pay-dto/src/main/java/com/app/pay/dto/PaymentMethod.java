package com.app.pay.dto;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.app.commom.dto.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : PaymentMethod 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-07
 */
@TableName("t_pay_payment_method")
public class PaymentMethod extends IBaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * key
     */
	@ApiModelProperty("key")
	private String key;
    /**
     * 备注
     */
	@ApiModelProperty("备注")
	private String decriptron;
    /**
     * Y/N
     */
	@ApiModelProperty("Y/N")
	private String state;
    /**
     * Y/N 默认支付方式
     */
	@ApiModelProperty("Y/N 默认支付方式")
	@TableField("default_payment")
	private String defaultPayment;
    /**
     * 图标
     */
	@ApiModelProperty("图标")
	private String ico;


	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDecriptron() {
		return decriptron;
	}

	public void setDecriptron(String decriptron) {
		this.decriptron = decriptron;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDefaultPayment() {
		return defaultPayment;
	}

	public void setDefaultPayment(String defaultPayment) {
		this.defaultPayment = defaultPayment;
	}

	public String getIco() {
		return ico;
	}

	public void setIco(String ico) {
		this.ico = ico;
	}


	@Override
	public String toString() {
		return "PaymentMethod{" +
			", key=" + key +
			", decriptron=" + decriptron +
			", state=" + state +
			", defaultPayment=" + defaultPayment +
			", ico=" + ico +
			"}";
	}
}
