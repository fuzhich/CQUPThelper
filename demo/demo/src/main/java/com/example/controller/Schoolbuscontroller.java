package com.example.controller;

import com.example.mapper.Busmapper;
import com.example.mapper.Noticemapper;
import com.example.pojo.Bus;
import com.example.pojo.Notice;
import com.example.vo.Noticeresult;
import com.example.vo.Schoolbusresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin(origins="http://localhost:8081", allowCredentials = "true", allowedHeaders = "*")

public class Schoolbuscontroller {
    @Autowired
    public Busmapper busmapper;

    @GetMapping("/schoolbus")
    public Schoolbusresult getschoolbusresult(){
        List<Bus> buslist=busmapper.list();
        Schoolbusresult result = new Schoolbusresult();
        result.code=200;
        result.result.setData(buslist);
        return result;
    }

}
