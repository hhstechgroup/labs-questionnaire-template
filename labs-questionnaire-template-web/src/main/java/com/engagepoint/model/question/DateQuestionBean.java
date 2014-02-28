package com.engagepoint.model.question;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 2/17/14
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateQuestionBean extends QuestionBean {
    private Calendar defaultAnswer;

    public Calendar getDefaultAnswer() {
        return defaultAnswer;
    }

    public void setDefaultAnswer(Calendar defaultAnswer) {
        this.defaultAnswer = defaultAnswer;
    }
}
