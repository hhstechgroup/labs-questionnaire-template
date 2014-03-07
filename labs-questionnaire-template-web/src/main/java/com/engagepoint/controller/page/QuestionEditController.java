package com.engagepoint.controller.page;

import com.engagepoint.controller.utils.PageNavigator;
import com.engagepoint.model.question.rules.RulesContainer;

import java.io.Serializable;
import javax.inject.Inject;

/**
 * Used as basic controller for all question controllers
 */
public abstract class QuestionEditController implements Serializable {
    private boolean isNew;
    //contains all rules
    private RulesContainer rules;
    //show add rule button
    private boolean addRuleButtonIsVsible;
    //show cancel rule edition button
    private boolean cancelRuleEditionButtonIsVisible;
    //show rules table
    private boolean addRulesTableIsVisible;

    @Inject
    private TemplateTreeController templateTreeController;

    public QuestionEditController() {
        rules = new RulesContainer();
        isNew = false;
    }

    public TemplateTreeController getTemplateTreeController() {
        return templateTreeController;
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

    public String actionSave() {
        if (isNew) {
            getTemplateTreeController().addQuestionToCurrentGroup();
        }
        return PageNavigator.TEMPLATE_EDIT_PAGE;
    }

    public String actionCancel() {
        return PageNavigator.TEMPLATE_EDIT_PAGE;
    }

    public boolean isAddRulesTableIsVisible() {
        return addRulesTableIsVisible;
    }

    public void setAddRulesTableIsVisible(boolean addRulesTableIsVisible) {
        this.addRulesTableIsVisible = addRulesTableIsVisible;
    }

    public boolean isAddRuleButtonIsVsible() {
        return addRuleButtonIsVsible;
    }

    public void setAddRuleButtonIsVsible(boolean addRuleButtonIsVsible) {
        this.addRuleButtonIsVsible = addRuleButtonIsVsible;
    }

    public boolean isCancelRuleEditionButtonIsVisible() {
        return cancelRuleEditionButtonIsVisible;
    }

    public void setCancelRuleEditionButtonIsVisible(boolean cancelRuleEditionButtonIsVisible) {
        this.cancelRuleEditionButtonIsVisible = cancelRuleEditionButtonIsVisible;
    }

    /**
     * Set elements visibility after add rule button was clicked.
     */
    public void addRuleAction() {
        setAddRuleButtonIsVsible(false);
        setCancelRuleEditionButtonIsVisible(true);
        setAddRulesTableIsVisible(true);
    }
}
