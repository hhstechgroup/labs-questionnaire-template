package com.engagepoint.bean.QuestionBeans;

import com.engagepoint.bean.QuestionType;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
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
   private Date defaultAnswer;

    public DateQuestionBean() {
        super();
    }

    public Date getDefaultAnswer() {
        return defaultAnswer;
    }

    public DateQuestionBean(String questionText, boolean requiredAnswer, QuestionType questionType, Date defaultAnswer) {
        super(questionText, requiredAnswer, questionType);
        this.defaultAnswer = defaultAnswer;
    }

    public void setDefaultAnswer(Date defaultAnswer) {

        this.defaultAnswer = defaultAnswer;
    }
}
