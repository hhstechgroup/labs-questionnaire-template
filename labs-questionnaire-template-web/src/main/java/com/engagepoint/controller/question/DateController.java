package com.engagepoint.controller.question;

import com.engagepoint.model.question.DateQuestionBean;
import com.engagepoint.controller.page.QuestionEditController;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Calendar;

/**
 * Created by anton.kovunov on 2/25/14.
 */
@Named
@RequestScoped
public class DateController {
    @Inject
    private QuestionEditController questionEditController;
    public Calendar getDefaultAnswer() {
        return Calendar.getInstance();
    }

    public void setDefaultAnswer(Calendar defaultAnswer) {
        ((DateQuestionBean) this.questionEditController.getCurrentQuestion()).setDefaultAnswer(defaultAnswer);
    }
}
