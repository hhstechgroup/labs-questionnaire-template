package com.engagepoint.model.question;


import com.engagepoint.model.question.utils.RangeItem;

import javax.xml.bind.annotation.XmlElement;

public class RangeQuestionBean extends Question {
    private RangeItem rangeItem;

    @XmlElement(name = "range")
    public RangeItem getRangeItem() {
        return rangeItem;
    }

    public void setRangeItem(RangeItem rangeItem) {
        this.rangeItem = rangeItem;
    }
}
