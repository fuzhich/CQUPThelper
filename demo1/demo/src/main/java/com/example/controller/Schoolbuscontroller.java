package com.example.controller;

import com.example.mapper.Busmapper;
import com.example.mapper.Noticemapper;
import com.example.pojo.Bus;
import com.example.pojo.Bus1;
import com.example.pojo.Notice;
import com.example.vo.Noticeresult;
import com.example.vo.Schoolbusresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
@RestController
@CrossOrigin
public class Schoolbuscontroller {
    @Autowired
    public Busmapper busmapper;

    @GetMapping("/schoolbus")
    public Schoolbusresult getschoolbusresult(){
        List<Bus1> buslist=busmapper.list();
        Schoolbusresult result = new Schoolbusresult();
        result.code=200;
        result.result.setData(convert(buslist));
        return result;
    }

    public static List<Bus> convert(List<Bus1> list) {

        List<Bus> result = new ArrayList<>();

        for (Bus1 bus1 : list) {
            Bus bus = new Bus();
            bus.number = bus1.number;
            try {
                bus.picUrl = new URL(bus1.picUrl);
            } catch (MalformedURLException e) {
                bus.picUrl=null;
            }
            result.add(bus);
        }

        return result;

    }

}
