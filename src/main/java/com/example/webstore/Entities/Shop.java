package com.example.webstore.Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class Shop {
    private static Shop shop;
    private ResourceBundle messages;
    //private Customer[] customers;
    private int customerCount;

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
        customerCount = 0;
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
    public Customer[] getAllCustomers() {
        Customer[] result = new Customer[customerCount];
        System.arraycopy(customers, 0, result, 0, customerCount);
        return result;
    }

    public ResourceBundle getMesseges(){
        return messages;
    }
    public int addNewCustomer(String username, String password) {
//        if(customerCount<customers.length){
//            for(int i=0; i<customers.length; i++){
//                if(customers[i]!=null) {
//                    if (username.equals(customers[i].getUserName())) {
//                        return 1;
//                    }
//                }else {
//                    customers[customerCount] = new Customer(username, password);
//                    customerCount++;
//                    return 0;
//                }
//            }
//        }
        return -1;
    }




}
