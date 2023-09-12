package com.example.vo;

import com.example.pojo.Diningroom;
import com.example.pojo.Window_1;

import java.util.List;

public class Diningresult {
    public int code;
    public class Result {
        public Diningroom data;
        public List<Window_1> windows;
    }
    public Result result = new Result();
}
