package com.engagepoint.model.question;

import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

public class DateQuestionBean extends Question {
    private Date defaultAnswer;

    public DateQuestionBean() {
        super();
    }

    public DateQuestionBean(GroupBean currentGroup) {
        super(currentGroup);
    }

    @XmlTransient
    public Date getDefaultAnswer() {
        return defaultAnswer;
    }

    public void setDefaultAnswer(Date defaultAnswer) {
        this.defaultAnswer = defaultAnswer;
    }
}
