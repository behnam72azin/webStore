package com.example.webstore.Actions;
import com.example.webstore.Entities.Admin;
import com.example.webstore.Entities.Customer;
import com.example.webstore.Entities.User;
import com.example.webstore.Exceptions.LoginWrongException;
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
        String role ="customer";
        userName = loginForm.getUserName();
        passWord = loginForm.getPassWord();
        role = loginForm.getRole();
        try {
                isValid(userName,passWord,role);
                request.getSession().setAttribute("username", userName);
                request.getSession().setAttribute("role" , role);
                loginForm.reset();
                ActionErrors actionErrors = new ActionErrors();
                actionErrors.add("test.error",new ActionError("test.error"));
                request.getSession().setAttribute("actionErrors",actionErrors);
                return mapping.findForward("go-welcome");
        }catch (LoginWrongException ex){
            request.setAttribute("noCustomer","true");
        }
        return mapping.findForward("go-login");
    }

    private void isValid (String userName, String passWord, String role) throws LoginWrongException {
        if ("customer".equalsIgnoreCase(role)) {
            User customer = new Customer(userName, passWord);
            customer.login();
        } else if ("admin".equalsIgnoreCase(role)) {
            User admin = new Admin(userName, passWord);
            admin.login();
        }
    }
}