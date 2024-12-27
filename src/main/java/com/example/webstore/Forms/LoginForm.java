package com.example.webstore.Forms;
import org.apache.struts.action.ActionForm;


public class LoginForm extends ActionForm {


    private String userName;
    private String passWord;
    private String method;

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

    public void reset() {
        setUserName("");
        setPassWord("");
        setMethod("");
    }
}
