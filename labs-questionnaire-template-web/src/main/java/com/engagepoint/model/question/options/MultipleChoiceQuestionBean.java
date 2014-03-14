package com.engagepoint.model.question.options;

import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

public class MultipleChoiceQuestionBean extends OptionsQuestion {

    public MultipleChoiceQuestionBean() {
        super();
    }

    public MultipleChoiceQuestionBean(GroupBean groupBean) {
        super(groupBean);
    }

    @XmlElementWrapper(name = "multiple-choice-options")
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
        if (!(o instanceof MultipleChoiceQuestionBean)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        MultipleChoiceQuestionBean that = (MultipleChoiceQuestionBean) o;
        if (!defaultOption.equals(that.defaultOption)) {
            return false;
        }
        if (!options.equals(that.options)) {
            return false;
        }
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
