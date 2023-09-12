package com.example.mapper;

import com.example.pojo.Diningdata;
import com.example.pojo.Diningroom;
import com.example.pojo.Window_1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Diningmapper {
    @Select("select * from dining where diningid = #{id} limit 1")
    public Diningdata findname(int id);

    @Select("select * from dining where diningname = #{diningname1}")
    public List<Diningdata> findwindows(String diningname1);
}
