package com.engagepoint.controller.question;


import com.engagepoint.controller.page.TemplateEditController;
import com.engagepoint.model.question.*;
import com.engagepoint.controller.page.QuestionEditController;
import com.engagepoint.model.question.options.*;
import com.engagepoint.model.question.rules.Rule;
import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.table.ListOfOptionsDataModel;
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;

/**
 * Controller for multiplechoice,checkboxes and choose from a list question types.
 */
@Named
@ConversationScoped
public class OptionsQuestionEditController extends QuestionEditController {

    //dataModel for table
    private ListOfOptionsDataModel dataModel;

    private OptionsQuestion currentQuestion;

    @Inject
    private TemplateEditController templateEditController;

    private static final Logger LOG = Logger.getLogger(OptionsQuestionEditController.class);

    @PostConstruct
    public void postConstruct() {
        beginConversation();
        Question question = getTemplateTreeController().getCurrentQuestion();
        if (question == null) {
            setNew(true);
            createCurrentQuestion();
            dataModel = new ListOfOptionsDataModel();
        } else {
            currentQuestion = (OptionsQuestion) question;
            dataModel = new ListOfOptionsDataModel(currentQuestion.getOptions());
        }
        currentQuestionEventNew.fire(currentQuestion);
    }

    public ListOfOptionsDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(ListOfOptionsDataModel dataModel) {
        this.dataModel = dataModel;
    }

    public OptionsQuestion getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(OptionsQuestion currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    /**
     * Update options in ListOfOptionsDataModel.
     */
    private void updateModel() {
        getDataModel().setWrappedData(getCurrentQuestion().getOptions());
    }

    /**
     * Add variant to a question.
     *
     * @param option VariantItem object
     */
    public void addOption(String option) {
        getCurrentQuestion().getOptions().add(new VariantItem("New"));
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

    @Override
    public String actionSave() {
        try {
            currentQuestion.setOptions((ArrayList<VariantItem>) dataModel.getWrappedData());
        } catch (ClassCastException e) {
            LOG.error("Class cast Exception", e);
        }
        getTemplateTreeController().setCurrentQuestion(currentQuestion);
        return super.actionSave();
    }

    private void createCurrentQuestion() {
        switch (templateEditController.getSelectedQuestionType()) {
            case CHECKBOX:
                currentQuestion = new CheckBoxQuestionBean(getTemplateTreeController().getCurrentGroup());
                break;
            case CHOOSEFROMLIST:
                currentQuestion = new ChooseFromListQuestionBean(getTemplateTreeController().getCurrentGroup());
                break;
            case MULTIPLECHOICE:
                currentQuestion = new MultipleChoiceQuestionBean(getTemplateTreeController().getCurrentGroup());
                break;
        }
        currentQuestion.setQuestionType(templateEditController.getSelectedQuestionType());
    }

}