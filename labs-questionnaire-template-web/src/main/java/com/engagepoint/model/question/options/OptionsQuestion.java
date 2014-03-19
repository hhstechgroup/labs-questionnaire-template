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
    //list of variants
    protected List<VariantItem> options;
    //selected variant for multiple choice,grid,choose from list question.
    protected VariantItem defaultOption;
    private static final Logger LOG = Logger.getLogger(OptionsQuestion.class);

    public OptionsQuestion() {
        super();
        this.options = new ArrayList<VariantItem>();
        defaultOption = new VariantItem();
    }

    public OptionsQuestion(GroupBean groupBean) {
        super(groupBean);
        this.options = new ArrayList<VariantItem>();
        defaultOption = new VariantItem();
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
    public VariantItem getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(VariantItem defaultOption) {
        this.defaultOption = defaultOption;
    }

    @Override
    @XmlElementWrapper(name = "default-answers")
    @XmlElement(name = "default-answer")
    public List<String> getDefaultAnswers() {
        List<String> list = new ArrayList<String>();
        list.add(defaultOption.getValue());
        return list;
    }

    @Override
    public void setDefaultAnswers(List<String> list) {
        try {
            defaultOption = new VariantItem(list.get(0));
        }catch (StringIndexOutOfBoundsException e) {
            LOG.warn("String of default answer in XML is empty", e);
        }
    }

    /**
     * For multiple choice,grid,choose from list question.
     */
    @XmlTransient
    public List<VariantItem> getDefaultOptions() {
        return new ArrayList<VariantItem>();
    }

    /**
     * For multiple choice,grid,choose from list question.
     */
    public void setDefaultOptions(List<VariantItem> defaultOptions) {
    }

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

        if (defaultOption != null ? !defaultOption.equals(that.defaultOption) : that.defaultOption != null){
            return false;
        }
        if (options != null ? !options.equals(that.options) : that.options != null){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (options != null ? options.hashCode() : 0);
        result = 31 * result + (defaultOption != null ? defaultOption.hashCode() : 0);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        OptionsQuestion copy = (OptionsQuestion) super.clone();
        copy.setOptions(this.options);
        copy.setDefaultOption(this.defaultOption);
        return copy;
    }
}