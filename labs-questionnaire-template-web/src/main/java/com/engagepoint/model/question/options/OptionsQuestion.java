package com.engagepoint.model.question.options;

import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.utils.VariantItem;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlSeeAlso({CheckBoxQuestionBean.class, ChooseFromListQuestionBean.class, MultipleChoiceQuestionBean.class, GridQuestionBean.class})
public abstract class OptionsQuestion extends Question implements Cloneable {
    //list of variants
    protected List<VariantItem> options;
    //selected variant for multiple choice,grid,choose from list question.
    protected VariantItem defaultOption;

    public OptionsQuestion() {
        this.options = new ArrayList<VariantItem>();
    }

    public abstract List<VariantItem> getOptions();

    public abstract void setOptions(List<VariantItem> options);

    @XmlElement(name = "default-option")
    public VariantItem getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(VariantItem defaultOption) {
        this.defaultOption = defaultOption;
    }

    /**
     * For multiple choice,grid,choose from list question.
     */
    public List<VariantItem> getDefaultOptions() {
        //NOP
        return null;
    }

    /**
     * For multiple choice,grid,choose from list question.
     */
    public void setDefaultOptions(List<VariantItem> defaultOptions) {
        //NOP
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + options.hashCode();
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        OptionsQuestion copy = (OptionsQuestion) super.clone();
        copy.setOptions(this.options);
        return copy;
    }
}