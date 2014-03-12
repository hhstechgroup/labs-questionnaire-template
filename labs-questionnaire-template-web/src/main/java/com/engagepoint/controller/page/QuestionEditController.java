package com.engagepoint.controller.page;

import com.engagepoint.controller.utils.PageNavigator;

import java.io.Serializable;
import javax.inject.Inject;

/**
 * Used as basic controller for all question controllers
 */
public abstract class QuestionEditController implements Serializable {
    private boolean isNew;

    @Inject
    private TemplateTreeController templateTreeController;

    public QuestionEditController() {
    }

    public TemplateTreeController getTemplateTreeController() {
        return templateTreeController;
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
}
