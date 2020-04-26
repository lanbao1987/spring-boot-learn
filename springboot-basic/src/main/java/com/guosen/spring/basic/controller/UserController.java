package com.guosen.spring.basic.controller;

import com.guosen.spring.basic.configuration.UrlConfiguration;
import com.guosen.spring.basic.dao.UserMapper;
import com.guosen.spring.basic.model.User;
import com.guosen.spring.basic.common.ReturnResult;
import com.guosen.spring.basic.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
@Api("用户的controller")
public class UserController {

    @Resource
    private UrlConfiguration urlConfiguration;

    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/insertUser")
    public String insertUser(User user) throws Exception {
        log.info("insert user:[{}]", user);
        userService.insertUser(user);
        return "success";
    }


    @RequestMapping("/getUserByName/{id}")
    public User getUserByName(@PathVariable("id") String name) {
        log.info("getUserByName ;[{}]", name);
        return userMapper.getUserByName(name);
    }

    @RequestMapping("/getUserById/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        log.info("getUserById ;[{}]", id);
        return userMapper.getUser(id);
    }

    @RequestMapping("/getUserByIdAndName/{id}/{name}")
    public User getUserByIdAndName(@PathVariable("id") Long id, @PathVariable String name) {
        log.info("getUserByIdAndName ;[{}],[{}]", id, name);
        return userMapper.getUserByIdAndName(id, name);
    }

    @GetMapping(value = "/user", produces = "application/json; charset=UTF-8")
    @ApiOperation("获取user用户信息")
    private ReturnResult<User> user() {
        log.debug("user request...");
        log.info("orderUrl:[{}]", urlConfiguration.getOrderUrl());
        log.info("shopUrl:[{}]", urlConfiguration.getShopUrl());
        User user = new User(3L, "zhangsan", null);
        ;
        return new ReturnResult<>(user);
    }

    @RequestMapping(value = "/user/{id}", produces = "application/json; charset=UTF-8")
    @ApiOperation("获取user2用户信息")
    private ReturnResult<User> user2(@PathVariable @ApiParam("id标识") Long id, User user) {
        log.info("id:[{}], name:[{}], password:[{}]", id, user.getUserName(), user.getPassword());
        return new ReturnResult<>(user);
    }

    @RequestMapping(value = "/user3/{id}", produces = "application/json; charset=UTF-8")
    private ReturnResult<User> user3(@PathVariable Long id, @RequestBody User user) {
        log.info("id:[{}], name:[{}], password:[{}]", id, user.getUserName(), user.getPassword());
        return new ReturnResult<>(user);
    }


    @RequestMapping("/listUser")
    protected ReturnResult<List<User>> listUser() {
        List<User> userList = new ArrayList<>();
        userList.add(new User(1L, "zhao", null));
        userList.add(new User(2L, "qian", "qianpwd"));
        userList.add(new User(3L, "zhangsan", "***"));
        return new ReturnResult<>(userList);
    }

    @RequestMapping("/mapUser")
    public ReturnResult<Map<String, Object>> mapUser() {
        Map map = new HashMap(16);
        map.put("user", new User(3L, "zhangsan", "***"));
        map.put("remark", null);
        return new ReturnResult<>(map);
    }
}
