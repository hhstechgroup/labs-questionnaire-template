package com.engagepoint.controller.page;

import com.engagepoint.controller.utils.PageNavigator;
import com.engagepoint.model.question.DateQuestionBean;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.RangeQuestionBean;
import com.engagepoint.model.question.TextQuestionBean;
import com.engagepoint.model.question.options.CheckBoxQuestionBean;
import com.engagepoint.model.question.options.ChooseFromListQuestionBean;
import com.engagepoint.model.question.options.MultipleChoiceQuestionBean;
import com.engagepoint.model.question.options.OptionsQuestion;
import com.engagepoint.model.question.rules.RulesContainer;
import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.SectionBean;
import com.engagepoint.model.table.ListOfOptionsDataModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for question rules.
 */
@Named
@SessionScoped
public class QuestionRuleController implements Serializable {
    @Inject
    private TemplateEditController templateEditController;
    //
    private String currentDependentQuestionId;
    private Question dependentQuestion;
    //contains all rules
    private RulesContainer rulesContainer;
    //show add rule button
    private boolean addRuleButtonIsVisible;
    //show cancel rule edition button
    private boolean cancelRuleEditionButtonIsVisible;
    //show rules table
    private boolean addRulesTableIsVisible;
    //show question id list
    private boolean chooseDependentQuestionListVisible;
    //for multiple,choose from list,checkbox
    private ListOfOptionsDataModel dataModel;
    //question objects
    private OptionsQuestion optionsQuestion;
    private DateQuestionBean dateQuestionBean;
    private RangeQuestionBean rangeQuestionBean;
    private TextQuestionBean textQuestionBean;

    public QuestionRuleController() {
        rulesContainer = new RulesContainer();
        addRuleButtonIsVisible = true;
        //set questions
        optionsQuestion = new CheckBoxQuestionBean();
        dateQuestionBean = new DateQuestionBean();
        rangeQuestionBean = new RangeQuestionBean();
        textQuestionBean = new TextQuestionBean();
    }

    public String getCurrentDependentQuestionId() {
        return currentDependentQuestionId;
    }

    public void setCurrentDependentQuestionId(String currentDependentQuestionId) {
        this.currentDependentQuestionId = currentDependentQuestionId;
    }

    public Question getDependentQuestion() {
        return dependentQuestion;
    }

    public void setDependentQuestion(Question dependentQuestion) {
        this.dependentQuestion = dependentQuestion;
    }

    public RulesContainer getRulesContainer() {
        return rulesContainer;
    }

    public void setRulesContainer(RulesContainer rulesContainer) {
        this.rulesContainer = rulesContainer;
    }

    public boolean isAddRulesTableIsVisible() {
        return addRulesTableIsVisible;
    }

    public void setAddRulesTableIsVisible(boolean addRulesTableIsVisible) {
        this.addRulesTableIsVisible = addRulesTableIsVisible;
    }

    public boolean isCancelRuleEditionButtonIsVisible() {
        return cancelRuleEditionButtonIsVisible;
    }

    public void setCancelRuleEditionButtonIsVisible(boolean cancelRuleEditionButtonIsVisible) {
        this.cancelRuleEditionButtonIsVisible = cancelRuleEditionButtonIsVisible;
    }

    public boolean isAddRuleButtonIsVisible() {
        return addRuleButtonIsVisible;
    }

    public void setAddRuleButtonIsVisible(boolean addRuleButtonIsVisible) {
        this.addRuleButtonIsVisible = addRuleButtonIsVisible;
    }

    public boolean isChooseDependentQuestionListVisible() {
        return chooseDependentQuestionListVisible;
    }

    public void setChooseDependentQuestionListVisible(boolean chooseDependentQuestionListVisible) {
        this.chooseDependentQuestionListVisible = chooseDependentQuestionListVisible;
    }

    public ListOfOptionsDataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(ListOfOptionsDataModel dataModel) {
        this.dataModel = dataModel;
    }

    public void setOptionsQuestion(OptionsQuestion optionsQuestion) {
        this.optionsQuestion = optionsQuestion;
    }

    public OptionsQuestion getOptionsQuestion() {
        return this.optionsQuestion;
    }

    public void setDateQuestionBean(DateQuestionBean dateQuestionBean) {
        this.dateQuestionBean = dateQuestionBean;
    }

    public DateQuestionBean getDateQuestionBean() {
        return this.dateQuestionBean;
    }

    public void setRangeQuestionBean(RangeQuestionBean rangeQuestionBean) {
        this.rangeQuestionBean = rangeQuestionBean;
    }

    public RangeQuestionBean getRangeQuestionBean() {
        return this.rangeQuestionBean;
    }

    public void setTextQuestionBean(TextQuestionBean textQuestionBean) {
        this.textQuestionBean = textQuestionBean;
    }

    public TextQuestionBean getTextQuestionBean() {
        return this.textQuestionBean;
    }

    /**
     * Set elements visibility after add rule button was clicked.
     */
    public void addRuleAction() {
        setAddRuleButtonIsVisible(false);
        setCancelRuleEditionButtonIsVisible(true);
        setAddRulesTableIsVisible(true);
    }

    /**
     * Set elements visibility after cancel rule button was clicked.
     */
    public void cancelAddRuleAction() {
        setChooseDependentQuestionListVisible(false);
        setCancelRuleEditionButtonIsVisible(false);
        setAddRulesTableIsVisible(false);
        setAddRuleButtonIsVisible(true);
    }

    /**
     * Set elements visibility after create rule button was clicked.
     *
     * @param ruleName
     */
    public void createRule(String ruleName) {
        setAddRulesTableIsVisible(false);
        setChooseDependentQuestionListVisible(true);
    }

    /**
     * Action on click Set Answer button.
     */
    public void setDependentQuestionAnswer() {
        switch (dependentQuestion.getQuestionType()) {
            case TEXT:
                textQuestionBean = (TextQuestionBean) dependentQuestion;
                break;
            case DATE:
                dateQuestionBean = (DateQuestionBean) dependentQuestion;
                break;
            case RANGE:
                rangeQuestionBean = (RangeQuestionBean) dependentQuestion;
                break;
            case TIME:
                dateQuestionBean = (DateQuestionBean) dependentQuestion;
                break;
            case PARAGRAPHTEXT:
                textQuestionBean = (TextQuestionBean) dependentQuestion;
                break;
            case CHOOSEFROMLIST:
                optionsQuestion = (ChooseFromListQuestionBean) dependentQuestion;
                dataModel = new ListOfOptionsDataModel(optionsQuestion.getOptions());
                break;
            case FILEUPLOAD:
                break;
            case MULTIPLECHOICE:
                optionsQuestion = (MultipleChoiceQuestionBean) dependentQuestion;
                dataModel = new ListOfOptionsDataModel(optionsQuestion.getOptions());
                break;
            case CHECKBOX:
                optionsQuestion = (CheckBoxQuestionBean) dependentQuestion;
                dataModel = new ListOfOptionsDataModel(optionsQuestion.getOptions());
                break;
            case GRID:
                break;
        }
    }

    /**
     * Get all questions from current template.
     *
     * @return list of questions.
     */
    public List<Question> getQuestions() {
        List<Question> list = new ArrayList<Question>();
        for (SectionBean sectionBean : templateEditController.getCurrentTemplate().getSectionsList())
            for (GroupBean groupBean : sectionBean.getGroupsList())
                for (Question question : groupBean.getQuestionsList())
                    list.add(question);
        return list;
    }

    /**
     * Get current dependent question type.
     *
     * @return question type
     */
    public String getCurrentDependentQuestionType() {
        if (currentDependentQuestionId != null) {
            for (SectionBean sectionBean : templateEditController.getCurrentTemplate().getSectionsList())
                for (GroupBean groupBean : sectionBean.getGroupsList())
                    for (Question question : groupBean.getQuestionsList())
                        if (String.valueOf(question.getId()).equals(currentDependentQuestionId)) {
                            dependentQuestion = question;
                            return question.getQuestionType().toString();
                        }
        }
        return "question type is not chose";
    }
}
