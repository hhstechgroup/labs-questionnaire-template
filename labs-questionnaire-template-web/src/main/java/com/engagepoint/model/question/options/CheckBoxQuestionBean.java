package com.engagepoint.model.question.options;

import com.engagepoint.model.question.utils.VariantItem;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class CheckBoxQuestionBean extends OptionsQuestion {
    //selected variants
    private List<VariantItem> defaultOptions;

    @XmlElementWrapper(name = "default-options")
    @XmlElement(name = "default-option")
    public List<VariantItem> getDefaultOptions() {
        return defaultOptions;
    }

    public void setDefaultOptions(List<VariantItem> defaultOptions) {
        this.defaultOptions = defaultOptions;
    }

    @XmlElementWrapper(name = "checkboxes-options")
    @XmlElement(name = "option")
    @Override
    public List<VariantItem> getOptions() {
        return this.options;
    }

    @Override
    public void setOptions(List<VariantItem> options) {
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckBoxQuestionBean)) return false;
        if (!super.equals(o)) return false;

        CheckBoxQuestionBean that = (CheckBoxQuestionBean) o;

        if (!defaultOptions.equals(that.defaultOptions)) return false;
        if (!options.equals(that.options)) return false;

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
