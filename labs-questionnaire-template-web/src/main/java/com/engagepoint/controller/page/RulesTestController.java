package com.engagepoint.controller.page;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.engagepoint.controller.utils.PageNavigator;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.rules.Rule;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.SectionBean;
import com.engagepoint.model.questionnaire.TemplateBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Named
@ConversationScoped
public class RulesTestController implements Serializable {


    private List<Question> questionsList;

    @Inject
    Conversation conversation;

    @Inject
    ListController listController;

    private Map<Question, List<Long>> dependencies;
    private Map<Question, String> styles;

    @PostConstruct
    public void postconstruct() {
        conversation.begin();
        prepareQuestionList();
        prepareDependencies();
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    public ListController getListController() {
        return listController;
    }

    public void setListController(ListController listController) {
        this.listController = listController;
    }

    public Map<Question, List<Long>> getDependencies() {
        return dependencies;
    }

    public void setDependencies(Map<Question, List<Long>> dependencies) {
        this.dependencies = dependencies;
    }

    /**
     * build a list of all questions from current template
     */
    private void prepareQuestionList() {
        if (listController.getCurrentTemplate() != null) {
            questionsList = new ArrayList<Question>();
            for (SectionBean s : listController.getCurrentTemplate().getSectionsList()) {
                for (GroupBean gr : s.getGroupsList()) {
                    questionsList.addAll(gr.getQuestionsList());
                }
            }
        }
    }

    /**
     * build a map of dependencies which contains question element
     * and a list of questions ids that are dependent on this question
     */
    private void prepareDependencies() {
        dependencies = new HashMap<Question, List<Long>>();
        for (Question quest : questionsList) {
            if ((quest.getRules() != null) && (!quest.getRules().isEmpty())) {
                for (Rule r : quest.getRules()) {
                    Question parent = getQuestionById(r.getId());
                    if (dependencies.get(parent) == null) {
                        dependencies.put(parent, new ArrayList<Long>());
                    }
                    dependencies.get(parent).add(quest.getId());
                }
            }
        }
    }

    /**
     * get a question object with specified ID
     *
     * @param id
     * @return
     */
    private Question getQuestionById(Long id) {
        for (Question quest : questionsList) {
            if (quest.getId() == id) {
                return quest;
            }
        }
        return null;
    }


    /**
     * Get page name and perform redirect.
     *
     * @return page name
     */
    public static String income() {
        return PageNavigator.RULES_TEST_PAGE;
    }

    /**
     * close current conversation and go back to index
     *
     * @return
     */
    public String backToIndex() {
        conversation.end();
        return PageNavigator.INDEX_PAGE;
    }

    /**
     * TODO TEMP method for development phase, will
     *
     * @param q
     * @return
     */

    public String getDependentByQuestion(Question q) {
        List<Long> result = dependencies.get(q);
        if (result == null) {
            return "";
        }
        return result.toString();
    }

    /**
     * get String style for current Question to use in style field on page
     *
     * @param q
     * @return
     */
    public String getStyle(Question q) {

        if (styles != null && styles.get(q) != null) {
            return "background-color: " + styles.get(q) + ";color: white;";
        }
        return "";
    }


    /**
     * set style green for this question and red for depended questions
     *
     * @param q
     */
    public void setStyles(Question q) {
        styles = new HashMap<Question, String>();
        styles.put(q, "green");
        for (Long l : dependencies.get(q)) {
            styles.put(getQuestionById(l), "red");
        }
    }
}
