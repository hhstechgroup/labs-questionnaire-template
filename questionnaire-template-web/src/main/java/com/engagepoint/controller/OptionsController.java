package com.engagepoint.controller;

import com.engagepoint.model.OptionDataModel;
import org.primefaces.event.RowEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: anna.zagrebelnaya
 * Date: 2/17/14
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Named
@SessionScoped
public class OptionsController {
    private List<String> options;
    private String defaultOption;
    private List<String> defaultOptions;
    private OptionDataModel dataModel;

    public OptionsController() {
        if (options==null) {
            options = new ArrayList<String>();
            this.options.add("First option");
            this.options.add("Second option");
        }
        dataModel = new OptionDataModel(options);
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
        dataModel = new OptionDataModel(options);
    }

    public String getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(String defaultOption) {
        this.defaultOption = defaultOption;
    }

    public List<String> getDefaultOptions() {
        return defaultOptions;
    }

    public void setDefaultOptions(List<String> defaultOptions) {
        this.defaultOptions = defaultOptions;
    }

    public OptionDataModel getDataModel() {
        dataModel = new OptionDataModel(options);
        return dataModel;
    }

    public void setDataModel(OptionDataModel dataModel) {
        this.dataModel = dataModel;
    }

    public void addOption(String option) {
        this.options.add(option);
    }

    public void removeOption(String option) {
        this.options.remove(option);
    }

    public void onEdit(RowEditEvent event) {
        String curOption = (String) event.getObject();
        FacesMessage msg = new FacesMessage("Option Edited", curOption);

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
