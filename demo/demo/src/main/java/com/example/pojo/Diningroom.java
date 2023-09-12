package com.example.pojo;

import java.util.List;

public class Diningroom {

    public String name;
    public List<Window_1> windows;

    @Override
    public String toString() {
        return "Diningroom{" +
                "name='" + name + '\'' +
                ", windows=" + windows +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Window_1> getWindows() {
        return windows;
    }

    public void setWindows(List<Window_1> windows) {
        this.windows = windows;
    }
}
