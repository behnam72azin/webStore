package com.example.webstore.Entities;

import com.example.webstore.Exceptions.LoginWrongException;

public class Customer extends User{
    public Customer(String userName,String password){
        super.setUserName(userName);
        super.setPassWord(password);
    }

    @Override
    public void login() throws LoginWrongException {
        if(!customerIsthere()){
            throw new LoginWrongException();
        }
    }

    @Override
    public int register() {
        if(!customerIsthere()){
            Shop.getShop().getCustomers().add(this);
            return 1;
        }else{
            return 0;
        }
    }

    private boolean customerIsthere() {
        return Shop.getShop().getCustomers().contains(this);
    }
}
