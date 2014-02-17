package com.engagepoint.controller;

import java.io.Serializable;

import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.QuestionType;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("questionController")
@SessionScoped
public class QuestionEditController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private QuestionBean currentQuestion;
	private QuestionType selectedQuestionType;

	
	public QuestionEditController() {
		
	}

	public QuestionBean getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(QuestionBean currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public QuestionType getSelectedQuestionType() {
		return selectedQuestionType;
	}

	public void setSelectedQuestionType(QuestionType selectedQuestionType) {
		this.selectedQuestionType = selectedQuestionType;
	}

	public QuestionType[] getQuestionTypes() {
		return QuestionType.values();
	}

	public String income() {
		return "questForm?faces-redirect=true";
	}

	public String changeQuestionType() {
		switch (selectedQuestionType) {
		case TEXT:
			return "/question-pages/textquestion?faces-redirect=true";

		default:
			return null;
		}

	}

}
