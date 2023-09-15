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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping
@CrossOrigin
public class Diningcontroller {
    @Autowired
    public Diningmapper diningmapper;

    @GetMapping("/dining")
    public Diningresult get(int id){
        Diningresult result = new Diningresult();
        Diningroom  dining =new Diningroom();
        if(diningmapper.findname(id)==null)
        {
            result.code=404;
            result.result=null;
            return result;
        }
        else
        {
            dining.name=diningmapper.findname(id).diningname;
            List<Diningdata> datalist = diningmapper.findwindows(dining.name);
            List<Window_1> windows = new ArrayList<Window_1>();
            datalist.stream().forEach(data -> {
                Window_1 window = new Window_1();
                window.id = data.id;
                window.name = data.windowname;
                try {
                    window.picUrl = new URL(data.picUrl);
                } catch (MalformedURLException e) {
                    window.picUrl=null;
                }
                windows.add(window);
            });
            result.code = 200;
            dining.windows = windows;
            result.result.data = dining;
            return result;
        }
    }
}
