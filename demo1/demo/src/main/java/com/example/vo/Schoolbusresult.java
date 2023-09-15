package com.example.vo;

import com.example.pojo.Bus;
import com.example.pojo.Notice;

import java.util.List;

public class Schoolbusresult {
    public int code;

    public class Result{
        public List<Bus> data;

        public List<Bus> getData() {
            return data;
        }

        public void setData(List<Bus> data) {
            this.data = data;
        }
    }

    public Result result=new Result();


}
