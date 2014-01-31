package com.engagepoint.controller;

import com.engagepoint.bean.QuestionType;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * TEMP class to hold operate with selectonemenu to choose a type of question to be add 
 * 
 * @author dmytro.sorych
 *
 */

@ManagedBean (name = "qtc")
@SessionScoped
public class QuestionTypeController {
	
	private QuestionType selectedQuestionType;
	
	public QuestionType getSelectedQuestionType() {
		return selectedQuestionType;
	}

	public void setSelectedQuestionType(QuestionType selectedQuestionType) {
		this.selectedQuestionType = selectedQuestionType;
	}
		
	public QuestionType[] getQuestionTypes() {
		return QuestionType.values();
	}

}
