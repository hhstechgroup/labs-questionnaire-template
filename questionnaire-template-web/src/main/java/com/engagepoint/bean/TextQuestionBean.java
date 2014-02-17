package com.engagepoint.bean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named("textquestion")
@RequestScoped
public class TextQuestionBean extends QuestionBean {
	
	private String defaultAnswer;

	public String getDefaultAnswer() {
		return defaultAnswer;
	}

	public void setDefaultAnswer(String defaultAnswer) {
		this.defaultAnswer = defaultAnswer;
	}
	
	

}
