package com.engagepoint.controller.question;

import com.engagepoint.controller.page.TemplateEditController;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.RangeQuestionBean;
import com.engagepoint.controller.page.QuestionEditController;
import com.engagepoint.model.question.rules.Rule;
import com.engagepoint.model.question.utils.RangeItem;
import com.engagepoint.model.questionnaire.QuestionType;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("rangeQuestion")
@ConversationScoped
public class RangeQuestionController extends QuestionEditController {

    private RangeQuestionBean currentQuestion;

    @PostConstruct
    public void postConstruct() {
        beginConversation();
        Question question = getTemplateTreeController().getCurrentQuestion();
        if (question == null) {
            setNew(true);
            currentQuestion = new RangeQuestionBean(getTemplateTreeController().getCurrentGroup());
            currentQuestion.setQuestionType(QuestionType.RANGE);
            currentQuestion.setRangeItem(new RangeItem());
        } else {
            currentQuestion = (RangeQuestionBean) question;
        }
        currentQuestionEventNew.fire(currentQuestion);
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

    @Override
    public void deleteRule(Rule rule) {

    }
}
