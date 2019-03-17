package com.app.base.basic;


import com.app.base.page.WhereType;
import com.app.base.page.WhereTypeEnum;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础Bean
 *
 * @author Jang
 */
public class IBaseBean extends Model {

    private static final long serialVersionUID = 1L;
    @WhereType(type = WhereTypeEnum.EQ)
    private Integer id;
    @WhereType(type = WhereTypeEnum.LIKE)
    private String name;
    private Boolean deleted;
    private Date dateModified;
    private Date dateEntered;
    private Integer createdBy;

    @Override
    public  Serializable pkVal(){
        return this.id;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

}
