package com.engagepoint.controller.page;

import com.engagepoint.controller.utils.PageNavigator;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Used as basic controller for all question controllers
 */

@Named("questionController")
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

    public TemplateTreeController getTemplateTreeController() {
        return templateTreeController;
    }

    public String actionSave() {
        if (isNew) {
            getTemplateTreeController().addQuestionToCurrentGroup();
        }
        endConversation();
        return PageNavigator.TEMPLATE_EDIT_PAGE;
    };

    public String actionCancel() {
        endConversation();
        return PageNavigator.TEMPLATE_EDIT_PAGE;
    };
}
