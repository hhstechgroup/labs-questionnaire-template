package com.engagepoint.controller.question;

import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.RangeQuestionBean;
import com.engagepoint.controller.page.QuestionEditController;
import com.engagepoint.model.question.utils.RangeItem;
import com.engagepoint.model.questionnaire.QuestionType;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("rangeQuestion")
@RequestScoped
public class RangeQuestionController extends QuestionEditController {

    private RangeQuestionBean currentQuestion;

    @PostConstruct
    public void postConstruct() {
        Question question = getTemplateTreeController().getCurrentQuestion();
        if (question == null) {
            setNew(true);
            currentQuestion = new RangeQuestionBean();
            currentQuestion.setQuestionType(QuestionType.RANGE);
            currentQuestion.setRangeItem(new RangeItem());
        } else {
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
