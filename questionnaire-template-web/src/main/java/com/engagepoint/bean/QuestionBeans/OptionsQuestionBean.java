package com.engagepoint.bean.QuestionBeans;

import com.engagepoint.bean.QuestionBeans.QuestionBean;
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
    private String defaultOption;

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

    public String getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(String defaultOption) {
        this.defaultOption = defaultOption;
    }
}
