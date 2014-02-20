package com.engagepoint.controller.pagecontroller;

import com.engagepoint.bean.QuestionBeans.OptionsQuestionBean;
import com.engagepoint.bean.QuestionType;
import com.engagepoint.model.OptionQuestionModel;
import com.engagepoint.model.VariantItem;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
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
    private QuestionEditController questionController;
    @Inject
    private OptionQuestionModel optionsQuestionModel;

    @PostConstruct
    public void postCostruct() {
        init();
    }

    public void init() {
        optionsQuestionModel.setPropertiesFromBean(getCurrentQuestion());
    }


    public OptionsQuestionBean getCurrentQuestion() {
        return (OptionsQuestionBean) questionController.getCurrentQuestion();
    }


    public OptionQuestionModel getOptionQuestionModel() {
        return optionsQuestionModel;
    }

    public void setOptionQuestionModel(OptionQuestionModel optionQuestionModel) {
        this.optionsQuestionModel = optionQuestionModel;
    }

    public void addOption(String option) {
        optionsQuestionModel.addOption(new VariantItem(option));
    }

    public void removeOption(String option) {
        optionsQuestionModel.removeOption(new VariantItem(option));
    }

    public String actionSave() {
        OptionsQuestionBean optionsQuestionBean = getCurrentQuestion();
        optionsQuestionBean.setOptions(optionsQuestionModel.getOptions());
        optionsQuestionBean.setDefaultOption(optionsQuestionModel.getDefaultOption());
        questionController.addQuestionToTree();
        return "/pages/questForm?faces-redirect=true";
    }

    public String actionCancel() {
        return "/pages/questForm?faces-redirect=true";
    }
}
