package com.engagepoint.model.question.options;

import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "checkBoxQuestionBean", propOrder = {
        "id",
        "requiredAnswer",
        "questionText",
        "questionType",
        "questionRules",
        "helpText",
        "options",
        "defaultAnswers"
})
public class CheckBoxQuestionBean extends OptionsQuestion {

    public CheckBoxQuestionBean() {
        super();
    }

    public CheckBoxQuestionBean(GroupBean currentGroup) {
        super(currentGroup);
    }

    @XmlTransient
    public List<VariantItem> getDefaultOptions() {
        List<String> defaultAnswers = getDefaultAnswers();
        List<VariantItem> defaultOptions = new ArrayList<VariantItem>();
        for (String curAnswer : defaultAnswers) {
            defaultOptions.add(new VariantItem(curAnswer));
        }
        return defaultOptions;
    }

    public void setDefaultOptions(List<VariantItem> defaultOptions) {
        List<String> defaultAnswers = new ArrayList<String>();
        for (VariantItem curOption : defaultOptions) {
            defaultAnswers.add(curOption.getValue());
        }
        setDefaultAnswers(defaultAnswers);
    }
}
