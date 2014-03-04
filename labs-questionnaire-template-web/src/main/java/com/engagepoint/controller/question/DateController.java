package com.engagepoint.controller.question;

import com.engagepoint.controller.page.TemplateEditController;
import com.engagepoint.model.question.DateQuestionBean;
import com.engagepoint.controller.page.QuestionEditController;
import com.engagepoint.model.question.QuestionBean;
import com.engagepoint.model.question.TextQuestionBean;
import com.engagepoint.model.questionnaire.QuestionType;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Calendar;

/**
 * Created by anton.kovunov on 2/25/14.
 */
@Named("dateQuestion")
@RequestScoped
public class DateController extends QuestionEditController {
    @Inject
    TemplateEditController templateEditController;
    private DateQuestionBean currentQuestion;

    @PostConstruct
    public void postConstruct() {
        QuestionBean questionBean = getTemplateTreeController().getCurrentQuestion(); //TODO duble edit
        if (questionBean==null) {
            setNew(true);
            currentQuestion = new DateQuestionBean();
            currentQuestion.setQuestionType(templateEditController.getSelectedQuestionType());
        }
        else {
            currentQuestion = (DateQuestionBean) questionBean;
        }
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
