package com.example.controller;

import com.example.mapper.Noticemapper;
import com.example.pojo.Notice;
import com.example.vo.Noticeresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:8081", allowCredentials = "true", allowedHeaders = "*")

@RequestMapping
public class Noticecontroller {
    @Autowired
    public Noticemapper noticemapper;

    @GetMapping("/notice")
    public Noticeresult get(@RequestParam(defaultValue = "10") int limit){
        System.out.println(limit);
        List<Notice> noticelist=noticemapper.list(limit);
        Noticeresult result = new Noticeresult();
        result.code=200;
        result.result.setData(noticelist);
        return result;
    }

}
