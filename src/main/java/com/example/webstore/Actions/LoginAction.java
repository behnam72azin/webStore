package com.example.webstore.Actions;

import com.example.webstore.Entities.Customer;
import com.example.webstore.Entities.Shop;
import com.example.webstore.Forms.LoginForm;
import org.apache.struts.action.*;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginAction extends DispatchAction {

    public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("noCustomer","false");
        return mapping.findForward("go-login");
    }

    public ActionForward loginClient(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        LoginForm loginForm =(LoginForm) form;
        String userName =null;
        String passWord =null;
        userName = loginForm.getUserName();
        passWord = loginForm.getPassWord();

        if(isValid(userName,passWord)){
            request.getSession().setAttribute("username", userName);
            loginForm.reset();
            ActionErrors actionErrors = new ActionErrors();
            actionErrors.add("test.error",new ActionError("test.error"));
            request.getSession().setAttribute("actionErrors",actionErrors);
//            saveErrors(request,actionErrors);
            return mapping.findForward("go-welcome");
        }else {
            request.setAttribute("noCustomer","true");
            return mapping.findForward("go-login");
        }
    }
    private boolean isValid(String userName, String passWord) {
        Customer[] customers = Shop.getShop().getAllCustomers();
        Customer customer = new Customer(userName,passWord);
        for(Customer cu : customers){
                if(cu!=null && cu.equals(customer)){
                    return true;
                }
        }
        return false;
    }
}