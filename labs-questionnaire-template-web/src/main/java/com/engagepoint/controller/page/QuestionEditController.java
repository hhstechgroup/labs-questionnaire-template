package com.engagepoint.controller.page;

import com.engagepoint.controller.utils.PageNavigator;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Used as basic controller for all question controllers
 */

public abstract class QuestionEditController implements Serializable {

   
    boolean isNew=false;

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
    };

    public String actionCancel() {
        return PageNavigator.TEMPLATE_EDIT_PAGE;
    };
}
