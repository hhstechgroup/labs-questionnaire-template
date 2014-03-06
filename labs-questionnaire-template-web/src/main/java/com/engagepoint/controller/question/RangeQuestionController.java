package com.engagepoint.controller.question;

import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.RangeQuestionBean;
import com.engagepoint.controller.page.QuestionEditController;
import com.engagepoint.model.questionnaire.QuestionType;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by stanislav.sobolev on 2/25/14.
 */
@Named("rangeQuestion")
@RequestScoped
public class RangeQuestionController extends QuestionEditController {

    private RangeQuestionBean currentQuestion;

    @PostConstruct
    public void postConstruct() {
        Question question = getTemplateTreeController().getCurrentQuestion();
        if (question ==null) {
            setNew(true);
            currentQuestion = new RangeQuestionBean();
            currentQuestion.setQuestionType(QuestionType.RANGE);
        }
        else {
            currentQuestion = (RangeQuestionBean) question;
        }
    }

    public RangeQuestionBean getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(RangeQuestionBean currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    @Override
    public String actionSave() {
        getTemplateTreeController().setCurrentQuestion(currentQuestion);
        return super.actionSave();
    }

}
