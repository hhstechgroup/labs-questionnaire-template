package com.engagepoint.model;

import com.engagepoint.bean.QuestionBeans.OptionsQuestionBean;
import com.engagepoint.model.TableModels.ListOfOptionsDataModel;


import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//model for question with options
@Named("optionsQuestionModel")
@SessionScoped
public class OptionQuestionModel implements Serializable {

    //dataModel for table
    private ListOfOptionsDataModel dataModel;
    //list of variants
    private List<VariantItem> options;
    //selected variants
    private List<VariantItem> defaultOptions;
    //selected variant
    private String defaultOption;

    public OptionQuestionModel() {
        this.options = new ArrayList<VariantItem>();
        options.add(new VariantItem("Option 1"));
        options.add(new VariantItem("Option 2"));
        options.add(new VariantItem("Option 3"));
        options.add(new VariantItem("Option 4"));
        updateModel();
    }

    public OptionQuestionModel(OptionsQuestionBean optionsQuestionBean) {
        setPropertiesFromBean(optionsQuestionBean);
    }

    public void setPropertiesFromBean(OptionsQuestionBean optionsQuestionBean) {
        this.options = optionsQuestionBean.getOptions();
        this.defaultOption = optionsQuestionBean.getDefaultOption();
        updateModel();
    }

    public List<VariantItem> getOptions() {
        return options;
    }

    public void setOptions(List<VariantItem> options) {
        this.options = options;
    }

    public List<VariantItem> getDefaultOptions() {
        return defaultOptions;
    }

    public void setDefaultOptions(List<VariantItem> defaultOptions) {
        this.defaultOptions = defaultOptions;
    }

    public String getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(String defaultOption) {
        this.defaultOption = defaultOption;
    }

    public ListOfOptionsDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(ListOfOptionsDataModel dataModel) {
        this.dataModel = dataModel;
    }

    //adding variants to dataModel
    public void updateModel() {
        if (dataModel == null) {
            dataModel = new ListOfOptionsDataModel(options);
        } else {
            dataModel.setWrappedData(options);
        }
    }

    public void addOption(VariantItem option) {
        this.options.add(option);
        updateModel();
    }

    public void removeOption(VariantItem option) {
        this.options.remove(option);
        updateModel();
    }
}
