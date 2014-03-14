package com.engagepoint.model.question.utils;


import javax.xml.bind.annotation.XmlAttribute;

public class RangeItem {

    private String minValue;
    private String maxValue;

    public RangeItem() {
        minValue = "0";
        maxValue = "0";
    }

    public RangeItem(String minValue, String maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
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

    @Override
    public String toString(){
        return minValue+", "+maxValue;
    }
}
