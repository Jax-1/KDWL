package com.app.bns.dto.order;

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
 *   @description : UserOrder 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@TableName("t_bns_user_order")
public class UserOrder extends IBaseBean {

private static final long serialVersionUID = 1L;

    /**
     * 订单编码
     */
    @ApiModelProperty("订单编码")
    @TableField("order_code")
        private String orderCode;
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    @TableField("user_id")
        private String userId;
    /**
     * 商户ID
     */
    @ApiModelProperty("商户ID")
    @TableField("merchant_id")
        private String merchantId;
    /**
     * 订单总金额(以分为单位)
     */
    @ApiModelProperty("订单总金额(以分为单位)")
    @TableField("total_amount")
        private BigDecimal totalAmount;
    /**
     * 实付金额
     */
    @ApiModelProperty("实付金额")
    @TableField("paid_amount")
        private BigDecimal paidAmount;
    /**
     * 邮费
     */
    @ApiModelProperty("邮费")
    @TableField("postage_amount")
        private BigDecimal postageAmount;
    /**
     * 优惠金额
     */
    @ApiModelProperty("优惠金额")
    @TableField("discount_amount")
        private BigDecimal discountAmount;
    /**
     * 收货id
     */
    @ApiModelProperty("收货id")
    @TableField("receive_id")
        private String receiveId;
    /**
     * 发货时间
     */
    @ApiModelProperty("发货时间")
    @TableField("send_time")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
private Date sendTime;
    /**
     * 配送状态 1 待待配 2  已配送 3 已确认收货 4部分发货 5退货 6生成发货单
     */
    @ApiModelProperty("配送状态 1 待待配 2  已配送 3 已确认收货 4部分发货 5退货 6生成发货单")
    @TableField("logistics_state")
        private String logisticsState;
    /**
     * 开具发票标志 0 否 1 是
     */
    @ApiModelProperty("开具发票标志 0 否 1 是")
    @TableField("invoice_tag")
        private String invoiceTag;
    /**
     * 订单状态 1待确认 2已确认 3取消 4无效 5已完成
     */
    @ApiModelProperty("订单状态 1待确认 2已确认 3取消 4无效 5已完成")
    @TableField("order_state")
        private String orderState;
    /**
     * 支付方式id
     */
    @ApiModelProperty("支付方式id")
    @TableField("payment_id")
        private String paymentId;
    /**
     * 在线支付流水号
     */
    @ApiModelProperty("在线支付流水号")
    @TableField("payment_seq")
        private String paymentSeq;
    /**
     * 支付状态 1.未付款 2 已付款 3退款
     */
    @ApiModelProperty("支付状态 1.未付款 2 已付款 3退款")
    @TableField("pay_state")
        private String payState;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
        private String comment;
        private String ext1;
        private String ext2;
        private String ext3;
        private String ext4;
        private String ext5;
        private String ext6;
        private String ext7;
        private String ext8;
        private String ext9;


    public String getOrderCode() {
            return orderCode;
            }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
            }

    public String getUserId() {
            return userId;
            }

        public void setUserId(String userId) {
            this.userId = userId;
            }

    public String getMerchantId() {
            return merchantId;
            }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
            }

    public BigDecimal getTotalAmount() {
            return totalAmount;
            }

        public void setTotalAmount(BigDecimal totalAmount) {
            this.totalAmount = totalAmount;
            }

    public BigDecimal getPaidAmount() {
            return paidAmount;
            }

        public void setPaidAmount(BigDecimal paidAmount) {
            this.paidAmount = paidAmount;
            }

    public BigDecimal getPostageAmount() {
            return postageAmount;
            }

        public void setPostageAmount(BigDecimal postageAmount) {
            this.postageAmount = postageAmount;
            }

    public BigDecimal getDiscountAmount() {
            return discountAmount;
            }

        public void setDiscountAmount(BigDecimal discountAmount) {
            this.discountAmount = discountAmount;
            }

    public String getReceiveId() {
            return receiveId;
            }

        public void setReceiveId(String receiveId) {
            this.receiveId = receiveId;
            }

    public Date getSendTime() {
            return sendTime;
            }

        public void setSendTime(Date sendTime) {
            this.sendTime = sendTime;
            }

    public String getLogisticsState() {
            return logisticsState;
            }

        public void setLogisticsState(String logisticsState) {
            this.logisticsState = logisticsState;
            }

    public String getInvoiceTag() {
            return invoiceTag;
            }

        public void setInvoiceTag(String invoiceTag) {
            this.invoiceTag = invoiceTag;
            }

    public String getOrderState() {
            return orderState;
            }

        public void setOrderState(String orderState) {
            this.orderState = orderState;
            }

    public String getPaymentId() {
            return paymentId;
            }

        public void setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            }

    public String getPaymentSeq() {
            return paymentSeq;
            }

        public void setPaymentSeq(String paymentSeq) {
            this.paymentSeq = paymentSeq;
            }

    public String getPayState() {
            return payState;
            }

        public void setPayState(String payState) {
            this.payState = payState;
            }

    public String getComment() {
            return comment;
            }

        public void setComment(String comment) {
            this.comment = comment;
            }

    public String getExt1() {
            return ext1;
            }

        public void setExt1(String ext1) {
            this.ext1 = ext1;
            }

    public String getExt2() {
            return ext2;
            }

        public void setExt2(String ext2) {
            this.ext2 = ext2;
            }

    public String getExt3() {
            return ext3;
            }

        public void setExt3(String ext3) {
            this.ext3 = ext3;
            }

    public String getExt4() {
            return ext4;
            }

        public void setExt4(String ext4) {
            this.ext4 = ext4;
            }

    public String getExt5() {
            return ext5;
            }

        public void setExt5(String ext5) {
            this.ext5 = ext5;
            }

    public String getExt6() {
            return ext6;
            }

        public void setExt6(String ext6) {
            this.ext6 = ext6;
            }

    public String getExt7() {
            return ext7;
            }

        public void setExt7(String ext7) {
            this.ext7 = ext7;
            }

    public String getExt8() {
            return ext8;
            }

        public void setExt8(String ext8) {
            this.ext8 = ext8;
            }

    public String getExt9() {
            return ext9;
            }

        public void setExt9(String ext9) {
            this.ext9 = ext9;
            }


@Override
public String toString() {
        return "UserOrder{" +
                ", orderCode=" + orderCode +
                ", userId=" + userId +
                ", merchantId=" + merchantId +
                ", totalAmount=" + totalAmount +
                ", paidAmount=" + paidAmount +
                ", postageAmount=" + postageAmount +
                ", discountAmount=" + discountAmount +
                ", receiveId=" + receiveId +
                ", sendTime=" + sendTime +
                ", logisticsState=" + logisticsState +
                ", invoiceTag=" + invoiceTag +
                ", orderState=" + orderState +
                ", paymentId=" + paymentId +
                ", paymentSeq=" + paymentSeq +
                ", payState=" + payState +
                ", comment=" + comment +
                ", ext1=" + ext1 +
                ", ext2=" + ext2 +
                ", ext3=" + ext3 +
                ", ext4=" + ext4 +
                ", ext5=" + ext5 +
                ", ext6=" + ext6 +
                ", ext7=" + ext7 +
                ", ext8=" + ext8 +
                ", ext9=" + ext9 +
        "}";
        }
        }