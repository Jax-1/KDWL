package com.app.bns.dto.account;

    import java.io.Serializable;

    import com.baomidou.mybatisplus.annotations.TableField;
    import com.baomidou.mybatisplus.activerecord.Model;
    import com.baomidou.mybatisplus.annotations.TableName;
    import com.app.commom.dto.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : Account 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@TableName("t_bns_account")
public class Account extends IBaseBean {

private static final long serialVersionUID = 1L;

        private String code;
        private String sort;
    /**
     * 店主电话
     */
    @ApiModelProperty("店主电话")
    @TableField("main_phone")
        private String mainPhone;
    /**
     * 主管电话
     */
    @ApiModelProperty("主管电话")
    @TableField("person_phone")
        private String personPhone;
    /**
     * 法人名
     */
    @ApiModelProperty("法人名")
    @TableField("representative_name")
        private String representativeName;
    /**
     * 法人身份证号
     */
    @ApiModelProperty("法人身份证号")
    @TableField("representative_idcard")
        private String representativeIdcard;
    /**
     * 状态
     */
    @ApiModelProperty("状态")
        private String status;
        private String ext1;
        private String ext2;
        private String ext3;
        private String ext4;
        private String ext5;
        private String ext6;
        private String ext7;
        private String ext8;
        private String ext9;
        private String ext10;
    @TableField("update_by")
        private String updateBy;


    public String getCode() {
            return code;
            }

        public void setCode(String code) {
            this.code = code;
            }

    public String getSort() {
            return sort;
            }

        public void setSort(String sort) {
            this.sort = sort;
            }

    public String getMainPhone() {
            return mainPhone;
            }

        public void setMainPhone(String mainPhone) {
            this.mainPhone = mainPhone;
            }

    public String getPersonPhone() {
            return personPhone;
            }

        public void setPersonPhone(String personPhone) {
            this.personPhone = personPhone;
            }

    public String getRepresentativeName() {
            return representativeName;
            }

        public void setRepresentativeName(String representativeName) {
            this.representativeName = representativeName;
            }

    public String getRepresentativeIdcard() {
            return representativeIdcard;
            }

        public void setRepresentativeIdcard(String representativeIdcard) {
            this.representativeIdcard = representativeIdcard;
            }

    public String getStatus() {
            return status;
            }

        public void setStatus(String status) {
            this.status = status;
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

    public String getExt10() {
            return ext10;
            }

        public void setExt10(String ext10) {
            this.ext10 = ext10;
            }

    public String getUpdateBy() {
            return updateBy;
            }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
            }


@Override
public String toString() {
        return "Account{" +
                ", code=" + code +
                ", sort=" + sort +
                ", mainPhone=" + mainPhone +
                ", personPhone=" + personPhone +
                ", representativeName=" + representativeName +
                ", representativeIdcard=" + representativeIdcard +
                ", status=" + status +
                ", ext1=" + ext1 +
                ", ext2=" + ext2 +
                ", ext3=" + ext3 +
                ", ext4=" + ext4 +
                ", ext5=" + ext5 +
                ", ext6=" + ext6 +
                ", ext7=" + ext7 +
                ", ext8=" + ext8 +
                ", ext9=" + ext9 +
                ", ext10=" + ext10 +
                ", updateBy=" + updateBy +
        "}";
        }
        }