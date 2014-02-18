package com.engagepoint.bean.QuestionBeans;

import com.engagepoint.bean.QuestionBeans.QuestionBean;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named("textquestion")
@RequestScoped
public class TextQuestionBean extends QuestionBean {
	
	public TextQuestionBean(){
		super();
	}
	
	private String defaultAnswer;

	public String getDefaultAnswer() {
		return defaultAnswer;
	}

	public void setDefaultAnswer(String defaultAnswer) {
		this.defaultAnswer = defaultAnswer;
	}
	
	

}
