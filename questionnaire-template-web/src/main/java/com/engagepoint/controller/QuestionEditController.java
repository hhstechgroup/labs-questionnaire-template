package com.engagepoint.controller;


import com.engagepoint.bean.QuestionBasicBean;
import com.engagepoint.bean.QuestionType;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;


@Named("questionController")
@SessionScoped
public class QuestionEditController implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private QuestionBasicBean currentQuestion;
    private QuestionType selectedQuestionType;
    
    public QuestionEditController(){
    	currentQuestion = new QuestionBasicBean();
    }
    
    public QuestionBasicBean getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(QuestionBasicBean currentQuestion) {
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
        return "group?faces-redirect=true";
    }

	

}
