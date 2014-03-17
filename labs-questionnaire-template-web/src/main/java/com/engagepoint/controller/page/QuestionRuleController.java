package com.engagepoint.controller.page;

import com.engagepoint.controller.utils.qualifiers.NewQuestion;
import com.engagepoint.controller.utils.qualifiers.SaveQuestion;
import com.engagepoint.model.question.DateQuestionBean;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.RangeQuestionBean;
import com.engagepoint.model.question.TextQuestionBean;
import com.engagepoint.model.question.options.CheckBoxQuestionBean;
import com.engagepoint.model.question.options.ChooseFromListQuestionBean;
import com.engagepoint.model.question.options.MultipleChoiceQuestionBean;
import com.engagepoint.model.question.options.OptionsQuestion;
import com.engagepoint.model.question.rules.RenderedRule;
import com.engagepoint.model.question.rules.Rule;
import com.engagepoint.model.question.rules.RulesContainer;
import com.engagepoint.model.question.utils.RangeItem;
import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.SectionBean;
import com.engagepoint.model.table.ListOfOptionsDataModel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

/**
 * Controller for question rules.
 */
@Named
@ConversationScoped
public class QuestionRuleController implements Serializable {
    @Inject
    private TemplateEditController templateEditController;
    @Inject
    private Conversation conversation;
    //dependent question data
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
    //question objects
    private OptionsQuestion optionsQuestion;
    private DateQuestionBean dateQuestionBean;
    private RangeQuestionBean rangeQuestionBean;
    private TextQuestionBean textQuestionBean;
    //question fileds
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


    private Rule currentRule;
    private List<Rule> currentRules;


    public QuestionRuleController() {
        rulesContainer = new RulesContainer();
        addRuleButtonIsVisible = true;
        //set questions
        optionsQuestion = new CheckBoxQuestionBean();
        dateQuestionBean = new DateQuestionBean();
        rangeQuestionBean = new RangeQuestionBean();
        textQuestionBean = new TextQuestionBean();
    }

    @PostConstruct
    public void init() {
        beginConversation();
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
    public void createRuleAction(String ruleName) {
        setAddRulesTableIsVisible(false);
        setChooseDependentQuestionListVisible(true);
        //currentRules.add(rulesContainer.createRule(ruleName));
        currentRule = rulesContainer.createRule(ruleName);
    }

    /**
     * Set elements visibility after save rule answer button was clicked.
     */
    public void saveRuleAnswerAction() {
        List<String> answers = new ArrayList<String>();
        String answer = null;
        switch (dependentQuestion.getQuestionType()) {
            case TEXT:
                answer = getTextData();
                break;
            case DATE:
                answer = getDateData().toString();
                break;
            case RANGE:
                answer = (new RangeItem(getMinValue(), getMaxValue())).toString();
                break;
            case TIME:
                answer = getTextData();
                break;
            case PARAGRAPHTEXT:
                answer = getTextData();
                break;
            case CHOOSEFROMLIST:
                answer = getDefaultOption().getValue();
                break;
            case MULTIPLECHOICE:
                answer = getDefaultOption().getValue();
                break;
            case CHECKBOX:
                for (VariantItem item : getDefaultOptions())
                    answers.add(item.getValue());
                break;
            case GRID:
                break;
        }

        if (answer != null)
            answers.add(answer);
        setAnswerAndIdToRule(answers);


        setChooseDependentQuestionListVisible(false);
        setCancelRuleEditionButtonIsVisible(false);
        setAddRulesTableIsVisible(false);
        setAddRuleButtonIsVisible(true);
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

    public List<Rule> getCurrentRules() {
        //return currentQuestion.getRules();
        //return rulesContainer.getRules();
        return currentRules;
    }

    public void setCurrentRules(List<Rule> rules) {
        currentRules = rules;
    }

    public void deleteRule(Rule rule) {
        List<Rule> list = getCurrentRules();
        if (list != null)
            list.remove(rule);
        setCurrentRules(list);
    }

    public void cancelAll() {
        currentRules = null;
        endConversation();
    }

    public List<Question> getAllQuestionsThatSetDependence(){
        List<Question> all = getQuestions();
        List<Question> questionsWithRules = getQuestionsWithRules();
        Set<String> idSet = new HashSet<String>();
        for(Question q : questionsWithRules){
            for(Rule rule : q.getRules()){
                idSet.add(rule.getId());
            }
        }
        List<Question> result = new ArrayList<Question>();
        for(Question q : all){
            if(idSet.contains(q.getId()))
                result.add(q);
        }

        return result;
    }

    public List<Question> getDependentQuestions(Question question){
        if(question==null)
            return null;
        List<Question> questionsWithRules = getQuestionsWithRules();
        List<Question> result = new ArrayList<Question>();
        for(Question q : questionsWithRules){
            for(Rule rule : q.getRules()){
                if(rule.getId().equals(question.getId())){
                    result.add(q);
                    break;
                }
            }
        }

        return result;
    }

    public List<Question> getQuestionsWithRules(){
        List<Question> all = getQuestions();
        List<Question> result = new ArrayList<Question>();
        for(Question question : all){
            if(question.getRules()!=null && ! question.getRules().isEmpty())
                result.add(question);
        }

        return result;
    }

    private void endConversation() {
        if (!conversation.isTransient())
            conversation.end();

    }

    private void beginConversation() {
        if (conversation.isTransient())
            conversation.begin();
    }

    private void saveRuleToQuestion(@Observes @SaveQuestion Question question) {
        //question.setRules(rulesContainer.getRules());
        question.setRules(currentRules);
        currentRules = null;

        //rulesContainer.setRules(null);
    }

    private void setAnswerAndIdToRule(List<String> answers) {

        switch (currentRule.getType()) {
            case RENDERED:
                RenderedRule renderedRule = (RenderedRule) currentRule;
                renderedRule.setAnswers(answers);
                renderedRule.setId(dependentQuestion.getId());
                break;
        }

        List<Rule> list = getCurrentRules();
        if (list != null)
            list.add(currentRule);
        setCurrentRules(list);
    }

    private void setCurrentQuestion(@Observes @NewQuestion Question question) {
        if (currentRules == null)
            if (question.getRules() != null)
                currentRules = cloneRulesList(question.getRules());
            else
                currentRules = new ArrayList<Rule>();
    }

    private List<Rule> cloneRulesList(List<Rule> input) {
        if (input == null)
            return null;
        List<Rule> result = new ArrayList<Rule>();
        try {
            for (Rule rule : input) {

                result.add((Rule) rule.clone());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
