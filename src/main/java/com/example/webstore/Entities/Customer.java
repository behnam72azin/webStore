package com.example.webstore.Entities;
import java.util.Objects;
public class Customer extends User{
    public Customer(String userName,String password){
        setUserName(userName);
        setPassword(password);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getUserName(), customer.getUserName()) && Objects.equals(getPassword(), customer.getPassword());
    }

    @Override
    public void login() {
        //TODO
    }

    @Override
    public void register() {
        //TODO
    }
}
