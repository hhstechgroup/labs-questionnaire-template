package com.engagepoint.controller;

import com.engagepoint.bean.TemplateBean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;



@Named("templateController")
@SessionScoped
public class QuestFormController implements Serializable {

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

    /**
     * Check if the template already exists.
     *
     * @return true - this template already exists.
     */
    public boolean isNew() {
        return (!listController.getTemplates().contains(currentTemplate));
    }

    /**
     * Save template.
     *
     * @return next page name.
     */
    public String saveTemplate() {
        currentTemplate.setTemplateName(templateName);
        if (isNew())
            listController.addTemplateAndUpdateLists(currentTemplate);
        else
        {
            listController.removeTemplateFromFilteredList(currentTemplate);
            listController.sort();
        }
        return listController.income();
    }


    /**
     * Create new template.
     *
     * @return next page name
     */
    public String newTemplate() {
        setCurrentTemplate(new TemplateBean());
        return income();
    }

    /**
     * Get page name and perform redirect.
     *
     * @return page name
     */
    public String income() {
        return "pages/questForm?faces-redirect=true";
    }
}
