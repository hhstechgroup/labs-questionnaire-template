package com.engagepoint.model.question;

import com.engagepoint.model.question.utils.RangeItem;
import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "rangeQuestionBean", propOrder = {
        "id",
        "requiredAnswer",
        "questionText",
        "questionType",
        "questionRules",
        "helpText",
        "rangeItem",
        "defaultAnswers"
})
public class RangeQuestionBean extends Question {
    private RangeItem rangeItem;

    public RangeQuestionBean() {
        super();
        rangeItem = new RangeItem();
        getDefaultAnswers().add(0, "");
        getDefaultAnswers().add(1, "");
    }

    public RangeQuestionBean(GroupBean currentGroup) {
        super(currentGroup);
        rangeItem = new RangeItem();
        getDefaultAnswers().add(0, "");
        getDefaultAnswers().add(1, "");
    }

    @XmlElement(name = "range")
    public RangeItem getRangeItem() {
        return rangeItem;
    }

    public void setRangeItem(RangeItem rangeItem) {
        this.rangeItem = rangeItem;
    }

    @XmlTransient
    public String getDefaultMin() {
        return getDefaultAnswers().get(0);
    }

    public void setDefaultMin(String defaultAnswer) {
        getDefaultAnswers().set(0, defaultAnswer);
    }

    @XmlTransient
    public String getDefaultMax() {
        return getDefaultAnswers().get(1);
    }

    public void setDefaultMax(String defaultAnswer) {
        getDefaultAnswers().set(1, defaultAnswer);
    }
}
