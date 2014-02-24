package com.engagepoint.controller.pagecontroller;


import com.engagepoint.bean.QuestionBeans.QuestionBean;
import com.engagepoint.bean.QuestionBeans.TextQuestionBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class OptionLessController {
    private String defaultAnswer;
    @Inject
    private QuestionEditController questionController;

    public String getDefaultAnswer() {
        return defaultAnswer;
    }

    public void setDefaultAnswer(String defaultAnswer) {
        this.defaultAnswer = defaultAnswer;
    }

    public QuestionEditController getQuestionController() {
        return questionController;
    }

    public void setQuestionController(QuestionEditController questionController) {
        this.questionController = questionController;
    }
    public TextQuestionBean getCurrentQuestion() {
        return (TextQuestionBean) questionController.getCurrentQuestion();
    }
    public String actionSave() {
       TextQuestionBean questionBean = getCurrentQuestion();
        questionBean.setDefaultAnswer(defaultAnswer);
        questionController.addQuestionToTree();
        return TemplateEditController.income();
    }
}
