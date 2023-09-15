package com.example.pojo;

public class Login {
    public String admin;
    public String password;
    public String id;

    public Login() {
    }

    public Login(String admin, String password, String id) {

        this.admin = admin;
        this.password = password;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Login{" +
                "admin='" + admin + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
