package com.app.base.dto.config;

    import java.io.Serializable;

    import com.baomidou.mybatisplus.annotations.TableField;
    import com.baomidou.mybatisplus.activerecord.Model;
    import com.baomidou.mybatisplus.annotations.TableName;
    import com.app.commom.dto.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : CodeItem 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-13
 */
@TableName("t_sys_code_item")
public class CodeItem extends IBaseBean {

private static final long serialVersionUID = 1L;

    @TableField("type_code")
        private String typeCode;
    @TableField("item_code")
        private String itemCode;
    @TableField("item_name")
        private String itemName;
    @TableField("item_remarks")
        private String itemRemarks;
    /**
     * 父级编码
     */
    @ApiModelProperty("父级编码")
    @TableField("parent_code")
        private String parentCode;


    public String getTypeCode() {
            return typeCode;
            }

        public void setTypeCode(String typeCode) {
            this.typeCode = typeCode;
            }

    public String getItemCode() {
            return itemCode;
            }

        public void setItemCode(String itemCode) {
            this.itemCode = itemCode;
            }

    public String getItemName() {
            return itemName;
            }

        public void setItemName(String itemName) {
            this.itemName = itemName;
            }

    public String getItemRemarks() {
            return itemRemarks;
            }

        public void setItemRemarks(String itemRemarks) {
            this.itemRemarks = itemRemarks;
            }

    public String getParentCode() {
            return parentCode;
            }

        public void setParentCode(String parentCode) {
            this.parentCode = parentCode;
            }


@Override
public String toString() {
        return "CodeItem{" +
                ", typeCode=" + typeCode +
                ", itemCode=" + itemCode +
                ", itemName=" + itemName +
                ", itemRemarks=" + itemRemarks +
                ", parentCode=" + parentCode +
        "}";
        }
        }