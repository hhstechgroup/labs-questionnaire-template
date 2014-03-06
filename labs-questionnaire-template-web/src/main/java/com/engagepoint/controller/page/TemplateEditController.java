package com.engagepoint.controller.page;

import com.engagepoint.controller.utils.PageNavigator;
import com.engagepoint.model.questionnaire.QuestionType;
import com.engagepoint.model.questionnaire.TemplateBean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;

/**
 * Used for controlling questform.xhtml
 */

@Named("templateController")
@SessionScoped
public class TemplateEditController implements Serializable {

    @Inject
    private ListController listController;
    @Inject
    private TemplateTreeController templateTreeController;

    private TemplateBean currentTemplate; //real template
    private TemplateBean duplicateTemplate; //copy of real template, contains all unsaved changes

    private QuestionType selectedQuestionType;

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
            templateTreeController.setTemplateBean(duplicateTemplate);
        } catch (CloneNotSupportedException e) {
            //NOP
        }
    }

    public QuestionType getSelectedQuestionType() {
        return selectedQuestionType;
    }

    public void setSelectedQuestionType(QuestionType selectedQuestionType) {
        this.selectedQuestionType = selectedQuestionType;
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

    public QuestionType[] getQuestionTypes() {
        return QuestionType.values();
    }

    /**
     * Returns page of current question in dependent
     * of selected question type
     *
     * @return path to page
     */
    public String getPageForSelectedQuestionType() {
        String stab = PageNavigator.STAB_PAGE;
        if (selectedQuestionType == null) return PageNavigator.NOT_CHOOSE_QUESTION_PAGE;
        switch (selectedQuestionType) {
            case TEXT:
                return PageNavigator.TEXT_QUESTION_PAGE;
            case DATE:
                return PageNavigator.DATE_QUESTION_PAGE;
            case RANGE:
                return PageNavigator.RANGE_QUESTION_PAGE;
            case TIME:
                return PageNavigator.TIME_QUESTION_PAGE;
            case PARAGRAPHTEXT:
                return PageNavigator.PARAGRAPH_TEXT_QUESTION_PAGE;
            case CHOOSEFROMLIST:
                return PageNavigator.CHOOSE_FROM_LIST_QUESTION_PAGE;
            case FILEUPLOAD:
                return PageNavigator.FILE_UPLOAD_QUESTION_PAGE;
            case MULTIPLECHOICE:
                return PageNavigator.CHOOSE_FROM_LIST_QUESTION_PAGE;
            case CHECKBOX:
                return PageNavigator.CHECKBOX_QUESTION_PAGE;
            case GRID:
                return PageNavigator.GRID_QUESTION_PAGE;
        }

        return stab;
    }

    /**
     * Redirect to page of concrete question where new Question
     * will be created and edited
     */
    public String addQuestion() {
        templateTreeController.setCurrentQuestion(null);
        return getPageForSelectedQuestionType();
    }

    /**
     * Redirect to page of concrete question where new Question
     * will be edited
     */
    public String editQuestion() {
        setSelectedQuestionType(templateTreeController.getCurrentQuestion().getQuestionType());
        return getPageForSelectedQuestionType();
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
        } else {
            listController.removeTemplateFromFilteredListIfNeed(currentTemplate);
            listController.sort();
        }
        return ListController.income();
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
    public static String income() {
        return PageNavigator.TEMPLATE_EDIT_PAGE;
    }

}
