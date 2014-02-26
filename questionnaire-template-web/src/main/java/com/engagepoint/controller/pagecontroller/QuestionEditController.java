package com.engagepoint.controller.pagecontroller;

import java.io.Serializable;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBeans.*;
import com.engagepoint.bean.QuestionType;
import com.engagepoint.controller.TemplateTreeController;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Used for controlling questionEdit.xhtml
 */

@Named("questionController")
@SessionScoped // Temporary
public class QuestionEditController implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    //temp properties
    private QuestionType selectedQuestionType;
    private QuestionBean currentQuestion;
    //...temp properties

    @Inject
    private TemplateTreeController templateTreeController;

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

    public String getQuestionText() {
        return "";
    }

    public void setQuestionText(String questionText) {
        currentQuestion.setQuestionText(questionText);
    }

    public boolean isRequiredAnswer() {
        return false;
    }

    public void setRequiredAnswer(boolean requiredAnswer) {
        currentQuestion.setRequiredAnswer(requiredAnswer);
    }

    public String getHelpText() {
        return "";
    }

    public void setHelpText(String helpText) {
        currentQuestion.setHelpText(helpText);
    }

    public QuestionType[] getQuestionTypes() {
        return QuestionType.values();
    }

    public String getChangeQuestionType() {
        String notChoose = "/question-pages/notChooseQuestion.xhtml";
        if (selectedQuestionType == null) return notChoose;
        switch (selectedQuestionType) {
            case TEXT:
                currentQuestion = new TextQuestionBean();
                return "/question-pages/textQuestion.xhtml";
            case DATE:
                currentQuestion = new DateQuestionBean();
                return "/question-pages/dateQuestion.xhtml";
            case RANGE:
                currentQuestion = new RangeQuestionBean();
                return "/question-pages/rangeQuestion.xhtml";
            case TIME:
                currentQuestion = new DateQuestionBean();
                return "/question-pages/timeQuestion.xhtml";
            case PARAGRAPHTEXT:
                currentQuestion = new TextQuestionBean();
                return "/question-pages/paragraphQuestion.xhtml";
            case CHOOSEFROMLIST:
                currentQuestion = new OptionsQuestionBean();
                return "/question-pages/chooseFromListQuestion.xhtml";
            case FILEUPLOAD:
                currentQuestion = new TextQuestionBean();
                return "/question-pages/fileUploadQuestion.xhtml";
            case MULTIPLECHOICE:
                currentQuestion = new OptionsQuestionBean();
                return "/question-pages/chooseFromListQuestion.xhtml";
            case CHECKBOX:
                currentQuestion = new OptionsQuestionBean();
                return "/question-pages/checkBoxQuestion.xhtml";
            default:
                return notChoose;
        }
    }

    public static String income() {
        return "/pages/questionEdit?faces-redirect=true&includeViewParams=true";
    }

    public String actionSave() {
        // This controller must be available when selected node is GroupBean
        ((GroupBean) templateTreeController.getSelectedNode().getData()).addToInnerList(currentQuestion);
        templateTreeController.setNodes();
        currentQuestion = null; // Temporary
        selectedQuestionType = null; // Temporary
        return TemplateEditController.income();
    }

    public String actionCancel() {
        return TemplateEditController.income();
    }
}
