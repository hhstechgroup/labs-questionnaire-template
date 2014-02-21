package com.engagepoint.controller.pagecontroller;

import com.engagepoint.bean.QuestionBeans.OptionsQuestionBean;
import com.engagepoint.model.VariantItem;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Controller for multiplechoice,checkboxes and choose from a list question types.
 */
@Named
@RequestScoped
public class OptionsQuestionEditController implements Serializable {

    @Inject
    private QuestionEditController questionEditController;
    @Inject
    private OptionsQuestionBean optionQuestionBean;

    public OptionsQuestionBean getOptionQuestionBean() {
        return optionQuestionBean;
    }

    public void addOption(String option) {
        optionQuestionBean.getOptions().add(new VariantItem(option));
        updateModel();
    }

    public void removeOption(VariantItem option) {
        optionQuestionBean.getOptions().remove(option);
        updateModel();
    }

    //adding variants to dataModel
    private void updateModel() {
        optionQuestionBean.getDataModel().setWrappedData(optionQuestionBean.getOptions());
    }

    public String actionCancel() {
        return TemplateEditController.income();
    }

    public String actionSave() {
        questionEditController.addQuestionToTree();
        return TemplateEditController.income();
    }

    public static String income() {
        return "/question-pages/chooseFromListQuestion?faces-redirect=true&includeViewParams=true";
    }
}
