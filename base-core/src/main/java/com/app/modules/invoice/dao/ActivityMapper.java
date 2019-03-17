package com.app.modules.invoice.dao;

import com.app.modules.invoice.entity.Activity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *   @description : Activity Mapper 接口
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-17
 */
@Mapper
public interface ActivityMapper extends BaseMapper<Activity> {

}