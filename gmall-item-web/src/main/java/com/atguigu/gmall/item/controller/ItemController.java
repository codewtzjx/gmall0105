package com.atguigu.gmall.item.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin
public class ItemController {

    @RequestMapping
    public String index() {
        return "index";
    }
}
