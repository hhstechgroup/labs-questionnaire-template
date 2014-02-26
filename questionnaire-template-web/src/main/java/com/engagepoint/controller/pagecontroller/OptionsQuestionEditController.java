package com.engagepoint.controller.pagecontroller;


import com.engagepoint.bean.QuestionBeans.OptionsQuestionBean;
import com.engagepoint.model.VariantItem;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Controller for multiplechoice,checkboxes and choose from a list question types.
 */
@Named
@SessionScoped
public class OptionsQuestionEditController implements Serializable {

    @Inject
    private QuestionEditController questionEditController;

    public OptionsQuestionBean getBeanItem()
    {
        return ((OptionsQuestionBean)questionEditController.getCurrentQuestion());
    }

    /**
     * Update options in ListOfOptionsDataModel.
     */
    private void updateModel() {
        ((OptionsQuestionBean)questionEditController.getCurrentQuestion()).getDataModel().setWrappedData(((OptionsQuestionBean)questionEditController.getCurrentQuestion()).getOptions());
    }

    /**
     * Add variant to a question.
     *
     * @param option VariantItem object
     */
    public void addOption(String option) {
        ((OptionsQuestionBean)questionEditController.getCurrentQuestion()).getOptions().add(new VariantItem(option));
        updateModel();
    }

    /**
     * Remove variant from a question.
     *
     * @param option VariantItem object
     */
    public void removeOption(VariantItem option) {
        ((OptionsQuestionBean)questionEditController.getCurrentQuestion()).getOptions().remove(option);
        updateModel();
    }

    /**
     * Get chooseFromListQuestion page.
     *
     * @return chooseFromListQuestion page
     */
    public static String income() {
        return "/question-pages/chooseFromListQuestion?faces-redirect=true&includeViewParams=true";
    }
}