package com.app.kdwl.service;

import com.app.kdwl.dto.invoice.ShipmentDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


@Component
@FeignClient(value = "base-core")
public interface BaseCoreFeignClient {

    @RequestMapping(value = "/invoice/shipment/getShipmentList")
    String queryShipmentPage(ShipmentDto param, Integer length, Integer pageNo);
}
