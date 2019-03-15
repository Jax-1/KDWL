package com.kdwl.invoice.dao;

import com.kdwl.invoice.entity.Shipment;
import com.kdwl.core.include.mapper.IBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *   @description : Shipment Mapper 接口
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-14
 */
@Mapper
public interface ShipmentMapper extends IBaseMapper<Shipment> {

}