package com.example.controller;

import com.example.mapper.Noticemapper;
import com.example.pojo.Notice;
import com.example.vo.Noticeresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class Noticecontroller {
    @Autowired
    public Noticemapper noticemapper;

    @GetMapping("/notice")
    public Noticeresult get(@RequestParam(defaultValue = "10") int limit){
        List<Notice> noticelist=noticemapper.list();
        Noticeresult result = new Noticeresult();
        result.code=200;
        result.result.setData(noticelist);
        return result;
    }

}
