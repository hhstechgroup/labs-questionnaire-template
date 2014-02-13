package com.engagepoint.controller;


import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.QuestionType;

import javax.enterprise.context.RequestScoped;

import javax.inject.Named;


@Named("questionController")
@RequestScoped
public class QuestionEditController {
    
    private QuestionBean currentQuestion;
    private QuestionType selectedQuestionType;
    
    //TODO ?????
    public QuestionEditController(){
    	currentQuestion = new QuestionBean();
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

	public void changeQuestionType(){
		//TODO cast currentQuestion to extended type depended on selectedQuestionType
		//valueChangeListener maybe?
	}

}
