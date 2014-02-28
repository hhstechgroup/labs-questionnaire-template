package com.engagepoint.model.question.utils;

import com.engagepoint.model.question.RangeQuestionBean;
import com.engagepoint.controller.page.QuestionEditController;

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

@FacesValidator(value = "com.engagepoint.model.question.utils.RangeValidator")
public class RangeValidator implements Validator {

    @Inject
    private QuestionEditController questionEditController;

    //This method is standart for validator. Name and incoming parameters may not be changed. NEVER.
    @Override
    public void validate(final FacesContext context,final UIComponent component,final Object value) throws ValidatorException {

        //We are getting min and max values to compare them. First of all we need to parse them from String to Integer
        String minValue = ((RangeQuestionBean) questionEditController.getCurrentQuestion()).getMinValue();
        String maxValue = ((RangeQuestionBean) questionEditController.getCurrentQuestion()).getMaxValue();

        //This is the parser. Now two values are ready to be compared.
        int minIntValue = Integer.parseInt(minValue);
        int maxIntValue = Integer.parseInt(maxValue);

        //Minimum value have to be less or equal to max value. Now we are checking that.
            if(minIntValue>maxIntValue) {

                //If TRUE, this method throw ValidatorException so that JSF can catch it and display on page
                //Working in JSF 2.0 or later versions
                FacesMessage msg = new FacesMessage("Wrong range values. Please type correct numbers.");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }

        }

    }
