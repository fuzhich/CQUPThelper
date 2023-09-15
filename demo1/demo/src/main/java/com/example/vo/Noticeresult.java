package com.example.vo;

import com.example.pojo.Notice;

import java.util.Date;
import java.util.List;

public class Noticeresult {
    public int code;
    public class Result{
        public List<Notice> data;

        public List<Notice> getData() {
            return data;
        }

        public void setData(List<Notice> data) {
            this.data = data;
        }
    }
    public Result result = new Result();

    public Noticeresult(int code, Result result) {
        this.code = code;
        this.result = result;
    }

    public Noticeresult() {
    }
}
