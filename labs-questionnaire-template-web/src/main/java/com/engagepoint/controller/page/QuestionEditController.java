package com.engagepoint.controller.page;

import com.engagepoint.controller.utils.PageNavigator;
import com.engagepoint.model.question.rules.RulesContainer;

import java.io.Serializable;

import javax.inject.Inject;

/**
 * Used as basic controller for all question controllers
 */
public abstract class QuestionEditController implements Serializable {

    boolean isNew = false;
    private RulesContainer rules;

    public QuestionEditController() {
        rules = new RulesContainer();
    }

    public RulesContainer getRules() {
        return rules;
    }

    public void setRules(RulesContainer rules) {
        this.rules = rules;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    @Inject
    private TemplateTreeController templateTreeController;

    public TemplateTreeController getTemplateTreeController() {
        return templateTreeController;
    }

    public String actionSave() {
        if (isNew) {
            getTemplateTreeController().addQuestionToCurrentGroup();
        }
        return PageNavigator.TEMPLATE_EDIT_PAGE;
    }

    ;

    public String actionCancel() {
        return PageNavigator.TEMPLATE_EDIT_PAGE;
    }

    ;
}
