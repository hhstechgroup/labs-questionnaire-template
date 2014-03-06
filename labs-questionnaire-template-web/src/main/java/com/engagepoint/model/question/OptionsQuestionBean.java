package com.engagepoint.model.question;

import com.engagepoint.model.table.ListOfOptionsDataModel;
import com.engagepoint.model.question.utils.VariantItem;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

public abstract class OptionsQuestionBean extends QuestionBean implements Cloneable {

    //list of variants
    protected List<VariantItem> options;



    public OptionsQuestionBean() {
        this.options = new ArrayList<VariantItem>();
    }

    @XmlElementWrapper(name = "options")
    @XmlElement(name = "option")
    public List<VariantItem> getOptions() {
        return options;
    }

    public void setOptions(List<VariantItem> options) {
        this.options = options;
    }


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


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof OptionsQuestionBean)) return false;
//        if (!super.equals(o)) return false;
//
//        OptionsQuestionBean that = (OptionsQuestionBean) o;
//
//        if (!defaultOption.equals(that.defaultOption)) return false;
//        if (!defaultOptions.equals(that.defaultOptions)) return false;
//        if (!options.equals(that.options)) return false;
//
//        return true;
//    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + options.hashCode();
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        OptionsQuestionBean copy = (OptionsQuestionBean) super.clone();
        copy.setOptions(this.options);
        return copy;
    }


}