package com.engagepoint.bean.QuestionBeans;

import com.engagepoint.model.TableModels.ListOfOptionsDataModel;
import com.engagepoint.model.VariantItem;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("optionsQuestionModel")
@ConversationScoped
public class OptionsQuestionBean extends QuestionBean implements Serializable {
    private static final long serialVersionUID = 4771270804699990999L;

    //dataModel for table
    private ListOfOptionsDataModel dataModel;
    //list of variants
    private List<VariantItem> options;
    //selected variants
    private List<VariantItem> defaultOptions;
    //selected variant
    private VariantItem defaultOption;
    @Inject
    private Conversation conversation;

    @PostConstruct
    public void init() {
        this.options = new ArrayList<VariantItem>();
        dataModel = new ListOfOptionsDataModel(options);
        //conversation.begin();
    }

    public List<VariantItem> getOptions() {
        return options;
    }

    public void setOptions(List<VariantItem> options) {
        this.options = options;
    }

    public List<VariantItem> getDefaultOptions() {
        return defaultOptions;
    }

    public void setDefaultOptions(List<VariantItem> defaultOptions) {
        this.defaultOptions = defaultOptions;
    }

    public VariantItem getDefaultOption() {
        return defaultOption;
    }

    public void setDefaultOption(VariantItem defaultOption) {
        this.defaultOption = defaultOption;
    }

    public ListOfOptionsDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(ListOfOptionsDataModel dataModel) {
        this.dataModel = dataModel;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        OptionsQuestionBean copy = (OptionsQuestionBean) super.clone();
        copy.setOptions(this.options);
        copy.setDefaultOption(this.defaultOption);
        return copy;
    }


    public void removeQuestionBean() {
        conversation.end();
    }

    public void initConversation(){
        if (!FacesContext.getCurrentInstance().isPostback()
                && conversation.isTransient()) {

            System.out.println("sdfsdfs");
            conversation.begin(String.valueOf(this.getId()));
            //conversation
        }
    }

}
