package com.engagepoint.controller.question;


import com.engagepoint.controller.page.TemplateEditController;
import com.engagepoint.model.question.*;
import com.engagepoint.controller.page.QuestionEditController;
import com.engagepoint.model.question.options.CheckBoxQuestionBean;
import com.engagepoint.model.question.options.ChooseFromListQuestionBean;
import com.engagepoint.model.question.options.MultipleChoiceQuestionBean;
import com.engagepoint.model.question.options.OptionsQuestionBean;
import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.questionnaire.QuestionType;
import com.engagepoint.model.table.ListOfOptionsDataModel;

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

    private OptionsQuestionBean currentQuestion;

    @Inject
    private TemplateEditController templateEditController;

    @Inject
    private Conversation conversation;

    public void beginConversation() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    public void endConversation() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    @PostConstruct
    public void postConstruct() {
        beginConversation();
        QuestionBean questionBean = getTemplateTreeController().getCurrentQuestion();
        if (questionBean==null) {
            setNew(true);
            createCurrentQuestion();
            dataModel = new ListOfOptionsDataModel();
        }
        else {
            currentQuestion = (OptionsQuestionBean) questionBean;
            dataModel = new ListOfOptionsDataModel(currentQuestion.getOptions());
        }
    }

    public ListOfOptionsDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(ListOfOptionsDataModel dataModel) {
        this.dataModel = dataModel;
    }

    public OptionsQuestionBean getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(OptionsQuestionBean currentQuestion) {
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
        }
        catch (ClassCastException e) {
            //TODO
        }
        getTemplateTreeController().setCurrentQuestion(currentQuestion);
        endConversation();
        return super.actionSave();
    }

    @Override
    public String actionCancel() {
        endConversation();
        return super.actionCancel();
    }

    private void createCurrentQuestion(){
        switch(templateEditController.getSelectedQuestionType()){
            case CHECKBOX:
                currentQuestion = new CheckBoxQuestionBean();
                break;
            case CHOOSEFROMLIST:
                currentQuestion = new ChooseFromListQuestionBean();
                break;
            case GRID:
                currentQuestion = new GridQuestionBean();
                break;
            case MULTIPLECHOICE:
                currentQuestion = new MultipleChoiceQuestionBean();
                break;
        }
        currentQuestion.setQuestionType(templateEditController.getSelectedQuestionType());
    }
}