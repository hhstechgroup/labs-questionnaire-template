package com.engagepoint.model.question;

import java.util.ArrayList;
import java.util.List;

import com.engagepoint.model.question.options.OptionsQuestionBean;
import com.engagepoint.model.question.utils.VariantItem;

public class GridQuestionBean extends OptionsQuestionBean {

    //list of variants for second table
    private List<VariantItem> options2;
    /*//selected variants for second table
    private List<VariantItem> defaultOptions2; 	//TODO maybe only defaultOption2 is necessary
     */
    //selected variant for second table
    private VariantItem defaultOption2;        //TODO maybe only defaultOptions2 is necessary

    public GridQuestionBean() {
        this.options2 = new ArrayList<VariantItem>();
    }

    public List<VariantItem> getOptions2() {
        return options2;
    }

    public void setOptions2(List<VariantItem> options2) {
        this.options2 = options2;
    }

    @Override
    public List<VariantItem> getOptions() {
        return null;
    }

    @Override
    public void setOptions(List<VariantItem> options) {

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
        return copy;
    }

}
