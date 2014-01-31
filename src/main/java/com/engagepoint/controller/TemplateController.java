package com.engagepoint.controller;

import com.engagepoint.bean.TemplateBean;
import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;


/**
 * Created with IntelliJ IDEA.
 * User: anna.zagrebelnaya
 * Date: 1/31/14
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name="templateController")
@SessionScoped
public class TemplateController {

    private SessionController sessionController;
    private TemplateBean currentTemplate;

    public SessionController getSessionController() {
        return sessionController;
    }

    public void setSessionController(SessionController sessionController) {
        this.sessionController = sessionController;
    }

    public TemplateBean getCurrentTemplate() {
        return currentTemplate;
    }

    public void setCurrentTemplate(TemplateBean currentTemplate) {
        this.currentTemplate = currentTemplate;
    }

    public String income() {
        return "/template?faces-redirect=true";
    }

    public String saveTemplate() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();

            UIInput nameComponent = (UIInput) context.getViewRoot().findComponent("formTemplate:name");
            String name = (String) nameComponent.getSubmittedValue();

            currentTemplate.setTemplateName(name);

            sessionController.sort();

            return sessionController.income();
        }
        catch(Exception e)
        {
            return "error";
        }
    }
}
