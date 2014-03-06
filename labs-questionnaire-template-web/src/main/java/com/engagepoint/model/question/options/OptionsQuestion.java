package com.engagepoint.model.question.options;

import com.engagepoint.model.question.QuestionBean;
import com.engagepoint.model.question.utils.VariantItem;

import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlSeeAlso({CheckBoxQuestionBean.class, ChooseFromListQuestionBean.class, MultipleChoiceQuestionBean.class, GridQuestionBean.class})
public abstract class OptionsQuestion extends QuestionBean implements Cloneable {
    //list of variants
    protected List<VariantItem> options;

    public OptionsQuestion() {
        this.options = new ArrayList<VariantItem>();
    }

    public abstract List<VariantItem> getOptions();

    public abstract void setOptions(List<VariantItem> options);


    public VariantItem getDefaultOption() {
        //NOP
        return null;
    }

    public void setDefaultOption(VariantItem defaultOption) {
        //NOP
    }

    public List<VariantItem> getDefaultOptions() {
        //NOP
        return null;
    }

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