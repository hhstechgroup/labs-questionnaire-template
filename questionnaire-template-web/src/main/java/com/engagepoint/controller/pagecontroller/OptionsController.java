package com.engagepoint.controller.pagecontroller;

import com.engagepoint.bean.QuestionBeans.OptionsQuestionBean;
import com.engagepoint.model.OptionQuestionModel;
import com.engagepoint.model.VariantItem;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
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
    private QuestionEditController questionEditController;
    private OptionsQuestionBean optionsQuestionBean;
    @Inject
    private OptionQuestionModel optionsQuestionModel;

    @PostConstruct
    public void postCostruct() {
        setOptionsQuestionBean((OptionsQuestionBean) questionEditController.getCurrentQuestion());
    }


    public OptionQuestionModel getOptionQuestionModel() {
        return optionsQuestionModel;
    }

    public void setOptionQuestionModel(OptionQuestionModel optionQuestionModel) {
        this.optionsQuestionModel = optionQuestionModel;
    }

    public OptionsQuestionBean getOptionsQuestionBean() {
        return optionsQuestionBean;
    }

    public void setOptionsQuestionBean(OptionsQuestionBean optionsQuestionBean) {
        this.optionsQuestionBean = optionsQuestionBean;
        init(optionsQuestionBean);
    }

    public void init(OptionsQuestionBean optionsQuestionBean) {
        optionsQuestionModel = new OptionQuestionModel(optionsQuestionBean);
    }

    public void addOption(String option) {
        optionsQuestionModel.addOption(new VariantItem(option));
    }

    public void removeOption(String option) {
        optionsQuestionModel.removeOption(new VariantItem(option));
    }

    public String saveQuestion() {
        optionsQuestionBean.setOptions(optionsQuestionModel.getOptions());
        optionsQuestionBean.setDefaultOption(optionsQuestionModel.getDefaultOption());
        questionEditController.setCurrentQuestion(optionsQuestionBean);
        questionEditController.addQuestionToTree();
        return "/pages/questForm?faces-redirect=true";
    }
}
