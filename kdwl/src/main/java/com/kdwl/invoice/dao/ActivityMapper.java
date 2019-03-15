package com.kdwl.invoice.dao;

import com.kdwl.invoice.entity.Activity;
import com.kdwl.core.include.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *   @description : Activity Mapper 接口
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-14
 */
@Mapper
public interface ActivityMapper extends IBaseMapper<Activity> {

}