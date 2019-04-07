package com.app.pay.core.service.impl;

import com.app.pay.dto.PaymentMethod;
import com.app.pay.core.dao.PaymentMethodMapper;
import com.app.pay.core.service.PaymentMethodService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *   @description : PaymentMethod 服务实现类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-04-07
 */
@Service
public class PaymentMethodServiceImpl extends ServiceImpl<PaymentMethodMapper, PaymentMethod> implements PaymentMethodService {
	
}
