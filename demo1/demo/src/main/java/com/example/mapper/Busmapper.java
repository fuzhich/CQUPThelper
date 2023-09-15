package com.example.mapper;

import com.example.pojo.Bus;
import com.example.pojo.Bus1;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.TypeHandler;

import java.net.URL;
import java.util.List;

@Mapper
public interface Busmapper {
    @Select("select * from schoolbus")
    List<Bus1> list();

}