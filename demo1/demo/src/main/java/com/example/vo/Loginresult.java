package com.example.vo;

import com.example.Msg.Resultcode;

public class Loginresult {
    public int code;
    public String msg;
    public class Result{
        public String userId;
        public String userName;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
    public Result result = new Result();

    public void Setresult(Resultcode resultcode,Result result){
        this.code=resultcode.getCode();
        this.msg=resultcode.getMessage();
        this.result=result;
    }
}
