package com.engagepoint.controller;

import com.engagepoint.bean.TemplateBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA.
 * User: anna.zagrebelnaya
 * Date: 1/31/14
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name="templateController")
@SessionScoped
public class TemplateController implements Serializable {

    private ListController listController;
    private TemplateBean currentTemplate;
    private String templateName;

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public ListController getListController() {
        return listController;
    }

    public void setListController(ListController listController) {
        this.listController = listController;
    }

    public TemplateBean getCurrentTemplate() {
        return currentTemplate;
    }

    public void setCurrentTemplate(TemplateBean currentTemplate) {
        this.currentTemplate = currentTemplate;
        this.templateName = currentTemplate.getTemplateName();
    }

    public boolean isNew() {
        return (!listController.getTemplates().contains(currentTemplate));
    }

    public String saveTemplate() {
        try {
            currentTemplate.setTemplateName(templateName);

            if (isNew())
                listController.addTemplate(currentTemplate);
            else
                listController.sort();

            return listController.income();
        }
        catch(Exception e)
        {
            return "error";
        }
    }

    public String newTemplate() {
        setCurrentTemplate(new TemplateBean());
        return income();
    }

    public String income() {
        return "pages/template?faces-redirect=true";
    }

}
