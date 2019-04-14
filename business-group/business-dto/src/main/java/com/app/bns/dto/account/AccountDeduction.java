package com.app.bns.dto.account;

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
 *   @description : AccountDeduction 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@TableName("t_bns_account_deduction")
public class AccountDeduction extends IBaseBean {

private static final long serialVersionUID = 1L;

    @TableField("account_id")
        private String accountId;
    /**
     * 抵扣规则 长期/期间
     */
    @ApiModelProperty("抵扣规则 长期/期间")
        private String type;
    /**
     * 状态
     */
    @ApiModelProperty("状态")
        private String status;
    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    @TableField("date_start")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
private Date dateStart;
    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    @TableField("date_end")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
private Date dateEnd;
    /**
     * 比例 %
     */
    @ApiModelProperty("比例 %")
        private Float scale;
        private String ext1;
        private String ext2;
        private String ext3;
        private String ext4;
        private String ext5;
    @TableField("update_by")
        private String updateBy;


    public String getAccountId() {
            return accountId;
            }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
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

    public Date getDateStart() {
            return dateStart;
            }

        public void setDateStart(Date dateStart) {
            this.dateStart = dateStart;
            }

    public Date getDateEnd() {
            return dateEnd;
            }

        public void setDateEnd(Date dateEnd) {
            this.dateEnd = dateEnd;
            }

    public Float getScale() {
            return scale;
            }

        public void setScale(Float scale) {
            this.scale = scale;
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

    public String getUpdateBy() {
            return updateBy;
            }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
            }


@Override
public String toString() {
        return "AccountDeduction{" +
                ", accountId=" + accountId +
                ", type=" + type +
                ", status=" + status +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", scale=" + scale +
                ", ext1=" + ext1 +
                ", ext2=" + ext2 +
                ", ext3=" + ext3 +
                ", ext4=" + ext4 +
                ", ext5=" + ext5 +
                ", updateBy=" + updateBy +
        "}";
        }
        }