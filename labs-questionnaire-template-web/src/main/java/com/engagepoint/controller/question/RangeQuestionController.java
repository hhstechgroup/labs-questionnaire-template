package com.engagepoint.controller.question;

import com.engagepoint.model.question.RangeQuestionBean;
import com.engagepoint.controller.page.QuestionEditController;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by stanislav.sobolev on 2/25/14.
 */
@Named
@RequestScoped
public class RangeQuestionController {

    /*@Inject
    private QuestionEditController questionEditController;*/

    public String getMinValue() {
        //return ((RangeQuestionBean) questionEditController.getCurrentQuestion()).getMinValue();
        return "";
    }

    public void setMinValue(String minValue) {
        //((RangeQuestionBean) questionEditController.getCurrentQuestion()).setMinValue(minValue);
    }

    public String getMaxValue() {
        //return ((RangeQuestionBean) questionEditController.getCurrentQuestion()).getMaxValue();
        return "";
    }

    public void setMaxValue(String maxValue) {
        //((RangeQuestionBean) questionEditController.getCurrentQuestion()).setMaxValue(maxValue);
    }
}
