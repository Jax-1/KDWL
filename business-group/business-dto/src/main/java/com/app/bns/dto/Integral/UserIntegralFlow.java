package com.app.bns.dto.Integral;

    import java.io.Serializable;

    import java.util.Date;
    import com.baomidou.mybatisplus.annotations.TableField;
    import com.baomidou.mybatisplus.activerecord.Model;
    import com.baomidou.mybatisplus.annotations.TableName;
    import com.app.commom.dto.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : UserIntegralFlow 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@TableName("t_bns_user_integral_flow")
public class UserIntegralFlow extends IBaseBean {

private static final long serialVersionUID = 1L;

    @TableField("user_id")
        private String userId;
    /**
     * 充值/支出
     */
    @ApiModelProperty("充值/支出")
        private String type;
    /**
     * 状态
     */
    @ApiModelProperty("状态")
        private String status;
    /**
     * 总积分
     */
    @ApiModelProperty("总积分")
    @TableField("total_integral")
        private String totalIntegral;
    /**
     * 剩余积分
     */
    @ApiModelProperty("剩余积分")
    @TableField("last_integral")
        private String lastIntegral;
    /**
     * 已使用积分
     */
    @ApiModelProperty("已使用积分")
    @TableField("used_integral")
        private String usedIntegral;
    /**
     * 支出订单ID
     */
    @ApiModelProperty("支出订单ID")
    @TableField("order_id")
        private String orderId;
    /**
     * 支出积分源ID，多个使用","分隔
     */
    @ApiModelProperty("支出积分源ID，多个使用,分隔")
    @TableField("parent_id")
        private String parentId;
    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    @TableField("date_start")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
private Date dateStart;
    /**
     * 有效期间（天）
     */
    @ApiModelProperty("有效期间（天）")
        private Integer period;
    /**
     * 最后支出时间
     */
    @ApiModelProperty("最后支出时间")
    @TableField("date_last")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
private Date dateLast;
        private String ext1;
        private String ext2;
        private String ext3;
        private String ext4;
        private String ext5;
        private String ext6;


    public String getUserId() {
            return userId;
            }

        public void setUserId(String userId) {
            this.userId = userId;
            }

    public String getType() {
            return type;
            }

        public void setType(String type) {
            this.type = type;
            }

    public String getStatus() {
            return status;
            }

        public void setStatus(String status) {
            this.status = status;
            }

    public String getTotalIntegral() {
            return totalIntegral;
            }

        public void setTotalIntegral(String totalIntegral) {
            this.totalIntegral = totalIntegral;
            }

    public String getLastIntegral() {
            return lastIntegral;
            }

        public void setLastIntegral(String lastIntegral) {
            this.lastIntegral = lastIntegral;
            }

    public String getUsedIntegral() {
            return usedIntegral;
            }

        public void setUsedIntegral(String usedIntegral) {
            this.usedIntegral = usedIntegral;
            }

    public String getOrderId() {
            return orderId;
            }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
            }

    public String getParentId() {
            return parentId;
            }

        public void setParentId(String parentId) {
            this.parentId = parentId;
            }

    public Date getDateStart() {
            return dateStart;
            }

        public void setDateStart(Date dateStart) {
            this.dateStart = dateStart;
            }

    public Integer getPeriod() {
            return period;
            }

        public void setPeriod(Integer period) {
            this.period = period;
            }

    public Date getDateLast() {
            return dateLast;
            }

        public void setDateLast(Date dateLast) {
            this.dateLast = dateLast;
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


@Override
public String toString() {
        return "UserIntegralFlow{" +
                ", userId=" + userId +
                ", type=" + type +
                ", status=" + status +
                ", totalIntegral=" + totalIntegral +
                ", lastIntegral=" + lastIntegral +
                ", usedIntegral=" + usedIntegral +
                ", orderId=" + orderId +
                ", parentId=" + parentId +
                ", dateStart=" + dateStart +
                ", period=" + period +
                ", dateLast=" + dateLast +
                ", ext1=" + ext1 +
                ", ext2=" + ext2 +
                ", ext3=" + ext3 +
                ", ext4=" + ext4 +
                ", ext5=" + ext5 +
                ", ext6=" + ext6 +
        "}";
        }
        }