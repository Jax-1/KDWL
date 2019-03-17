package com.app.kdwl.controller.manage;

import com.app.kdwl.dto.invoice.ShipmentDto;
import com.app.kdwl.service.BaseCoreFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kdwl/manage")
public class ManageController {
    @Autowired
    BaseCoreFeignClient baseCoreFeignClient;

    @RequestMapping("queryShipment")
    public String queryShipMentPage(ShipmentDto param, Integer length, Integer pageNo, Model model){

        model.addAttribute("result",baseCoreFeignClient.queryShipmentPage(param,length,pageNo));
        return "manage/invoice/manageshipment";
    }
}
