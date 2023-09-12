package com.example.controller;

import com.example.mapper.Usermapper;
import com.example.pojo.User;
import com.example.vo.Userresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class Usercontroller {
    @Autowired
    private Usermapper usermapper;

    @GetMapping("/user")
    public Userresult list(int id){
        Userresult  userresult = new Userresult();
        userresult.result = usermapper.get(id);
        userresult.code=200;
        userresult.msg="right";
        return userresult;
    }

}
