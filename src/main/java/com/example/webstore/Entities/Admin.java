package com.example.webstore.Entities;

import com.example.webstore.Exceptions.LoginWrongException;

public class Admin extends User{
    public Admin(String userName,String passWord) {
        super.setUserName(userName);
        super.setPassWord(passWord);
    }

    @Override
    public void login() throws LoginWrongException {
        if (!adminIsthere()) {
            throw new LoginWrongException();
        }
    }

    @Override
    public int register() {
       if(!adminIsthere()){
           Shop.getShop().getAdmins().add(this);
           return 1;
       }else{
           return 0;
       }
    }

    private boolean adminIsthere() {
        return Shop.getShop().getAdmins().contains(this);
    }

}
