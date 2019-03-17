package com.app.kdwl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("")
public class IndexController {


    @RequestMapping("")
    public String toIndex(Model model){
        model.addAttribute("page","kdwl/main");
        return "index";
    }
    @RequestMapping("/{page}")
    public String toPage(Model model, @PathVariable String page){
        model.addAttribute("page","kdwl/"+page);
       return "index";
    }
}
