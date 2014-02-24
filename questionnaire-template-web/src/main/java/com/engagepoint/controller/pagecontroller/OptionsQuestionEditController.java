package com.engagepoint.controller.pagecontroller;

import com.engagepoint.bean.QuestionBeans.OptionsQuestionBean;
import com.engagepoint.model.VariantItem;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Controller for multiplechoice,checkboxes and choose from a list question types.
 */
@Named
@ConversationScoped
public class OptionsQuestionEditController implements Serializable {

    @Inject
    private QuestionEditController questionEditController;
    @Inject
    private Conversation conversation;
    private OptionsQuestionBean optionQuestionBean;

    public OptionsQuestionEditController() {
        this.optionQuestionBean = new OptionsQuestionBean();
    }

    public OptionsQuestionBean getOptionQuestionBean() {
        return optionQuestionBean;
    }

    public void setOptionQuestionBean(OptionsQuestionBean optionQuestionBean) {
        this.optionQuestionBean = optionQuestionBean;
    }

    /**
     * Add variant to a question.
     *
     * @param option VariantItem object
     */
    public void addOption(String option) {
        optionQuestionBean.getOptions().add(new VariantItem(option));
        updateModel();
    }

    /**
     * Remove variant from a question.
     *
     * @param option VariantItem object
     */
    public void removeOption(VariantItem option) {
        optionQuestionBean.getOptions().remove(option);
        updateModel();
    }

    /**
     * Update options in ListOfOptionsDataModel.
     */
    private void updateModel() {
        optionQuestionBean.getDataModel().setWrappedData(optionQuestionBean.getOptions());
    }

    /**
     * Cancel question additing or edditing.
     *
     * @return next page to display.
     */
    public String actionCancel() {
        return TemplateEditController.income();
    }

    /**
     * Save question.
     *
     * @return next page to display.
     */
    public String actionSave() {
        //TODO
        questionEditController.addQuestionToTree();
        //end conversation
        endConversation();
        return TemplateEditController.income();
    }

    /**
     * Get chooseFromListQuestion page.
     *
     * @return chooseFromListQuestion page
     */
    public static String income() {
        return "/question-pages/chooseFromListQuestion?faces-redirect=true&includeViewParams=true";
    }

    /**
     * End conversation. After this bean will be destroyed.
     */
    public void endConversation() {
        conversation.end();
    }

    /**
     * Start conversation.Expands bean's scope over Request Scope.
     */
    public void initConversation() {
        if (!FacesContext.getCurrentInstance().isPostback()
                && conversation.isTransient()) {
            conversation.begin();
        }
    }
}
