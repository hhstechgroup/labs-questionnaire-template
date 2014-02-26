package com.engagepoint.controller.pagecontroller;

import com.engagepoint.bean.QuestionBeans.RangeQuestionBean;
import com.sun.istack.internal.NotNull;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by stanislav.sobolev on 2/25/14.
 */
@Named
@RequestScoped
public class RangeQuestionController {

    private String minValue = "0";
    private String maxValue = "0";

    @Inject
    private QuestionEditController questionEditController;

    public int getMinValue() {
        return Integer.parseInt(minValue);
    }

    public void setMinValue(String minValue) {
        ((RangeQuestionBean) questionEditController.getCurrentQuestion()).setMinValue(minValue);
        this.minValue=minValue;
    }

    public int getMaxValue() {
        return Integer.parseInt(maxValue);
    }

    public void setMaxValue(String maxValue) {
        ((RangeQuestionBean) questionEditController.getCurrentQuestion()).setMaxValue(maxValue);
        this.maxValue=maxValue;
    }
}
