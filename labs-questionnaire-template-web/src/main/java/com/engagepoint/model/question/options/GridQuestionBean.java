package com.engagepoint.model.question.options;

import java.util.ArrayList;
import java.util.List;

import com.engagepoint.model.question.utils.VariantItem;

public class GridQuestionBean extends OptionsQuestionBean {

    //list of variants for second table
    private List<VariantItem> options2;
    /*//selected variants for second table
    private List<VariantItem> defaultOptions2; 	//TODO maybe only defaultOption2 is necessary
     */
    //selected variant for second table
    private VariantItem defaultOption2;        //TODO maybe only defaultOptions2 is necessary
    private VariantItem defaultOption;

    public GridQuestionBean() {
        this.options2 = new ArrayList<VariantItem>();
    }

    public List<VariantItem> getOptions2() {
        return options2;
    }

    @Override
    public List<VariantItem> getOptions() {
        return this.options;
    }

    @Override
    public void setOptions(List<VariantItem> options) {
        this.options = options;
    }

    @Override
    public VariantItem getDefaultOption() {
        return defaultOption;
    }

    @Override
    public void setDefaultOption(VariantItem defaultOption) {
        this.defaultOption = defaultOption;
    }

    public void setOptions2(List<VariantItem> options2) {
        this.options2 = options2;
    }

	/*public List<VariantItem> getDefaultOptions2() {
        return defaultOptions2;
	}

	public void setDefaultOptions2(List<VariantItem> defaultOptions2) {
		this.defaultOptions2 = defaultOptions2;
	}*/

    public VariantItem getDefaultOption2() {
        return defaultOption2;
    }

    public void setDefaultOption2(VariantItem defaultOption2) {
        this.defaultOption2 = defaultOption2;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        GridQuestionBean copy = (GridQuestionBean) super.clone();
        copy.setOptions2(this.options2);
        copy.setDefaultOption2(this.defaultOption2);
        copy.setDefaultOption(this.defaultOption);
        return copy;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GridQuestionBean)) return false;
        if (!super.equals(o)) return false;

        GridQuestionBean that = (GridQuestionBean) o;

        if (!defaultOption.equals(that.defaultOption)) return false;
        if (!options.equals(that.options)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + defaultOption.hashCode();
        result = 31 * result + defaultOption2.hashCode();
        return result;
    }

}
