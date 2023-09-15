package com.example.vo;

import com.example.Msg.Resultcode;
import com.example.pojo.User;

public class Userresult {
    public int code;
    public String msg;
    public User result;

    public void Setresult(Resultcode resultcode, User result){
        this.code=resultcode.getCode();
        this.msg=resultcode.getMessage();
        this.result=result;
    }
}
