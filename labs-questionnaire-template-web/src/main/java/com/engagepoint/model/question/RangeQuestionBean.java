package com.engagepoint.model.question;


import com.engagepoint.model.question.utils.RangeItem;
import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlElement;

public class RangeQuestionBean extends Question {
    private RangeItem rangeItem;

    public RangeQuestionBean(GroupBean currentGroup) {
        super(currentGroup);
    }

    @XmlElement(name = "range")
    public RangeItem getRangeItem() {
        return rangeItem;
    }

    public void setRangeItem(RangeItem rangeItem) {
        this.rangeItem = rangeItem;
    }
}
