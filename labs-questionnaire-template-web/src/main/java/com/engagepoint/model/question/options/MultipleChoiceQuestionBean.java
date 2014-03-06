package com.engagepoint.model.question.options;

import com.engagepoint.model.question.utils.VariantItem;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by kostiantyn.ustinov on 3/6/14.
 */
public class MultipleChoiceQuestionBean extends OptionsQuestionBean {
    //selected variant
    private VariantItem defaultOption;

    @XmlElement(name = "default-option")
    public VariantItem getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(VariantItem defaultOption) {
        this.defaultOption = defaultOption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultipleChoiceQuestionBean)) return false;
        if (!super.equals(o)) return false;

        MultipleChoiceQuestionBean that = (MultipleChoiceQuestionBean) o;

        if (!defaultOption.equals(that.defaultOption)) return false;
        if (!options.equals(that.options)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + defaultOption.hashCode();
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        MultipleChoiceQuestionBean copy = (MultipleChoiceQuestionBean) super.clone();
        copy.setDefaultOption(this.defaultOption);
        return copy;
    }
}
