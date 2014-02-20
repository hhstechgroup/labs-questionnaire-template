package com.engagepoint.controller.pagecontroller;

import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;
import com.engagepoint.controller.QuestFormTreeController;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;

/**
 * Used for controlling questform.xhtml
 */

@Named("templateController")
@SessionScoped
public class QuestFormController implements Serializable {

    @Inject
    private ListController listController;
    @Inject
    private QuestFormTreeController questFormTreeController;

    private TemplateBean currentTemplate;
    private String templateName;
    private Long currentTemplateId;
    private int pageNumber;

    private TemplateBean duplicateTemplate;

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
        if (!isNew())
        {
            setCurrentTemplate(listController.getTemplatesModel().getRowData(currentTemplateId.toString()));
        }
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

    public TemplateBean getCurrentTemplate() {
        return currentTemplate;
    }

    public void setCurrentTemplate(TemplateBean currentTemplate) {
        this.currentTemplate = currentTemplate;
        questFormTreeController.setTemplateBean(currentTemplate);
        try {
            duplicateTemplate = currentTemplate.duplicate();
        } catch (CloneNotSupportedException e) {
            //NOP
        }
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



    /**
     * duplicateTemplate - is old template before editing( same ID, etc).
     * But the address in memory is differ(two instance that match each other via equals).
     * So, in case, if this is existing template, there is need to delete edited templateBean
     * in ListControler, in order not to have them both, ot other kind of ambiguity.
     * And if this is new, not yet saved template, just skip saving.
     *
     * @return index page
     */
    public String cancel() {
        boolean isNew = isNew();
        listController.deleteTemplate(currentTemplate);
        if (!isNew) {
            setCurrentTemplate(duplicateTemplate);
            setTemplateName(duplicateTemplate.getTemplateName());
            saveTemplate();
        }
        return ListController.income();
    }

}
