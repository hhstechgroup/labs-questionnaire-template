package com.engagepoint.controller.pagecontroller;




import com.engagepoint.bean.QuestionBeans.OptionsQuestionBean;
import com.engagepoint.model.TableModels.ListOfOptionsDataModel;
import com.engagepoint.model.VariantItem;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Controller for multiplechoice,checkboxes and choose from a list question types.
 */
@Named
@RequestScoped
public class OptionsQuestionEditController implements Serializable {

    @Inject
    private QuestionEditController questionController;

    public OptionsQuestionBean getCurrentQuestion() {
        return (OptionsQuestionBean)this.questionController.getCurrentQuestion();
    }

    /**
     * Update options in ListOfOptionsDataModel.
     */
    private void updateModel() {
        getCurrentQuestion().getDataModel().setWrappedData(getCurrentQuestion().getOptions());
    }

    /**
     * Add variant to a question.
     *
     * @param option VariantItem object
     */
    public void addOption(String option) {
        getCurrentQuestion().getOptions().add(new VariantItem(option));
        updateModel();
    }

    /**
     * Remove variant from a question.
     *
     * @param option VariantItem object
     */
    public void removeOption(VariantItem option) {
        getCurrentQuestion().getOptions().remove(option);
        updateModel();
    }

    /**
     * Get chooseFromListQuestion page.
     *
     * @return chooseFromListQuestion page
     */
    public static String income() {
        return "/question-pages/chooseFromListQuestion?faces-redirect=true&includeViewParams=true";
    }
}
