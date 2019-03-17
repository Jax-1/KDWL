package com.app.modules.invoice.service.impl;

import com.app.modules.invoice.entity.Team;
import com.app.modules.invoice.dao.TeamMapper;
import com.app.modules.invoice.service.TeamService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *   @description : Team 服务实现类
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-17
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements TeamService {
	
}
