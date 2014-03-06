package com.engagepoint.model.question;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

public class DateQuestionBean extends Question {
    private Date defaultAnswer;

    @XmlElement(name = "default-answer")
    public Date getDefaultAnswer() {
        return defaultAnswer;
    }

    public void setDefaultAnswer(Date defaultAnswer) {
        this.defaultAnswer = defaultAnswer;
    }
}
