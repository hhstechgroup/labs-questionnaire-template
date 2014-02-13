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

    public void setCurrentTemplateId(Long currentTemplateId) {
        this.currentTemplateId = currentTemplateId;
        if (!isNew())
        {
            setCurrentTemplate(listController.getTemplatesModel().getRowData(currentTemplateId.toString()));
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
        currentTemplateId = newTemplate.getId();
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
