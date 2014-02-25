package com.engagepoint.bean.QuestionBeans;

import com.engagepoint.bean.QuestionType;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 2/17/14
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
@Named("datequestion")
@RequestScoped
public class DateQuestionBean extends QuestionBean {
    public DateQuestionBean(){
        super();
    }

    private Calendar defaultAnswer;

    public Calendar getDefaultAnswer() {
        return defaultAnswer;
    }

    public void setDefaultAnswer(Calendar defaultAnswer) {
        this.defaultAnswer = defaultAnswer;
    }
}
