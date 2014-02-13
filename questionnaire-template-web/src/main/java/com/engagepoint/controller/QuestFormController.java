package com.engagepoint.controller;

import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;



@Named("templateController")
@SessionScoped
public class QuestFormController implements Serializable {

    private ListController listController;
    private QuestFormTreeController questFormTreeController;
    private TemplateBean currentTemplate;
    private String templateName;
    private Long currentTemplateId;

    public Long getCurrentTemplateId() {
        return currentTemplateId;
    }

    /**
     * Setting id happens when enter a page.
     * If this is existing template, we have to set up current
     * template and name.
     * If this is new template, these actions are done in
     * newTemplate() method.
     *
     * @return index page
     */
    public void setCurrentTemplateId(Long currentTemplateId) {
        this.currentTemplateId = currentTemplateId;
        TemplateBean templateBean = listController.getTemplatesModel().getRowData(currentTemplateId.toString());
        if (templateBean!=null)
        {
            setCurrentTemplate(templateBean);
            setTemplateName(templateBean.getTemplateName());
        }
    }

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

    public QuestFormTreeController getQuestFormTreeController() {
        return questFormTreeController;
    }

    public void setQuestFormTreeController(QuestFormTreeController questFormTreeController) {
        this.questFormTreeController = questFormTreeController;
    }

    public TemplateBean getCurrentTemplate() {
        return currentTemplate;
    }

    public void setCurrentTemplate(TemplateBean currentTemplate) {
        this.currentTemplate = currentTemplate;
    }

    /**
     * Check if the template already exists (searching by id, because equals-method is by id).
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
        if (isNew()) {
            listController.addTemplateAndUpdateLists(currentTemplate);
        }else
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
        TemplateBean newTemplate = new TemplateBean();
        setCurrentTemplate(newTemplate);
        setCurrentTemplateId(newTemplate.getId());
        setTemplateName(newTemplate.getTemplateName());
        questFormTreeController.setTemplateBean(newTemplate);
        return income();
    }

    /**
     * Get page name and perform redirect.
     *
     * @return page name
     */
    public String income() {
    return "pages/questForm?faces-redirect=true&includeViewParams=true";
    }

    public void addSection() {
        SectionBean sectionBean = new SectionBean();
        sectionBean.setPageNumber(currentTemplate.getSectionsList().size()+1);
        currentTemplate.getSectionsList().add(sectionBean);
        questFormTreeController.setNodes();
    }

}
