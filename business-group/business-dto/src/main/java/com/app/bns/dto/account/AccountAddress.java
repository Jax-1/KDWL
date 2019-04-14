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
 *   @description : AccountAddress 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@TableName("t_bns_account_address")
public class AccountAddress extends IBaseBean {

private static final long serialVersionUID = 1L;

    /**
     * 父级ID
     */
    @ApiModelProperty("父级ID")
    @TableField("parent_id")
        private String parentId;
    /**
     * 父级编码
     */
    @ApiModelProperty("父级编码")
    @TableField("parent_code")
        private String parentCode;
    /**
     * 地址类型
     */
    @ApiModelProperty("地址类型")
        private String type;
    /**
     * 省
     */
    @ApiModelProperty("省")
        private String province;
    /**
     * 市
     */
    @ApiModelProperty("市")
        private String cityarea;
    /**
     * 县
     */
    @ApiModelProperty("县")
        private String county;
    /**
     * 街道
     */
    @ApiModelProperty("街道")
        private String street;
    /**
     * 经度
     */
    @ApiModelProperty("经度")
        private String longitude;
    /**
     * 纬度
     */
    @ApiModelProperty("纬度")
        private String latitude;
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
    @TableField("update_by")
        private String updateBy;


    public String getParentId() {
            return parentId;
            }

        public void setParentId(String parentId) {
            this.parentId = parentId;
            }

    public String getParentCode() {
            return parentCode;
            }

        public void setParentCode(String parentCode) {
            this.parentCode = parentCode;
            }

    public String getType() {
            return type;
            }

        public void setType(String type) {
            this.type = type;
            }

    public String getProvince() {
            return province;
            }

        public void setProvince(String province) {
            this.province = province;
            }

    public String getCityarea() {
            return cityarea;
            }

        public void setCityarea(String cityarea) {
            this.cityarea = cityarea;
            }

    public String getCounty() {
            return county;
            }

        public void setCounty(String county) {
            this.county = county;
            }

    public String getStreet() {
            return street;
            }

        public void setStreet(String street) {
            this.street = street;
            }

    public String getLongitude() {
            return longitude;
            }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
            }

    public String getLatitude() {
            return latitude;
            }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
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

    public String getUpdateBy() {
            return updateBy;
            }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
            }


@Override
public String toString() {
        return "AccountAddress{" +
                ", parentId=" + parentId +
                ", parentCode=" + parentCode +
                ", type=" + type +
                ", province=" + province +
                ", cityarea=" + cityarea +
                ", county=" + county +
                ", street=" + street +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", status=" + status +
                ", ext1=" + ext1 +
                ", ext2=" + ext2 +
                ", ext3=" + ext3 +
                ", ext4=" + ext4 +
                ", ext5=" + ext5 +
                ", updateBy=" + updateBy +
        "}";
        }
        }