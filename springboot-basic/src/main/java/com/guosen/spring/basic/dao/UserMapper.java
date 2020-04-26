package com.guosen.spring.basic.dao;

import com.guosen.spring.basic.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {


    User getUserByName(String name);

    @Select("select * from user where id = #{id}")
    User getUser(Long id);

    @Select("select * from user where id = #{id} and user_name=#{name}")
    User getUserByIdAndName(@Param("id") Long id, @Param("name") String username);

    @Insert("insert into user(user_name, password) values (#{userName}, #{password})")
    int insertUser(User user);
}
