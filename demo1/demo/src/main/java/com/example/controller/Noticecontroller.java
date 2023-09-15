package com.example.controller;

import com.example.mapper.Noticemapper;
import com.example.pojo.Notice;
import com.example.vo.Noticeresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin
public class Noticecontroller {
    @Autowired
    public Noticemapper noticemapper;

    @GetMapping("/notice")
    public Noticeresult get(@RequestParam(defaultValue = "10") int limit){

        Noticeresult result = new Noticeresult();

        try {
            List<Notice> noticelist = noticemapper.list();
            result.code = 200;
            result.result.setData(noticelist);

        } catch (Exception e) {
            // 数据库访问异常
            result.code = 400;
            result.result=null;
            return result;
        }


        return result;
    }

}
