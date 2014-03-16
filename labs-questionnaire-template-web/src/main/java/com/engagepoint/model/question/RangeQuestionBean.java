package com.engagepoint.model.question;


import com.engagepoint.model.question.utils.RangeItem;
import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "rangeQuestionBean", propOrder = {
        "questionId",
        "requiredAnswer",
        "questionText",
        "questionType",
        "rules",
        "helpText",
        "rangeItem",
        "defaultAnswers"
})
public class RangeQuestionBean extends Question {
    private RangeItem rangeItem;

    public RangeQuestionBean() {
        super();
        rangeItem = new RangeItem();
    }

    public RangeQuestionBean(GroupBean currentGroup) {
        super(currentGroup);
        rangeItem = new RangeItem();
    }

    @XmlElement(name = "range")
    public RangeItem getRangeItem() {
        return rangeItem;
    }

    public void setRangeItem(RangeItem rangeItem) {
        this.rangeItem = rangeItem;
    }
}
