package com.engagepoint.controller.question;

import com.engagepoint.model.question.QuestionBean;
import com.engagepoint.model.question.TextQuestionBean;
import com.engagepoint.controller.page.QuestionEditController;
import com.engagepoint.model.questionnaire.QuestionType;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("textQuestion")
@RequestScoped
public class TextQuestionController extends QuestionEditController {

    private TextQuestionBean currentQuestion;

    @PostConstruct
    public void postConstruct() {
        QuestionBean questionBean = getTemplateTreeController().getCurrentQuestion(); //TODO duble edit
        if (questionBean==null) {
            setNew(true);
            currentQuestion = new TextQuestionBean();
            currentQuestion.setQuestionType(QuestionType.TEXT);
        }
        else {
            currentQuestion = (TextQuestionBean) questionBean;
        }
    }

    public TextQuestionBean getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(TextQuestionBean currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    @Override
    public String actionSave() {
        getTemplateTreeController().setCurrentQuestion(currentQuestion);
        return super.actionSave();
    }

}