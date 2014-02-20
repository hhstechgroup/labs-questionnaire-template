package com.engagepoint.controller.pagecontroller;

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

    private TemplateBean currentTemplate; //real template
    private TemplateBean duplicateTemplate; //copy of real template, contains all unsaved changes

    public TemplateBean getDuplicateTemplate() {
        return duplicateTemplate;
    }

    public void setDuplicateTemplate(TemplateBean duplicateTemplate) {
        this.duplicateTemplate = duplicateTemplate;
    }

    public TemplateBean getCurrentTemplate() {
        return currentTemplate;
    }

    public void setCurrentTemplate(TemplateBean currentTemplate) {
        this.currentTemplate = currentTemplate;
        try {
            duplicateTemplate = currentTemplate.duplicate();
            questFormTreeController.setTemplateBean(duplicateTemplate);
        } catch (CloneNotSupportedException e) {
            //NOP
        }
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
     * Check if the template already exists
     * (searching by id, because equals-method is by id).
     *
     * @return true - this template already exists.
     */
    public boolean isNew() {
        return (!listController.getTemplates().contains(currentTemplate));
    }

    /**
     * Save template.
     * If it is new, it needs to be added to list.
     * If not - maybe it needs to be removed from filtered list.
     *
     * @return next page name.
     */
    public String saveTemplate() {
        currentTemplate.setTemplateName(duplicateTemplate.getTemplateName());
        currentTemplate.setSectionsList(duplicateTemplate.getSectionsList());
        if (isNew()) {
            listController.addTemplateAndUpdateLists(currentTemplate);
        }else
        {
            listController.removeTemplateFromFilteredListIfNeed(currentTemplate);
            listController.sort();
        }
        return listController.income();
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
        return ListController.income();
    }

    /**
     * Get page name and perform redirect.
     *
     * @return page name
     */
    public String income() {
        return "pages/questForm?faces-redirect=true&includeViewParams=true";
    }

}
