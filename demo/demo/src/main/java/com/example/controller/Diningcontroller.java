package com.example.controller;

import com.example.mapper.Diningmapper;
import com.example.pojo.Diningdata;
import com.example.pojo.Diningroom;
import com.example.pojo.Window_1;
import com.example.vo.Diningresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins="http://localhost:8081", allowCredentials = "true", allowedHeaders = "*")

@RequestMapping
public class Diningcontroller {
    @Autowired
    public Diningmapper diningmapper;

    @GetMapping("/dining")
    public Diningresult get(int id){
        Diningresult result = new Diningresult();
        Diningroom  dining =new Diningroom();
        dining.name =   diningmapper.findname(id).diningname;
        List<Diningdata> datalist = diningmapper.findwindows(dining.name);
        List<Window_1>  windows = new ArrayList<Window_1>();
        datalist.stream().forEach(data->{
            Window_1 window = new Window_1();
            window.id=data.id;
            window.name=data.windowname;
            window.picUrl = data.picUrl;
            windows.add(window);
        });
        result.code=200;
        dining.windows = windows;
        result.result.data=dining;
        return result;
    }
}
