package com.example.controller;

import com.example.mapper.Windowmapper;
import com.example.pojo.Dish;
import com.example.pojo.Dishdata;
import com.example.vo.Windowsresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class Windowcontroller {
    @Autowired
    private Windowmapper windowmapper;

    @GetMapping("/window")
    public Windowsresult get(int id){
        Windowsresult windowsresult = new Windowsresult();
        List<Dishdata> dishdatalist  = windowmapper.list(id);
        List<Dish>  dishlist = new ArrayList<Dish>();
        windowsresult.result.data.name = windowmapper.find(id).windowname;
        dishdatalist.stream().forEach(dishdata->{
            Dish dish = new Dish();
            dish.name=dishdata.name;
            dish.pricce=dishdata.price;
            dishlist.add(dish);
        });
        System.out.println("here1");
        windowsresult.result.data.dishes=dishlist;
        windowsresult.code=200;
        return windowsresult;
    }

}
