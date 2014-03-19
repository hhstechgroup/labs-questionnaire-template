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
import org.apache.log4j.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.*;

/**
 * Controller for question rules.
 */
@Named
@SessionScoped
public class QuestionRuleController extends RuleController implements Serializable {
    @Inject
    private TemplateEditController templateEditController;
    @Inject
    private TemplateTreeController templateTreeController;
    //dependent question data
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
    private Rule currentRule;
    private List<Rule> currentRules;
    private Question currentQuestion;
    //logger

    private static final Logger LOG = Logger.getLogger(QuestionRuleController.class);

    public QuestionRuleController() {
        rulesContainer = new RulesContainer();
        addRuleButtonIsVisible = true;
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
                answer = DateQuestionBean.DATE_FORMAT.format(getDateData());
                break;
            case RANGE:
                answer = (new RangeItem(getMinValue(), getMaxValue())).toString();
                break;
            case TIME:
                answer = DateQuestionBean.TIME_FORMAT.format(getDateData());
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
                for (VariantItem item : getDefaultOptions()) {
                    answers.add(item.getValue());
                }
                break;
            default:
        }
        answers.add(answer);
        //save rule for question
        if (templateTreeController.getSelectedType().equals("question")) {
            setAnswerAndIdToRule(answers);
        }
        //save rule for group
        if (templateTreeController.getSelectedType().equals("group")) {
            GroupBean groupBean = (GroupBean) templateTreeController.getSelectedNode().getData();
            groupBean.getRules().add(createRuleObject(answers));
            setCurrentRules(groupBean.getRules());
        }
        //save rule for section
        if (templateTreeController.getSelectedType().equals("section")) {
            SectionBean sectionBean = (SectionBean) templateTreeController.getSelectedNode().getData();
            sectionBean.getRules().add(createRuleObject(answers));
            setCurrentRules(sectionBean.getRules());
        }
        setChooseDependentQuestionListVisible(false);
        setCancelRuleEditionButtonIsVisible(false);
        setAddRulesTableIsVisible(false);
        setAddRuleButtonIsVisible(true);
    }

    /**
     * Create rule object.
     *
     * @param answers answers for rule.
     * @return
     */
    private RenderedRule createRuleObject(List<String> answers) {
        RenderedRule renderedRule = (RenderedRule) currentRule;
        renderedRule.setAnswers(answers);
        renderedRule.setId(dependentQuestion.getId());
        return renderedRule;
    }

    /**
     * Action on click Set Answer button.
     */
    public void setDependentQuestionAnswer() {

        switch (dependentQuestion.getQuestionType()) {
            case TEXT:
                setTextQuestionBean((TextQuestionBean) dependentQuestion);
                break;
            case DATE:
                setDateQuestionBean((DateQuestionBean) dependentQuestion);
                break;
            case RANGE:
                setRangeQuestionBean((RangeQuestionBean) dependentQuestion);
                break;
            case TIME:
                setDateQuestionBean((DateQuestionBean) dependentQuestion);
                break;
            case PARAGRAPHTEXT:
                setTextQuestionBean((TextQuestionBean) dependentQuestion);
                break;
            case CHOOSEFROMLIST:
                setOptionsQuestion((ChooseFromListQuestionBean) dependentQuestion);
                setDataModel(new ListOfOptionsDataModel(getOptionsQuestion().getOptions()));
                break;
            case MULTIPLECHOICE:
                setOptionsQuestion((MultipleChoiceQuestionBean) dependentQuestion);
                setDataModel(new ListOfOptionsDataModel(getOptionsQuestion().getOptions()));
                break;
            case CHECKBOX:
                setOptionsQuestion((CheckBoxQuestionBean) dependentQuestion);
                setDataModel(new ListOfOptionsDataModel(getOptionsQuestion().getOptions()));
                break;
            case GRID:
                break;
            default:
        }
    }

    /**
     * Get all questions from current template.
     *
     * @return list of questions.
     */
    public List<Question> getQuestions() {
        List<Question> list = new ArrayList<Question>();
        for (SectionBean sectionBean : templateEditController.getCurrentTemplate().getSectionsList()) {
            for (GroupBean groupBean : sectionBean.getGroupsList()) {
                for (Question question : groupBean.getQuestionsList()) {
                    list.add(question);
                }
            }
        }
        return list;
    }

    public List<Question> getQuestionsForRule(){
        List<Question> list = new ArrayList<Question>();
        for (Question question : getQuestions()){
            if(currentQuestion.getId().equals(question.getId()))
                break;
            list.add(question);
        }

        return list;
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
                            dependentQuestion = question;
                            return question.getQuestionType().toString();
                        }
                    }
                }
            }
        }
        return "question type is not chose";
    }

    public List<Rule> getCurrentRules() {
        if (templateTreeController.getSelectedType().equals("section")) {
            currentRules = ((SectionBean) templateTreeController.getSelectedNode().getData()).getPageRules();
        }
        if (templateTreeController.getSelectedType().equals("group")) {
            currentRules = ((GroupBean) templateTreeController.getSelectedNode().getData()).getGroupRules();
        }
        return currentRules;
    }

    public void setCurrentRules(List<Rule> rules) {
        currentRules = rules;
    }

    public void deleteRule(Rule rule) {
        List<Rule> list = getCurrentRules();
        if (list != null) {
            list.remove(rule);
        }
        setCurrentRules(list);
    }

    public void cancelAll() {
        currentRules = null;
        currentQuestion = null;
    }

    public List<Question> getAllQuestionsThatSetDependence() {
        List<Question> all = getQuestions();
        List<Question> questionsWithRules = getQuestionsWithRules();
        Set<String> idSet = new HashSet<String>();
        for (Question q : questionsWithRules) {
            for (Rule rule : q.getRules()) {
                idSet.add(rule.getId());
            }
        }
        List<Question> result = new ArrayList<Question>();
        for (Question q : all) {
            if (idSet.contains(q.getId())) {
                result.add(q);
            }
        }
        return result;
    }

    public List<Question> getDependentQuestions(Question question) {
        if (question == null) {
            return new ArrayList<Question>();
        }
        List<Question> questionsWithRules = getQuestionsWithRules();
        List<Question> result = new ArrayList<Question>();
        for (Question q : questionsWithRules) {
            for (Rule rule : q.getRules()) {
                if (rule.getId().equals(question.getId())) {
                    result.add(q);
                    break;
                }
            }
        }
        return result;
    }

    public List<Question> getQuestionsWithRules() {
        List<Question> all = getQuestions();
        List<Question> result = new ArrayList<Question>();
        for (Question question : all) {
            if ((question.getRules() != null) && (!question.getRules().isEmpty())) {
                result.add(question);
            }
        }
        return result;
    }

    private void setAnswerAndIdToRule(List<String> answers) {
        switch (currentRule.getType()) {
            case RENDERED:
                RenderedRule renderedRule = (RenderedRule) currentRule;
                renderedRule.setAnswers(answers);
                renderedRule.setId(dependentQuestion.getId());
                break;
            default:
        }
        List<Rule> list = getCurrentRules();
        if (list != null) {
            list.add(currentRule);
        }
        setCurrentRules(list);
    }

    void saveRuleToQuestion(@Observes @SaveQuestion Question question) {
        question.setRules(currentRules);
        currentRules = null;
        currentQuestion = null;
    }

    void setCurrentQuestion(@Observes @NewQuestion Question question) {
        if(currentQuestion==null){
            currentQuestion = question;
        }
        currentRules = question.getRules();
        if (currentRules == null) {
            if (question.getRules().size() != 0) {
                currentRules = cloneRulesList(question.getRules());
            } else {
                currentRules = new ArrayList<Rule>();
            }
        }
    }

    List<Rule> cloneRulesList(List<Rule> input) {
        if (input == null) {
            return new ArrayList<Rule>();
        }
        List<Rule> result = new ArrayList<Rule>();
        try {
            for (Rule rule : input) {
                result.add((Rule) rule.clone());
            }
        } catch (CloneNotSupportedException e) {
            LOG.error("Clone Rule List Exception", e);
        }
        return result;
    }
}
