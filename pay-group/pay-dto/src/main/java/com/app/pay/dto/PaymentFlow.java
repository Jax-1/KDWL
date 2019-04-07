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
 *   @description : PaymentFlow 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-07
 */
@TableName("t_pay_payment_flow")
public class PaymentFlow extends IBaseBean {

    private static final long serialVersionUID = 1L;

    /**
     * 微信支付订单号
     */
	@ApiModelProperty("微信支付订单号")
	@TableField("transaction_id")
	private String transactionId;
    /**
     * 支付流水号
     */
	@ApiModelProperty("支付流水号")
	@TableField("out_trade_no")
	private String outTradeNo;
    /**
     * 设备号
     */
	@ApiModelProperty("设备号")
	@TableField("device_info")
	private String deviceInfo;
    /**
     * 随机字符串
     */
	@ApiModelProperty("随机字符串")
	@TableField("nonce_str")
	private String nonceStr;
    /**
     * 签名
     */
	@ApiModelProperty("签名")
	private String sign;
    /**
     * 签名类型
     */
	@ApiModelProperty("签名类型")
	@TableField("sign_type")
	private String signType;
    /**
     * 业务结果
     */
	@ApiModelProperty("业务结果")
	@TableField("result_code")
	private String resultCode;
    /**
     * 错误代码
     */
	@ApiModelProperty("错误代码")
	@TableField("err_code")
	private String errCode;
    /**
     * 错误代码描述
     */
	@ApiModelProperty("错误代码描述")
	@TableField("err_code_des")
	private String errCodeDes;
    /**
     * 用户标识
     */
	@ApiModelProperty("用户标识")
	private String openid;
    /**
     * 是否关注公众账号
     */
	@ApiModelProperty("是否关注公众账号")
	@TableField("is_subscribe")
	private String isSubscribe;
    /**
     * 交易类型
     */
	@ApiModelProperty("交易类型")
	@TableField("trade_type")
	private String tradeType;
    /**
     * 付款银行
     */
	@ApiModelProperty("付款银行")
	@TableField("bank_type")
	private String bankType;
    /**
     * 订单金额
     */
	@ApiModelProperty("订单金额")
	@TableField("total_fee")
	private Integer totalFee;
    /**
     * 货币种类
     */
	@ApiModelProperty("货币种类")
	@TableField("fee_type")
	private String feeType;
	@TableField("time_end")
	private String timeEnd;
    /**
     * 商户订单号
     */
	@ApiModelProperty("商户订单号")
	private String attach;


	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(String deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIsSubscribe() {
		return isSubscribe;
	}

	public void setIsSubscribe(String isSubscribe) {
		this.isSubscribe = isSubscribe;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public Integer getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Integer totalFee) {
		this.totalFee = totalFee;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}


	@Override
	public String toString() {
		return "PaymentFlow{" +
			", transactionId=" + transactionId +
			", outTradeNo=" + outTradeNo +
			", deviceInfo=" + deviceInfo +
			", nonceStr=" + nonceStr +
			", sign=" + sign +
			", signType=" + signType +
			", resultCode=" + resultCode +
			", errCode=" + errCode +
			", errCodeDes=" + errCodeDes +
			", openid=" + openid +
			", isSubscribe=" + isSubscribe +
			", tradeType=" + tradeType +
			", bankType=" + bankType +
			", totalFee=" + totalFee +
			", feeType=" + feeType +
			", timeEnd=" + timeEnd +
			", attach=" + attach +
			"}";
	}
}
