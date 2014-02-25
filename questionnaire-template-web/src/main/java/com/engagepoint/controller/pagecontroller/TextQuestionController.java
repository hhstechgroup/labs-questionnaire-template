package com.engagepoint.controller.pagecontroller;

import com.engagepoint.bean.QuestionBeans.TextQuestionBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class TextQuestionController {

    @Inject
    private QuestionEditController questionController;

    public String getDefaultAnswer() {
        return "";
    }

    public void setDefaultAnswer(String defaultAnswer) {
        ((TextQuestionBean) this.questionController.getCurrentQuestion()).setDefaultAnswer(defaultAnswer);
    }

}