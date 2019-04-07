package com.app.pay.dto;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.app.commom.dto.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : PaymentRefund 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-07
 */
@TableName("t_pay_payment_refund")
public class PaymentRefund extends IBaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号
     */
	@ApiModelProperty("订单号")
	@TableField("order_number")
	private String orderNumber;
    /**
     * 退款单号
     */
	@ApiModelProperty("退款单号")
	@TableField("refund_number")
	private String refundNumber;
    /**
     * 微信支付订单号
     */
	@ApiModelProperty("微信支付订单号")
	@TableField("transaction_id")
	private String transactionId;
    /**
     * 金额
     */
	@ApiModelProperty("金额")
	@TableField("total_amount")
	private BigDecimal totalAmount;
	@TableField("refund_fee")
	private BigDecimal refundFee;
	@TableField("refund_desc")
	private String refundDesc;
    /**
     * 退款状态：0 失败 1成功
     */
	@ApiModelProperty("退款状态：0 失败 1成功")
	private Boolean state;
	@TableField("return_code")
	private String returnCode;
	@TableField("return_msg")
	private String returnMsg;
	@TableField("result_code")
	private String resultCode;
	@TableField("err_code")
	private String errCode;
	@TableField("err_code_des")
	private String errCodeDes;
	@TableField("action_admin")
	private String actionAdmin;
	@TableField("create_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	@TableField("update_time")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date updateTime;


	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getRefundNumber() {
		return refundNumber;
	}

	public void setRefundNumber(String refundNumber) {
		this.refundNumber = refundNumber;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public BigDecimal getRefundFee() {
		return refundFee;
	}

	public void setRefundFee(BigDecimal refundFee) {
		this.refundFee = refundFee;
	}

	public String getRefundDesc() {
		return refundDesc;
	}

	public void setRefundDesc(String refundDesc) {
		this.refundDesc = refundDesc;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrCodeDes() {
		return errCodeDes;
	}

	public void setErrCodeDes(String errCodeDes) {
		this.errCodeDes = errCodeDes;
	}

	public String getActionAdmin() {
		return actionAdmin;
	}

	public void setActionAdmin(String actionAdmin) {
		this.actionAdmin = actionAdmin;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


	@Override
	public String toString() {
		return "PaymentRefund{" +
			", orderNumber=" + orderNumber +
			", refundNumber=" + refundNumber +
			", transactionId=" + transactionId +
			", totalAmount=" + totalAmount +
			", refundFee=" + refundFee +
			", refundDesc=" + refundDesc +
			", state=" + state +
			", returnCode=" + returnCode +
			", returnMsg=" + returnMsg +
			", resultCode=" + resultCode +
			", errCode=" + errCode +
			", errCodeDes=" + errCodeDes +
			", actionAdmin=" + actionAdmin +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			"}";
	}
}
