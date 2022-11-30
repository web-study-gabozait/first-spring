package com.security.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/sub")
    public String sub() {
        return "sub";
    }
}
