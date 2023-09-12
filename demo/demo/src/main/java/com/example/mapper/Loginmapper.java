package com.example.mapper;

import com.example.pojo.Admin;
import com.example.pojo.Login;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Loginmapper {
    @Select("select * from user")
    public List<Login> list();
}
