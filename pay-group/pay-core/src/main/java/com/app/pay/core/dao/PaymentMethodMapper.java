package com.app.pay.core.dao;

import com.app.pay.dto.PaymentMethod;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 *   @description : PaymentMethod Mapper 接口
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-07
 */
@Mapper
public interface PaymentMethodMapper extends BaseMapper<PaymentMethod> {

}