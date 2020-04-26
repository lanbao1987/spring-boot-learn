package com.guosen.spring.basic.service;

import com.guosen.spring.basic.dao.UserMapper;
import com.guosen.spring.basic.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.SQLException;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;


    @Transactional
    public int insertUser(User user) throws Exception {
        int i = userMapper.insertUser(user);
        insertUser2(user);
        return 1;
    }


    @Transactional
    public void insertUser2(User user) {
        userMapper.insertUser(user);
        throw new RuntimeException("user22");
    }
}
