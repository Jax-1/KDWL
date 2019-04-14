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
 *   @description : AccountWarrant 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@TableName("t_bns_account_warrant")
public class AccountWarrant extends IBaseBean {

private static final long serialVersionUID = 1L;

    @TableField("parent_id")
        private String parentId;
    @TableField("code_type")
        private String codeType;
    /**
     * 证件类型
     */
    @ApiModelProperty("证件类型")
    @TableField("card_type")
        private String cardType;
    @TableField("card_file")
        private String cardFile;
    /**
     * 备案号（注册号）
     */
    @ApiModelProperty("备案号（注册号）")
    @TableField("case_number")
        private String caseNumber;
    /**
     * 单位名称
     */
    @ApiModelProperty("单位名称")
    @TableField("company_name")
        private String companyName;
    /**
     * 注册地址
     */
    @ApiModelProperty("注册地址")
    @TableField("case_address_id")
        private String caseAddressId;
    /**
     * 法定代表人
     */
    @ApiModelProperty("法定代表人")
    @TableField("representative_name")
        private String representativeName;
    /**
     * 法定代表人证件号
     */
    @ApiModelProperty("法定代表人证件号")
    @TableField("representative_idcard")
        private String representativeIdcard;
    /**
     * 营业项目
     */
    @ApiModelProperty("营业项目")
        private String business;
    /**
     * 证件有效期
     */
    @ApiModelProperty("证件有效期")
    @TableField("card_time_limit")
        private String cardTimeLimit;
    /**
     * 到期时间
     */
    @ApiModelProperty("到期时间")
    @TableField("card_beend")
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
private Date cardBeend;
        private String ext1;
        private String ext2;
        private String ext3;
        private String ext4;
        private String ext5;
    @TableField("update_by")
        private String updateBy;


    public String getParentId() {
            return parentId;
            }

        public void setParentId(String parentId) {
            this.parentId = parentId;
            }

    public String getCodeType() {
            return codeType;
            }

        public void setCodeType(String codeType) {
            this.codeType = codeType;
            }

    public String getCardType() {
            return cardType;
            }

        public void setCardType(String cardType) {
            this.cardType = cardType;
            }

    public String getCardFile() {
            return cardFile;
            }

        public void setCardFile(String cardFile) {
            this.cardFile = cardFile;
            }

    public String getCaseNumber() {
            return caseNumber;
            }

        public void setCaseNumber(String caseNumber) {
            this.caseNumber = caseNumber;
            }

    public String getCompanyName() {
            return companyName;
            }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
            }

    public String getCaseAddressId() {
            return caseAddressId;
            }

        public void setCaseAddressId(String caseAddressId) {
            this.caseAddressId = caseAddressId;
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

    public String getBusiness() {
            return business;
            }

        public void setBusiness(String business) {
            this.business = business;
            }

    public String getCardTimeLimit() {
            return cardTimeLimit;
            }

        public void setCardTimeLimit(String cardTimeLimit) {
            this.cardTimeLimit = cardTimeLimit;
            }

    public Date getCardBeend() {
            return cardBeend;
            }

        public void setCardBeend(Date cardBeend) {
            this.cardBeend = cardBeend;
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
        return "AccountWarrant{" +
                ", parentId=" + parentId +
                ", codeType=" + codeType +
                ", cardType=" + cardType +
                ", cardFile=" + cardFile +
                ", caseNumber=" + caseNumber +
                ", companyName=" + companyName +
                ", caseAddressId=" + caseAddressId +
                ", representativeName=" + representativeName +
                ", representativeIdcard=" + representativeIdcard +
                ", business=" + business +
                ", cardTimeLimit=" + cardTimeLimit +
                ", cardBeend=" + cardBeend +
                ", ext1=" + ext1 +
                ", ext2=" + ext2 +
                ", ext3=" + ext3 +
                ", ext4=" + ext4 +
                ", ext5=" + ext5 +
                ", updateBy=" + updateBy +
        "}";
        }
        }