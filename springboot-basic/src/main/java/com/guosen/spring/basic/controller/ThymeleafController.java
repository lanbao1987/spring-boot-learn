package com.guosen.spring.basic.controller;

import com.guosen.spring.basic.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {


    @GetMapping("/test404")
    public String test404(){
        return "index";
    }

    @GetMapping("/test500")
    public String test500(){
        int i = 1/0;
        return "index";
    }

    @GetMapping("/blog")
    public String blog(Model model){
        User user = new User(3L,"张三","666");
        model.addAttribute("user",user);
        return "index";
    }

    @GetMapping("/listblog")
    public String listblog(Model model){
        User user = new User(3L,"张三","666");
        User user2 = new User(2L,"李四","777");

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        model.addAttribute("list",list);
        return "list";
    }
}
