package com.example.mapper;

import com.example.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Noticemapper {
    @Select("select * from notices limit #{limit}")
    public List<Notice> list(int limit);

}
