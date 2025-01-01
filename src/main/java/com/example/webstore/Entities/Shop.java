package com.example.webstore.Entities;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Shop {
    private static Shop shop;
    private ResourceBundle messages;
    private List<Customer> customers ;
    private List<Admin> admins;
    private String[] productsNameList ;
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
    public String[] getProductsNameList() {
        return productsNameList;
    }
    public void setProductsNameList(String[] productsNameList) {
        this.productsNameList = productsNameList;
    }
    private Shop() {
        customers = new ArrayList<>();
        admins = new ArrayList<>();
        messages = ResourceBundle.getBundle("messeges");
        productsNameList = new String[]{
                messages.getString("product.name.Book"),
                messages.getString("product.name.Clothing"),
                messages.getString("product.name.Dairy"),
                messages.getString("product.name.Digital"),
                messages.getString("product.name.Snack"),
        };
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
