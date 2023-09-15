package com.example.controller;

import com.example.Msg.Resultcode;
import com.example.mapper.Adminmapper;
import com.example.pojo.Admin;
import com.example.pojo.Login;
import com.example.vo.Loginresult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController()
@CrossOrigin
public class Admincontroller {

    @Autowired
    private Adminmapper adminmapper;

    @PostMapping("/login")
    public Loginresult login(@RequestBody Login login){
        Loginresult result = new Loginresult();
        List<Admin> adminlist = adminmapper.list();
        AtomicReference<Boolean> adminexist= new AtomicReference<>(Boolean.FALSE);
        adminlist.stream().forEach(admin_o->{
            if(matchexist(login,admin_o)) {
                adminexist.set(true);
                if (match(login, admin_o)) {
                    result.code = 200;
                    result.msg = "登录成功";
                    System.out.println(adminmapper.findbyadamin(admin_o.admin).userId);
                    System.out.println("here i am");
                    result.result.setUserId(adminmapper.findbyadamin(admin_o.admin).userId);
                    result.result.setUserName(adminmapper.findbyadamin(admin_o.admin).userName);
                }
            }
        });
        if(adminexist.get() ==false){
                result.Setresult(Resultcode.USER_NOT_EXIST,null);
        } else if (result.code!=200) {
            result.Setresult(Resultcode.PASSWORD_ERROR,null);
        }
        return result;
    }

    public boolean match(Login stand,Admin sample){
        if(stand.password.equals(sample.password)){
            return true;
        }else{
            return false;
        }

    }

    public boolean matchexist(Login stand,Admin sample){
        if(stand.admin.equals(sample.admin)){
            return true;
        }else{
            return false;
        }

    }
}
