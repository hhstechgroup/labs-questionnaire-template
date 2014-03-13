package com.engagepoint.controller.question;

import com.engagepoint.controller.page.TemplateEditController;
import com.engagepoint.controller.page.TemplateTreeController;
import com.engagepoint.model.question.DateQuestionBean;
import com.engagepoint.controller.page.QuestionEditController;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.rules.Rule;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by anton.kovunov on 2/25/14.
 */
@Named("dateQuestion")
@ConversationScoped
public class DateController extends QuestionEditController {
    @Inject
    TemplateEditController templateEditController;
    private DateQuestionBean currentQuestion;

    @PostConstruct
    public void postConstruct() {
        beginConversation();
        Question question = getTemplateTreeController().getCurrentQuestion();
        if (question ==null) {
            setNew(true);
            currentQuestion = new DateQuestionBean(getTemplateTreeController().getCurrentGroup());
            currentQuestion.setQuestionType(templateEditController.getSelectedQuestionType());
        }
        else {
            currentQuestion = (DateQuestionBean) question;
        }
        currentQuestionEventNew.fire(currentQuestion);
    }

    public DateQuestionBean getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(DateQuestionBean currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    @Override
    public String actionSave() {
        getTemplateTreeController().setCurrentQuestion(currentQuestion);
        return super.actionSave();
    }
}
