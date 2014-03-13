package com.engagepoint.controller.page;

import com.engagepoint.controller.utils.PageNavigator;
import com.engagepoint.controller.utils.qualifiers.NewQuestion;
import com.engagepoint.controller.utils.qualifiers.SaveQuestion;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.rules.Rule;

import java.io.Serializable;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Used as basic controller for all question controllers
 */
public abstract class QuestionEditController implements Serializable {
    private boolean isNew;

    @Inject
    private TemplateTreeController templateTreeController;

    @Inject
    @NewQuestion
    protected Event<Question> currentQuestionEventNew;

    @Inject
    @SaveQuestion
    protected Event<Question> currentQuestionEventSave;

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
        currentQuestionEventSave.fire(getTemplateTreeController().getCurrentQuestion());
        return PageNavigator.TEMPLATE_EDIT_PAGE;
    }

    public String actionCancel() {
        return PageNavigator.TEMPLATE_EDIT_PAGE;
    }
}
