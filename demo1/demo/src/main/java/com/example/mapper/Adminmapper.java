package com.example.mapper;

import com.example.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Adminmapper {
    @Select("select * from admin where admin = #{admin}")
    public Admin findbyadamin(String admin);

    @Select("select * from admin")
    public List<Admin> list();
}
