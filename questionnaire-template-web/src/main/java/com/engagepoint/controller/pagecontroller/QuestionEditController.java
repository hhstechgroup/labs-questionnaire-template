package com.engagepoint.controller.pagecontroller;

import java.io.Serializable;

import com.engagepoint.bean.QuestionBeans.OptionsQuestionBean;
import com.engagepoint.bean.QuestionBeans.QuestionBean;
import com.engagepoint.bean.QuestionType;
import com.engagepoint.controller.QuestFormTreeController;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
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

    @Inject
    private QuestFormTreeController questFormTreeController;

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

	public String changeQuestionType() {
		switch (selectedQuestionType) {
		case TEXT:
			return "/question-pages/textquestion?faces-redirect=true";
        case DATE:
            return "/question-pages/datequestion?faces-redirect=true";
        case RANGE:
            return "/question-pages/rangeQuestion?faces-redirect=true";
        case TIME:
            return "/question-pages/timeQuestion?faces-redirect=true";
        case PARAGRAPHTEXT:
            return "/question-pages/paragraphQuestion?faces-redirect=true";
        case CHOOSEFROMLIST:
            currentQuestion = new OptionsQuestionBean();
            return "/question-pages/chooseFromList?faces-redirect=true";
        case FILEUPLOAD:
            return "/question-pages/fileUploadQuestion?faces-redirect=true";
        case MULTIPLECHOICE:
            return "/question-pages/chooseFromList?faces-redirect=true";
		default:
			return null;
		}
    }

    public void addQuestionToTree() {
        questFormTreeController.addQuestionToCurrentGroup(currentQuestion);
    }

    public String income() {
        return "questForm?faces-redirect=true";
    }

}
