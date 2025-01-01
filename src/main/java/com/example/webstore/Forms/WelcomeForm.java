package com.example.webstore.Forms;

import org.apache.struts.action.ActionForm;



public class WelcomeForm extends ActionForm {
    private String method;
    private String selectedProduct = "";
    private String[] nameProducts;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(String selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public String[] getNameProducts() {
        return nameProducts;
    }

    public void setNameProducts(String[] nameProducts) {
        this.nameProducts = nameProducts;
    }
}
