package com.app.bns.dto.Integral;

    import java.io.Serializable;

    import com.baomidou.mybatisplus.annotations.TableField;
    import com.baomidou.mybatisplus.activerecord.Model;
    import com.baomidou.mybatisplus.annotations.TableName;
    import com.app.commom.dto.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : UserIntegral 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@TableName("t_bns_user_integral")
public class UserIntegral extends IBaseBean {

private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    @TableField("user_id")
        private String userId;
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
        private String ext1;
        private String ext2;
        private String ext3;
        private String ext4;
        private String ext5;


    public String getUserId() {
            return userId;
            }

        public void setUserId(String userId) {
            this.userId = userId;
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


@Override
public String toString() {
        return "UserIntegral{" +
                ", userId=" + userId +
                ", totalIntegral=" + totalIntegral +
                ", lastIntegral=" + lastIntegral +
                ", usedIntegral=" + usedIntegral +
                ", ext1=" + ext1 +
                ", ext2=" + ext2 +
                ", ext3=" + ext3 +
                ", ext4=" + ext4 +
                ", ext5=" + ext5 +
        "}";
        }
        }