package com.engagepoint.controller.page;

import java.io.Serializable;

import com.engagepoint.controller.utils.PageNavigator;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.QuestionType;
import com.engagepoint.model.question.*;

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

    public QuestionType getSelectedQuestionType() {
        return selectedQuestionType;
    }

    public void setSelectedQuestionType(QuestionType selectedQuestionType) {
        this.selectedQuestionType = selectedQuestionType;
        currentQuestion = null;
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
        String stab = PageNavigator.STAB_PAGE;
        if (selectedQuestionType == null) return PageNavigator.NOT_CHOOSE_QUESTION_PAGE;
        if (currentQuestion == null) {
            createQuestion();
        }
        switch (selectedQuestionType) {
            case TEXT:
                return PageNavigator.TEXT_QUESTION_PAGE;
            case DATE:
                return PageNavigator.DATE_QUESTION_PAGE;
            case RANGE:
                return PageNavigator.RANGE_QUESTION_PAGE;
            case TIME:
                return PageNavigator.TIME_QUESTION_PAGE;
            case PARAGRAPHTEXT:
                return PageNavigator.PARAGRAPH_TEXT_QUESTION_PAGE;
            case CHOOSEFROMLIST:
                return PageNavigator.CHOOSE_FROM_LIST_QUESTION_PAGE;
            case FILEUPLOAD:
                return PageNavigator.FILE_UPLOAD_QUESTION_PAGE;
            case MULTIPLECHOICE:
                return PageNavigator.CHOOSE_FROM_LIST_QUESTION_PAGE;
            case CHECKBOX:
                return PageNavigator.CHECKBOX_QUESTION_PAGE;
        }

        return stab;
    }

    public void createQuestion() {
        switch (selectedQuestionType) {
            case TEXT:
                currentQuestion = new TextQuestionBean();
                break;
            case DATE:
                currentQuestion = new DateQuestionBean();
                break;
            case RANGE:
                currentQuestion = new RangeQuestionBean();
                break;
            case TIME:
                currentQuestion = new DateQuestionBean();
                break;
            case PARAGRAPHTEXT:
                currentQuestion = new TextQuestionBean();
                break;
            case CHOOSEFROMLIST:
                currentQuestion = new OptionsQuestionBean();
                break;
            case FILEUPLOAD:
                currentQuestion = new TextQuestionBean();
                break;
            case MULTIPLECHOICE:
                currentQuestion = new OptionsQuestionBean();
                break;
            case CHECKBOX:
                currentQuestion = new OptionsQuestionBean();
                break;
        }
    }

    public static String income() {
        return PageNavigator.QUESTION_EDIT_PAGE;
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
