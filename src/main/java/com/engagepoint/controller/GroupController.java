package com.engagepoint.controller;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.QuestionType;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.io.Serializable;


@Named("groupController")
@SessionScoped
public class GroupController implements Serializable {
    private static final long serialVersionUID = 1L;
    private QuestionType selectedQuestionType;
    
    private GroupBean currentGroup;

    public QuestionType getSelectedQuestionType() {
        return selectedQuestionType;
    }
    
    public void setSelectedQuestionType(QuestionType selectedQuestionType) {
    	this.selectedQuestionType = selectedQuestionType;
    }


    public GroupBean getCurrentGroup() {
		return currentGroup;
	}

	public void setCurrentGroup(GroupBean currentGroup) {
		this.currentGroup = currentGroup;
	}

	public QuestionType[] getQuestionTypes() {
        return QuestionType.values();
    }

    public String income() {
        return "group?faces-redirect=true";
    }

	public void saveQuestion(QuestionBean qb) {
		currentGroup.getQuestionsList().add(qb);
		
	}

}
