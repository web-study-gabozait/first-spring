package com.ex1012.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestfulController {


    @GetMapping("/add")
    public int add(@RequestParam("op1") int op1,@RequestParam("op2") int op2) {
        return op1 + op2;
    }



}
