package com.engagepoint.model.question.options;

import com.engagepoint.model.question.utils.VariantItem;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Created by yaroslav on 3/5/14.
 */
public class CheckBoxQuestionBean extends OptionsQuestionBean {
    //selected variants
    private List<VariantItem> defaultOptions;

    @XmlElement(name = "default-option")
    @XmlElementWrapper(name = "default-options")
    public List<VariantItem> getDefaultOptions() {
        return defaultOptions;
    }

    public void setDefaultOptions(List<VariantItem> defaultOptions) {
        this.defaultOptions = defaultOptions;
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
