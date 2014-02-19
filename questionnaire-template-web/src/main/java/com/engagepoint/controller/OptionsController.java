package com.engagepoint.controller;

import com.engagepoint.bean.QuestionBeans.OptionsQuestionBean;
import com.engagepoint.model.OptionQuestionModel;
import com.engagepoint.model.VariantItem;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Controller for multiplechoice,checkboxes and choose from a list question types.
 */
@Named
@SessionScoped
public class OptionsController implements Serializable {

    @Inject
    private QuestFormTreeController questFormTreeController;
    private OptionsQuestionBean optionsQuestionBean;
    private OptionQuestionModel optionQuestionModel;

    public OptionQuestionModel getOptionQuestionModel() {
        return optionQuestionModel;
    }

    public void setOptionQuestionModel(OptionQuestionModel optionQuestionModel) {
        this.optionQuestionModel = optionQuestionModel;
    }

    public OptionsQuestionBean getOptionsQuestionBean() {
        return optionsQuestionBean;
    }

    public void setOptionsQuestionBean(OptionsQuestionBean optionsQuestionBean) {
        this.optionsQuestionBean = optionsQuestionBean;
        init(optionsQuestionBean);
    }

    public void init(OptionsQuestionBean optionsQuestionBean){
        optionQuestionModel = new OptionQuestionModel(optionsQuestionBean);
    }

    public void addOption(String option) {
        optionQuestionModel.addOption(new VariantItem(option));
    }

    public void removeOption(String option) {
        optionQuestionModel.removeOption(new VariantItem(option));
    }

    public String saveQuestion() {
        optionsQuestionBean.setOptions(optionQuestionModel.getOptions());
        optionsQuestionBean.setDefaultOption(optionQuestionModel.getDefaultOption());
        questFormTreeController.setAddedquestion(optionsQuestionBean);
        return "/pages/questForm?faces-redirect=true";
    }
}
