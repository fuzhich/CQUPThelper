package com.example.mapper;

import com.example.pojo.Diningdata;
import com.example.pojo.Dishdata;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Windowmapper {

    @Select("select * from dishes where windowid= #{id}")
    public List<Dishdata> list(int id);
    @Select("select * from dining where id = #{id}")
    public Diningdata find(int id);
}
