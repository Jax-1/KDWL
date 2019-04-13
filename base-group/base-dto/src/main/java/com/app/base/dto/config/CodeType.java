package com.app.base.dto.config;

    import java.io.Serializable;

    import com.baomidou.mybatisplus.annotations.TableId;
    import com.baomidou.mybatisplus.annotations.TableField;
    import com.baomidou.mybatisplus.activerecord.Model;
    import com.baomidou.mybatisplus.annotations.TableName;
    import com.app.commom.dto.IBaseBean;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import io.swagger.annotations.ApiModelProperty;

/**
 *   @description : CodeType 实体类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-13
 */
@TableName("t_sys_code_type")
public class CodeType extends IBaseBean {

private static final long serialVersionUID = 1L;

                    @TableId("type_code")
                private String typeCode;
    @TableField("type_name")
        private String typeName;
    @TableField("create_by")
        private String createBy;
        private String remarks;


    public String getTypeCode() {
            return typeCode;
            }

        public void setTypeCode(String typeCode) {
            this.typeCode = typeCode;
            }

    public String getTypeName() {
            return typeName;
            }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
            }

    public String getCreateBy() {
            return createBy;
            }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
            }

    public String getRemarks() {
            return remarks;
            }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
            }


@Override
public String toString() {
        return "CodeType{" +
                ", typeCode=" + typeCode +
                ", typeName=" + typeName +
                ", createBy=" + createBy +
                ", remarks=" + remarks +
        "}";
        }
        }