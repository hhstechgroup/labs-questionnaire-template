package com.engagepoint.model.question;

import javax.xml.bind.annotation.XmlElement;

public class TextQuestionBean extends QuestionBean {
	private String defaultAnswer;

    public TextQuestionBean(){}

    @XmlElement(name = "default-answer")
	public String getDefaultAnswer() {
		return defaultAnswer;
	}

	public void setDefaultAnswer(String defaultAnswer) {
		this.defaultAnswer = defaultAnswer;
	}
}
