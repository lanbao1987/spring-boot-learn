package com.guosen.spring.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {


    @GetMapping("/test")
    public String test(@RequestParam String name) {
        return "success," + name;
    }
}
