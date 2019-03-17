package com.app.modules.invoice.service;

import com.app.modules.invoice.entity.Shipment;
import com.baomidou.mybatisplus.service.IService;
import org.apache.ibatis.annotations.Mapper;

/**
 *code is far away from bug with the animal protecting
 *   @description : Shipment 服务接口
 *   ---------------------------------
 * 	 @author Jang
 *   @since 2019-03-17
 */
@Mapper
public interface ShipmentService extends IService<Shipment> {
	
}
