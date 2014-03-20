package com.engagepoint.controller.page;


import com.engagepoint.model.question.DateQuestionBean;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.RangeQuestionBean;
import com.engagepoint.model.question.TextQuestionBean;
import com.engagepoint.model.question.options.CheckBoxQuestionBean;
import com.engagepoint.model.question.options.OptionsQuestion;
import com.engagepoint.model.question.rules.RenderedRule;
import com.engagepoint.model.question.rules.Rule;
import com.engagepoint.model.question.utils.QuestionAnswer;
import com.engagepoint.model.question.utils.RangeItem;
import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.SectionBean;
import com.engagepoint.model.table.ListOfOptionsDataModel;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Basic controller for setting answers
 */
public abstract class RuleController {
    @Inject
    protected TemplateTreeController templateTreeController;

    @Inject
    private TemplateEditController templateEditController;
    //question objects
    private OptionsQuestion optionsQuestion;
    private DateQuestionBean dateQuestionBean;
    private RangeQuestionBean rangeQuestionBean;
    private TextQuestionBean textQuestionBean;
    //for multiple,choose from list,checkbox
    private ListOfOptionsDataModel dataModel;
    private VariantItem defaultOption;
    private List<VariantItem> defaultOptions;
    //for paragraph,text
    private String textData;
    //for time,data
    private Date dateData;
    //for range
    private String minValue;
    private String maxValue;
    //
    private Question dependentQuestion;
    //dependent question data
    private String currentDependentQuestionId;

    protected QuestionAnswer answerForTests;

    RuleController() {
        //set questions
        optionsQuestion = new CheckBoxQuestionBean();
        dateQuestionBean = new DateQuestionBean();
        rangeQuestionBean = new RangeQuestionBean();
        textQuestionBean = new TextQuestionBean();
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

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public void setDateData(Date dateData) {
        this.dateData = dateData;
    }

    public Date getDateData() {
        return dateData;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public Question getDependentQuestion() {
        return dependentQuestion;
    }

    public void setDependentQuestion(Question dependentQuestion) {
        this.dependentQuestion = dependentQuestion;
    }

    public String getCurrentDependentQuestionId() {
        return currentDependentQuestionId;
    }

    public void setCurrentDependentQuestionId(String currentDependentQuestionId) {
        this.currentDependentQuestionId = currentDependentQuestionId;
    }

    public TemplateEditController getTemplateEditController() {
        return templateEditController;
    }

    /**
     * Get current dependent question type.
     *
     * @return question type
     */
    public String getCurrentDependentQuestionType() {
        if (currentDependentQuestionId != null) {
            for (SectionBean sectionBean : templateEditController.getCurrentTemplate().getSectionsList()) {
                for (GroupBean groupBean : sectionBean.getGroupsList()) {
                    for (Question question : groupBean.getQuestionsList()) {
                        if (String.valueOf(question.getId()).equals(currentDependentQuestionId)) {
                            setDependentQuestion(question);
                            return question.getQuestionType().toString();
                        }
                    }
                }
            }
        }
        return "question type is not chose";
    }


    public void saveRuleAnswerAction() {
        answerForTests = new QuestionAnswer();
        switch (getDependentQuestion().getQuestionType()) {
            case TEXT:
                answerForTests.setAnswer(getTextData());
                break;
            case DATE:
                answerForTests.setAnswer(DateQuestionBean.DATE_FORMAT.format(getDateData()));
                break;
            case RANGE:
                answerForTests.setAnswer(new RangeItem(getMinValue(), getMaxValue()));
                break;
            case TIME:
                answerForTests.setAnswer(DateQuestionBean.TIME_FORMAT.format(getDateData()));
                break;
            case PARAGRAPHTEXT:
                answerForTests.setAnswer(getTextData());
                break;
            case CHOOSEFROMLIST:
                answerForTests.setAnswer(getDefaultOption());
                break;
            case MULTIPLECHOICE:
                answerForTests.setAnswer(getDefaultOption());
                break;
            case CHECKBOX:
                answerForTests.setAnswer(getDefaultOptions());
                break;
            default:
        }
    }
}
