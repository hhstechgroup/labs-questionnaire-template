package com.engagepoint.model.question;


import com.engagepoint.model.question.utils.RangeItem;
import com.engagepoint.model.questionnaire.GroupBean;

public class RangeQuestionBean extends Question {
    private RangeItem rangeItem;

    public RangeQuestionBean() {
        super();
    }

    public RangeQuestionBean(GroupBean currentGroup) {
        super(currentGroup);
    }

    public RangeItem getRangeItem() {
        return rangeItem;
    }

    public void setRangeItem(RangeItem rangeItem) {
        this.rangeItem = rangeItem;
    }
}
