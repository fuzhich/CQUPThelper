package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Usermapper {

    //查询全部用户信息
    @Select("select * from user")
    public List<User> list();
    @Select("select * from user where id = #{id}")
    public User get(int id);

    }

