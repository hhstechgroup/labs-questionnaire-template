package com.engagepoint.bean.QuestionBeans;

import com.engagepoint.bean.QuestionBeans.QuestionBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

public class TextQuestionBean extends QuestionBean {
	private String defaultAnswer;

	public String getDefaultAnswer() {
		return defaultAnswer;
	}

	public void setDefaultAnswer(String defaultAnswer) {
		this.defaultAnswer = defaultAnswer;
	}
}
