package com.engagepoint.controller.page;

import com.engagepoint.controller.utils.PageNavigator;
import com.engagepoint.model.question.rules.Rule;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
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

    @Inject
    private Conversation conversation;

    public void beginConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    public void endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    public String actionSave() {
        if (isNew) {
            getTemplateTreeController().addQuestionToCurrentGroup();
        }
        endConversation();
        return PageNavigator.TEMPLATE_EDIT_PAGE;
    }

    public String actionCancel() {
        endConversation();
        return PageNavigator.TEMPLATE_EDIT_PAGE;
    }

    public abstract void deleteRule(Rule rule);

}
