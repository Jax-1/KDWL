package com.app.auth.util;

import com.app.auth.dto.AuthUser;
import com.app.commom.dto.IBaseBean;
import com.app.commom.enumerate.AppEnum;
import com.app.commom.util.DateFormatUtil;
import com.app.commom.util.UUIDUtil;
import com.app.commom.util.Validate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

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
    public static void setBaseInfo(IBaseBean iBaseBean){
        iBaseBean.setId(UUIDUtil.getUUID());
        iBaseBean.setDateEntered(DateFormatUtil.getDate());
        Object user=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(Validate.instanceofClass(user,UserDetails.class)){
            //用户已登录
            AuthUser authUser=(AuthUser) user;
            iBaseBean.setCreatedBy(authUser.getId());
        }
        iBaseBean.setDeleted(AppEnum.BaseDTOCode.DEFAULT_NO_FLG.getName());
    }
}
