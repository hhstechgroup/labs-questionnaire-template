package com.engagepoint.model.question;

import com.engagepoint.model.table.ListOfOptionsDataModel;
import com.engagepoint.model.question.utils.VariantItem;

import java.util.ArrayList;
import java.util.List;

public class OptionsQuestionBean extends QuestionBean {
    //dataModel for table
    private ListOfOptionsDataModel dataModel;
    //list of variants
    private List<VariantItem> options;
    //selected variants
    private List<VariantItem> defaultOptions;
    //selected variant
    private VariantItem defaultOption;

    public OptionsQuestionBean() {
        this.options = new ArrayList<VariantItem>();
        dataModel = new ListOfOptionsDataModel(options);
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

    public VariantItem getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(VariantItem defaultOption) {
        this.defaultOption = defaultOption;
    }

    public ListOfOptionsDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(ListOfOptionsDataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        OptionsQuestionBean copy = (OptionsQuestionBean) super.clone();
        copy.setOptions(this.options);
        copy.setDefaultOption(this.defaultOption);
        return copy;
    }
}