package com.example.controller;

import com.example.mapper.Adminmapper;
import com.example.mapper.Loginmapper;
import com.example.pojo.Admin;
import com.example.pojo.Login;
import com.example.vo.Loginresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins="http://localhost:8081", allowCredentials = "true", allowedHeaders = "*")

public class Admincontroller {

    @Autowired
    private Adminmapper adminmapper;

    @PostMapping("/login")
    public Loginresult login(@RequestBody Login login){
      System.out.println(login);
        Loginresult result = new Loginresult();
        List<Admin> adminlist = adminmapper.list();
        adminlist.stream().forEach(admin_o->{
            if (match(login,admin_o)){
                result.code=200;
                result.msg="Right!";
                System.out.println(adminmapper.findbyadamin(admin_o.admin).userId);
                System.out.println("here i am");
                result.result.setUserId(adminmapper.findbyadamin(admin_o.admin).userId);
                result.result.setUserName(adminmapper.findbyadamin(admin_o.admin).userName);
            }
        });
        System.out.println(login);
        return result;
    }

    public boolean match(Login stand,Admin sample){
        if(stand.admin.equals(sample.admin)&&stand.password.equals(sample.password)){
            return true;
        }else{
            return false;
        }

    }
}
