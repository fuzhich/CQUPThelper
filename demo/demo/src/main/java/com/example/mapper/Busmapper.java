package com.example.mapper;

import com.example.pojo.Bus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface Busmapper {
    @Select("select * from schoolbus")
    List<Bus> list();
}
