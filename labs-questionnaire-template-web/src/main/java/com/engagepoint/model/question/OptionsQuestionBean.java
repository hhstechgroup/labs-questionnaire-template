package com.engagepoint.model.question;

import com.engagepoint.model.table.ListOfOptionsDataModel;
import com.engagepoint.model.question.utils.VariantItem;

import java.util.ArrayList;
import java.util.List;

public class OptionsQuestionBean extends QuestionBean implements Cloneable {

    //list of variants
    private List<VariantItem> options;
    //selected variants
    private List<VariantItem> defaultOptions;
    //selected variant
    private VariantItem defaultOption;

    public OptionsQuestionBean() {
        this.options = new ArrayList<VariantItem>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OptionsQuestionBean)) return false;
        if (!super.equals(o)) return false;

        OptionsQuestionBean that = (OptionsQuestionBean) o;

        if (!defaultOption.equals(that.defaultOption)) return false;
        if (!defaultOptions.equals(that.defaultOptions)) return false;
        if (!options.equals(that.options)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + options.hashCode();
        result = 31 * result + defaultOptions.hashCode();
        result = 31 * result + defaultOption.hashCode();
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        OptionsQuestionBean copy = (OptionsQuestionBean) super.clone();
        copy.setOptions(this.options);
        copy.setDefaultOption(this.defaultOption);
        copy.setDefaultOptions(this.defaultOptions);
        return copy;
    }
}