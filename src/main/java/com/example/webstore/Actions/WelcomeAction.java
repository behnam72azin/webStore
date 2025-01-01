package com.example.webstore.Actions;

import com.example.webstore.Entities.Shop;
import com.example.webstore.Forms.WelcomeForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeAction extends DispatchAction {
    @Override
    public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

        WelcomeForm welcomeForm = (WelcomeForm) form;
        welcomeForm.setNameProducts(Shop.getShop().getProductsNameList());
        welcomeForm.setSelectedProduct("");

        ActionErrors actionErrors = (ActionErrors) request.getSession().getAttribute("actionErrors");
        if (actionErrors != null) {
            saveErrors(request, actionErrors);
            request.getSession().removeAttribute("actionErrors");
        }
        return mapping.findForward("go-welcome");
    }

    public ActionForward selectedProduct (ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        WelcomeForm welcomeForm = (WelcomeForm) form;
        return mapping.findForward("selected-product");
    }

}
