package com.engagepoint.bean;

import com.engagepoint.bean.QuestionBeans.RangeQuestionBean;
import com.engagepoint.controller.pagecontroller.QuestionEditController;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

/**
 * Created by stanislav.sobolev on 2/25/14.
 */

@FacesValidator(value = "com.engagepoint.bean.RangeValidator")
public class RangeValidator implements Validator {

    @Inject
    private QuestionEditController questionEditController;

    @Override
    public void validate(final FacesContext context,final UIComponent component,final Object value) throws ValidatorException {

        String minValue = ((RangeQuestionBean) questionEditController.getCurrentQuestion()).getMinValue();
        String maxValue = ((RangeQuestionBean) questionEditController.getCurrentQuestion()).getMaxValue();

        int minIntValue = Integer.parseInt(minValue);
        int maxIntValue = Integer.parseInt(maxValue);

            if(minIntValue>maxIntValue) {
                FacesMessage msg = new FacesMessage("Wrong range values. Please type correct numbers.");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }

        }

    }
