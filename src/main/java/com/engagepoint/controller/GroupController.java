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
    private boolean showNewQuestionForm=true;
    private boolean showNewTextTypeQuestionForm;
    
    private GroupBean currentGroup;

    public QuestionType getSelectedQuestionType() {
        return selectedQuestionType;
    }

    public void setSelectedQuestionType(QuestionType selectedQuestionType) {
        this.selectedQuestionType = selectedQuestionType;
        switch (selectedQuestionType) {
        case TEXT:
        	setShowNewTextTypeQuestionForm(true);
        	break;
		case CHECKBOX:
			setShowNewTextTypeQuestionForm(false);			//TODO: temp, then setters will change others to false
			break;
		case CHOOSEFROMLIST:
			setShowNewTextTypeQuestionForm(false);
			break;
		case DATE:
			setShowNewTextTypeQuestionForm(false);
			break;
		case FILEUPLOAD:
			setShowNewTextTypeQuestionForm(false);
			break;
		case GRID:
			setShowNewTextTypeQuestionForm(false);
			break;
		case MULTIPLECHOICE:
			setShowNewTextTypeQuestionForm(false);
			break;
		case PARAGRAPHTEXT:
			setShowNewTextTypeQuestionForm(false);
			break;
		case RANGE:
			setShowNewTextTypeQuestionForm(false);
			break;
		case TIME:
			setShowNewTextTypeQuestionForm(false);
			break;
		default:
			setShowNewTextTypeQuestionForm(false);
			break;
        }
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

    public boolean isShowNewQuestionForm() {
        return showNewQuestionForm;
    }

    public void setShowNewQuestionForm(boolean showNewQuestionForm) {
        this.showNewQuestionForm = showNewQuestionForm;
    }

    public void changeEditable() {
        this.showNewQuestionForm = true;
    }

    public String income() {
        return "group?faces-redirect=true";
    }

	public boolean isShowNewTextTypeQuestionForm() {
		return showNewTextTypeQuestionForm;
	}

	
	/**
	 * @param showNewTextTypeQuestionForm if true - should set others to false
	 * 
	 */
	public void setShowNewTextTypeQuestionForm(boolean showNewTextTypeQuestionForm) {
		this.showNewTextTypeQuestionForm = showNewTextTypeQuestionForm;
		
			
	}
	
	public void saveQuestion(QuestionBean qb) {
		currentGroup.getQuestionsList().add(qb);
		
	}

}
