package com.example.webstore.Actions;

import com.example.webstore.Entities.Shop;
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

        int status = -2;
        status = shop.addNewCustomer(username,password);
        if(status==1) {
            registerForm.setAddCustomer(false);
            registerForm.setMessege(shop.getMesseges().getString("register.addCustomer.fail"));
        }
        if(status==0) {
//            registerForm.setAddCustomer(true);
            registerForm.reset();

        }
        if(status==-1) {
            registerForm.setNoSpace(true);
            registerForm.setMessege(shop.getMesseges().getString("register.addCustomer.noSpace"));
        }

        return mapping.findForward("go-register");
    }
}
