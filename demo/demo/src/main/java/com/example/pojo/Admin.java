package com.example.pojo;

public class Admin {

    public String userId;
    public String userName;
    public String admin;
    public String password;

    @Override
    public String toString() {
        return "Admin{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", admin='" + admin + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

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

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
