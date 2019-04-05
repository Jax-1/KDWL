package com.app.commom.util;

import com.app.commom.dto.IBaseBean;
import com.app.commom.enumerate.AppEnum;

/**
 * @Class ProcessDTO
 * @Author zhangjie
 * @Description //BEAN工具类
 * @Date 2019/4/5 17:39
 * @Version 1.0
 **/
public class ProcessDTO {
    public static IBaseBean setId(IBaseBean iBaseBean){
        iBaseBean.setId(UUIDUtil.getUUID());
        return iBaseBean;
    }
    public static IBaseBean setBaseInfo(IBaseBean iBaseBean){
        iBaseBean.setId(UUIDUtil.getUUID());
        iBaseBean.setDateEntered(DateFormatUtil.getDate());
        //iBaseBean.setDeleted(AppEnum.BaseDTOCode.DEFAULT_NO_FLG.getName());
        return iBaseBean;
    }
}
