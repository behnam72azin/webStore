package com.example.webstore.Forms;

import com.example.webstore.Entities.Shop;
import org.apache.struts.action.ActionForm;

public class RegisterForm extends ActionForm {

    Shop shop = Shop.getShop();
    private String userName = null;
    private String passWord = null;
    private String role = "customer";
    private Boolean addCustomer = null;
    private Boolean noSpace = null;
    private String method = null;
    private String messege = null;

    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public boolean isAddCustomer() {
        return addCustomer;
    }
    public void setAddCustomer(boolean addCustomer) {
        this.addCustomer = addCustomer;
    }
    public boolean getNoSpace() {
        return noSpace;
    }
    public void setNoSpace(boolean noSpace) {
        this.noSpace = noSpace;
    }
    public String getMessege() {
        return messege;
    }
    public void setMessege(String messege) {
        this.messege = messege;
    }

    public void reset() {
        setUserName("");
        setPassWord("");
        setAddCustomer(true);
        setNoSpace(false);
        setMethod("");
        setMessege(shop.getMesseges().getString("register.addCustomer.success"));
    }
}
