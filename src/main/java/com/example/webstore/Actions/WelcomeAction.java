package com.example.webstore.Actions;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeAction extends DispatchAction {
    @Override
    protected ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ActionErrors actionErrors = (ActionErrors) request.getSession().getAttribute("actionErrors");
        if (actionErrors != null) {
            saveErrors(request, actionErrors);
            request.getSession().removeAttribute("actionErrors");
        }
        return mapping.findForward("go-welcome");
    }
}
