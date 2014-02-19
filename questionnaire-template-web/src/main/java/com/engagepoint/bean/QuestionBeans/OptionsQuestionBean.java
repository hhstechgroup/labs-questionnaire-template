package com.engagepoint.bean.QuestionBeans;

import com.engagepoint.model.VariantItem;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("optionsQuestionBean")
@RequestScoped
public class OptionsQuestionBean extends QuestionBean implements Serializable {
    private List<VariantItem> options;
    private VariantItem defaultOption;

    public OptionsQuestionBean() {
        options = new ArrayList<VariantItem>();
        options.add(new VariantItem("1 option"));
        options.add(new VariantItem("2 option"));
    }

    public List<VariantItem> getOptions() {
        return options;
    }

    public void setOptions(List<VariantItem> options) {
        this.options = options;
    }

    public VariantItem getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(VariantItem defaultOption) {
        this.defaultOption = defaultOption;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        OptionsQuestionBean copy = (OptionsQuestionBean) super.clone();
        copy.setOptions(this.options);
        copy.setDefaultOption(this.defaultOption);
        return copy;
    }

}
