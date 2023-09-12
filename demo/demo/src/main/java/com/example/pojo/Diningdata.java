package com.example.pojo;

import java.net.URL;

public class Diningdata {
    public int id;
    public String diningname;
    public String windowname;
    public URL picUrl;
    public Diningdata() {
    }

    @Override
    public String toString() {
        return "Diningdata{" +
                "id=" + id +
                ", diningname='" + diningname + '\'' +
                ", windowname='" + windowname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiningname() {
        return diningname;
    }

    public void setDiningname(String diningname) {
        this.diningname = diningname;
    }

    public String getWindowname() {
        return windowname;
    }

    public void setWindowname(String windowname) {
        this.windowname = windowname;
    }
}
