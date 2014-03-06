package com.engagepoint.model.question;


import javax.xml.bind.annotation.XmlAttribute;

public class RangeQuestionBean extends Question {

    private String minValue;
    private String maxValue;

    public RangeQuestionBean() {
        minValue = "0";
        maxValue = "0";
    }

    @XmlAttribute(name = "range-begin")
    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    @XmlAttribute(name = "range-end")
    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

}
