package com.engagepoint.model.question;

import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlElement;

public class TextQuestionBean extends Question {
	private String defaultAnswer;

    public TextQuestionBean() {
        super();
    }

    public TextQuestionBean(GroupBean currentGroup) {
        super(currentGroup);
    }

    @XmlElement(name = "default-answer")
	public String getDefaultAnswer() {
		return defaultAnswer;
	}

	public void setDefaultAnswer(String defaultAnswer) {
		this.defaultAnswer = defaultAnswer;
	}
}
