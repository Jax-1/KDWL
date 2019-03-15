package com.kdwl.invoice.service.impl;

import com.kdwl.invoice.entity.Activity;
import com.kdwl.invoice.dao.ActivityMapper;
import com.kdwl.invoice.service.ActivityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *   @description : Activity 服务实现类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-14
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
	
}
