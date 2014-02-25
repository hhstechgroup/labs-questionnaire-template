package com.engagepoint.bean.QuestionBeans;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by stanislav.sobolev on 2/17/14.
 */

@Named("rangeQuestion")
@RequestScoped
public class RangeQuestionBean extends QuestionBean {

    private int minValue;
    private int maxValue;
    private RangeQuestionBean rangeQuestionBean;

    public RangeQuestionBean() {
        super();
    }

    public RangeQuestionBean getRangeQuestionBean() {
        return rangeQuestionBean;
    }

    public void setRangeQuestionBean(RangeQuestionBean rangeQuestionBean) {
        this.rangeQuestionBean = rangeQuestionBean;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

}
