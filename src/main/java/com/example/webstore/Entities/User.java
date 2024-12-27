package com.example.webstore.Entities;

public abstract class User {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void login();
    public abstract void register();

}
