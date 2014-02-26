package com.engagepoint.bean.QuestionBeans;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by stanislav.sobolev on 2/17/14.
 */

@Named("rangeQuestion")
@RequestScoped
public class RangeQuestionBean extends QuestionBean {

    private String minValue;
    private String maxValue;

    public RangeQuestionBean(){
        super();
    }

    public int getMinValue() {
        return Integer.parseInt(minValue);
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return Integer.parseInt(maxValue);
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

}
