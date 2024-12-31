package com.example.webstore.Actions;

import com.example.webstore.Entities.Admin;
import com.example.webstore.Entities.Customer;
import com.example.webstore.Entities.Shop;
import com.example.webstore.Entities.User;
import com.example.webstore.Forms.RegisterForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterAction extends DispatchAction {

    Shop shop = Shop.getShop();

    public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward("go-register");
    }

    public ActionForward registerClient(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        RegisterForm registerForm = (RegisterForm) form;
        String username = registerForm.getUserName();
        String password = registerForm.getPassWord();
        String role = registerForm.getRole();

        int status = -1;
        if("admin".equalsIgnoreCase(role)){

            User admin = new Admin(username,password);
            status = admin.register();
            setStatus(status,registerForm);

        } else if ("customer".equalsIgnoreCase(role)) {

            User customer = new Customer(username,password);
            status = customer.register();
            setStatus(status,registerForm);
        }

        return mapping.findForward("go-register");
    }

    private void setStatus(int status, RegisterForm registerForm) {
        if (status == 0) {
            registerForm.setMessege(shop.getMesseges().getString("register.addCustomer.fail"));
        } else if (status == 1) {
            registerForm.reset();
        }
    }
}


