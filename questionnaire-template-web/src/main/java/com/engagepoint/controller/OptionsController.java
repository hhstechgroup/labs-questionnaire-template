package com.engagepoint.controller;

import com.engagepoint.model.OptionDataModel;
import com.engagepoint.model.VariantItem;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
/**
 * Controller for multiplechoice,checkboxes and choose from a list question types.
 */
public class OptionsController {
    //dataModel for table
    private OptionDataModel dataModel;
    //list of variants
    private List<VariantItem> options;
    //selected variant
    private VariantItem selectedOption;

    public OptionsController() {
        //creating list of variants
        options = new ArrayList<VariantItem>();
        options.add(new VariantItem("First option"));
        options.add(new VariantItem("Second option"));
        options.add(new VariantItem("Third option"));
        //adding variants to dataModel
        dataModel = new OptionDataModel(options);
    }

    public OptionDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(OptionDataModel dataModel) {
        this.dataModel = dataModel;
    }

    public VariantItem getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(VariantItem selectedOption) {
        this.selectedOption = selectedOption;
    }

    public List<VariantItem> getOptions() {
        return options;
    }

    public void setOptions(List<VariantItem> options) {
        this.options = options;
    }
}
