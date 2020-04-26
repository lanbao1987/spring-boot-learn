package com.guosen.spring.basic.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/exception")
@Slf4j
public class ExceptionController {

    @PostMapping("/test")
    public String test(@RequestParam String name, @RequestParam String password) {
        log.info("name:[{}],password:[{}]", name, password);
        return "test";
    }

    @RequestMapping("/testnull")
    public String testnull(@RequestParam String username) throws IOException {
        log.info("username:[{}]", username);
        throw new IllegalArgumentException("");
    }

}
