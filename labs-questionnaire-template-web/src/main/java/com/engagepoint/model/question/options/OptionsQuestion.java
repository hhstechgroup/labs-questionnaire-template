package com.engagepoint.model.question.options;

import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.questionnaire.GroupBean;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;

@XmlTransient
public abstract class OptionsQuestion extends Question implements Cloneable {

    private static final Logger LOG = Logger.getLogger(OptionsQuestion.class);

    //list of variants
    protected List<VariantItem> options;

    public OptionsQuestion() {
        super();
        this.options = new ArrayList<VariantItem>();
    }

    public OptionsQuestion(GroupBean groupBean) {
        super(groupBean);
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

    @XmlTransient
    public VariantItem getDefaultOption() {return null;}

    public void setDefaultOption(VariantItem defaultOption) {}

    /**
     * For multiple choice,grid,choose from list question.
     */
    @XmlTransient
    public List<VariantItem> getDefaultOptions() {return null;}

    /**
     * For multiple choice,grid,choose from list question.
     */
    public void setDefaultOptions(List<VariantItem> defaultOptions) {}

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        if (!super.equals(o)){
            return false;
        }

        OptionsQuestion that = (OptionsQuestion) o;

        if (options != null ? !options.equals(that.options) : that.options != null){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (options != null ? options.hashCode() : 0);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        OptionsQuestion copy = (OptionsQuestion) super.clone();
        copy.setOptions(this.options);
        return copy;
    }
}