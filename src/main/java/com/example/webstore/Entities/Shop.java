package com.example.webstore.Entities;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Shop {
    private static Shop shop;
    private ResourceBundle messages;
    private List<Customer> customers ;
    private List<Admin> admins;
    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    public List<Admin> getAdmins() {
        return admins;
    }
    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }
    private Shop() {
        customers = new ArrayList<>();
        admins = new ArrayList<>();
        messages = ResourceBundle.getBundle("messeges");
    }
    public static Shop getShop() {
        if(shop==null) {
            synchronized (Shop.class) {
                if (shop == null)
                    shop = new Shop();

            }
        }
        return shop;
    }
    public ResourceBundle getMesseges(){
        return messages;
    }
}
