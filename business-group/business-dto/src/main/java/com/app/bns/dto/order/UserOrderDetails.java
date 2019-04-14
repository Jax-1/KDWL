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
 *   @description : UserOrderDetails 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-14
 */
@TableName("t_bns_user_order_details")
public class UserOrderDetails extends IBaseBean {

private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @ApiModelProperty("订单id")
    @TableField("parent_id")
        private String parentId;
    /**
     * 订单号
     */
    @ApiModelProperty("订单号")
    @TableField("parent_code")
        private String parentCode;
    /**
     * 商品规格价格id
     */
    @ApiModelProperty("商品规格价格id")
    @TableField("price_id")
        private String priceId;
    /**
     * 详情类型 商户/商品
     */
    @ApiModelProperty("详情类型 商户/商品")
    @TableField("details_type")
        private String detailsType;
    /**
     * 商品/商户id
     */
    @ApiModelProperty("商品/商户id")
    @TableField("goods_id")
        private String goodsId;
    /**
     * 商品主图
     */
    @ApiModelProperty("商品主图")
        private String image;
    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    @TableField("goods_name")
        private String goodsName;
    /**
     * 商品规格价格(以分为单位)
     */
    @ApiModelProperty("商品规格价格(以分为单位)")
    @TableField("unit_price")
        private BigDecimal unitPrice;
    /**
     * 个数
     */
    @ApiModelProperty("个数")
        private Integer num;
    /**
     * 订单单品总价(以分为单位)
     */
    @ApiModelProperty("订单单品总价(以分为单位)")
    @TableField("details_amount")
        private BigDecimal detailsAmount;
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
private Date ext1;
        private String ext2;
        private String ext3;
        private String ext4;
        private String ext5;


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

    public String getPriceId() {
            return priceId;
            }

        public void setPriceId(String priceId) {
            this.priceId = priceId;
            }

    public String getDetailsType() {
            return detailsType;
            }

        public void setDetailsType(String detailsType) {
            this.detailsType = detailsType;
            }

    public String getGoodsId() {
            return goodsId;
            }

        public void setGoodsId(String goodsId) {
            this.goodsId = goodsId;
            }

    public String getImage() {
            return image;
            }

        public void setImage(String image) {
            this.image = image;
            }

    public String getGoodsName() {
            return goodsName;
            }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
            }

    public BigDecimal getUnitPrice() {
            return unitPrice;
            }

        public void setUnitPrice(BigDecimal unitPrice) {
            this.unitPrice = unitPrice;
            }

    public Integer getNum() {
            return num;
            }

        public void setNum(Integer num) {
            this.num = num;
            }

    public BigDecimal getDetailsAmount() {
            return detailsAmount;
            }

        public void setDetailsAmount(BigDecimal detailsAmount) {
            this.detailsAmount = detailsAmount;
            }

    public Date getExt1() {
            return ext1;
            }

        public void setExt1(Date ext1) {
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
        return "UserOrderDetails{" +
                ", parentId=" + parentId +
                ", parentCode=" + parentCode +
                ", priceId=" + priceId +
                ", detailsType=" + detailsType +
                ", goodsId=" + goodsId +
                ", image=" + image +
                ", goodsName=" + goodsName +
                ", unitPrice=" + unitPrice +
                ", num=" + num +
                ", detailsAmount=" + detailsAmount +
                ", ext1=" + ext1 +
                ", ext2=" + ext2 +
                ", ext3=" + ext3 +
                ", ext4=" + ext4 +
                ", ext5=" + ext5 +
        "}";
        }
        }