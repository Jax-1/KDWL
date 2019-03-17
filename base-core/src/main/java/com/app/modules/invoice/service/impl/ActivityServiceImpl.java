package com.app.modules.invoice.service.impl;

import com.app.modules.invoice.entity.Activity;
import com.app.modules.invoice.dao.ActivityMapper;
import com.app.modules.invoice.service.ActivityService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *   @description : Activity 服务实现类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-17
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {
	
}
