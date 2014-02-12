package com.engagepoint.controller;


import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.QuestionType;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;


@Named("questionController")
@SessionScoped
public class QuestionEditController implements Serializable {
    private static final long serialVersionUID = 1L;
    
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

   /* public String income() {
        return "group?faces-redirect=true";
    }*/

	public void changeQuestionType(){
		//TODO cast currentQuestion to extended type depended on selectedQuestionType
		//valueChangeListener maybe?
	}

}
