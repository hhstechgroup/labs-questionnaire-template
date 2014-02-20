package com.engagepoint.controller.pagecontroller;

import java.io.Serializable;

import com.engagepoint.bean.QuestionBeans.OptionsQuestionBean;
import com.engagepoint.bean.QuestionBeans.QuestionBean;
import com.engagepoint.bean.QuestionType;
import com.engagepoint.controller.QuestFormTreeController;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Used for controlling questionedit.xhtml
 */

@Named("questionController")
@SessionScoped
public class QuestionEditController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private QuestionBean currentQuestion;
	private QuestionType selectedQuestionType;
    private String questionText="";		//questiontext
    private boolean requiredAnswer;		//is answer required or not
    private String helpText="";			//Help texts for questions

    @Inject
    private QuestFormTreeController questFormTreeController;

	public QuestionEditController() {
		
	}

	public QuestionBean getCurrentQuestion() {
		return questFormTreeController.getCurrentQuestion();
	}

	public void setCurrentQuestion(QuestionBean currentQuestion) {
		/*this.currentQuestion = currentQuestion;
        questionText = currentQuestion.getQuestionText();
        requiredAnswer = currentQuestion.isRequiredAnswer();
        helpText = currentQuestion.getHelpText(); */
        questFormTreeController.setCurrentQuestion(currentQuestion);
        questionText = currentQuestion.getQuestionText();
        requiredAnswer = currentQuestion.isRequiredAnswer();
        helpText = currentQuestion.getHelpText();
	}

	public QuestionType getSelectedQuestionType() {
		return selectedQuestionType;
	}

	public void setSelectedQuestionType(QuestionType selectedQuestionType) {
		this.selectedQuestionType = selectedQuestionType;
	}

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public boolean isRequiredAnswer() {
        return requiredAnswer;
    }

    public void setRequiredAnswer(boolean requiredAnswer) {
        this.requiredAnswer = requiredAnswer;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
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
            OptionsQuestionBean question = new OptionsQuestionBean();
            question.setQuestionType(QuestionType.CHOOSEFROMLIST);
            setCurrentQuestion(question);
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
        QuestionBean question = getCurrentQuestion();
        question.setHelpText(helpText);
        question.setRequiredAnswer(requiredAnswer);
        question.setQuestionText(questionText);
        questFormTreeController.addQuestionToCurrentGroup(question);
    }

    public String income() {
        return "questForm?faces-redirect=true";
    }

}
