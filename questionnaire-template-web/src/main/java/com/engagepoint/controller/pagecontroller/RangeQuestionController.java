package com.engagepoint.controller.pagecontroller;

import com.engagepoint.bean.QuestionBeans.RangeQuestionBean;
import com.engagepoint.bean.QuestionType;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by stanislav.sobolev on 2/25/14.
 */
@Named
@RequestScoped
public class RangeQuestionController {

    @Inject
    private QuestionEditController questionEditController;

    public String getMinValue() {
        return "";
    }

    public void setMinValue(String minValue) {
        ((RangeQuestionBean) questionEditController.getCurrentQuestion()).setMinValue(minValue);
    }

    public String getMaxValue() {
        return "";
    }

    public void setMaxValue(String maxValue) {
        ((RangeQuestionBean) questionEditController.getCurrentQuestion()).setMaxValue(maxValue);
    }
}
