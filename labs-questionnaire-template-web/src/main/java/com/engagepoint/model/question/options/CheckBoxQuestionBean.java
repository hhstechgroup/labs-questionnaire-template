package com.engagepoint.model.question.options;

import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "checkBoxQuestionBean", propOrder = {
        "id",
        "requiredAnswer",
        "questionText",
        "questionType",
        "rules",
        "helpText",
        "options",
        "defaultAnswers"
})
public class CheckBoxQuestionBean extends OptionsQuestion {
    //selected variants
    private List<VariantItem> defaultOptions;

    public CheckBoxQuestionBean() {
        defaultOptions = new ArrayList<VariantItem>();
    }

    public CheckBoxQuestionBean(GroupBean currentGroup) {
        super(currentGroup);
        defaultOptions = new ArrayList<VariantItem>();
    }

    @XmlTransient
    public List<VariantItem> getDefaultOptions() {
        return defaultOptions;
    }

    public void setDefaultOptions(List<VariantItem> defaultOptions) {
        this.defaultOptions = defaultOptions;
    }

    @Override
    public List<String> getDefaultAnswers() {
        List<String> list = new ArrayList<String>();
        for (VariantItem curOption : defaultOptions) {
            list.add(curOption.getValue());
        }
        return list;
    }

    @Override
    public void setDefaultAnswers(List<String> list) {
        defaultOptions = new ArrayList<VariantItem>();
        for (String curAnswer : list) {
            defaultOptions.add(new VariantItem(curAnswer));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CheckBoxQuestionBean)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CheckBoxQuestionBean that = (CheckBoxQuestionBean) o;
        if (!defaultOptions.equals(that.defaultOptions) && !options.equals(that.options)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + defaultOptions.hashCode();
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        CheckBoxQuestionBean copy = (CheckBoxQuestionBean) super.clone();
        copy.setDefaultOptions(this.defaultOptions);
        return copy;
    }
}
