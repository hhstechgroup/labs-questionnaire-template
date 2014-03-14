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
	
	@PostConstruct
	public void postconstruct(){
		conversation.begin();
		prepareQuestionList();
		prepareDependencies();
	}

	private void prepareQuestionList() {
		if(listController.getCurrentTemplate()!=null){
			questionsList=new ArrayList<Question>();
			for(SectionBean s : listController.getCurrentTemplate().getSectionsList()){
				for(GroupBean gr : s.getGroupsList()){
					questionsList.addAll(gr.getQuestionsList());
				}
			}
		}
	}
	
	private void prepareDependencies() {
		dependencies = new HashMap<Question, List<Long>>();
		for (Question quest : questionsList) {
			if ((quest.getRules() != null) && (!quest.getRules().isEmpty())) {
				for (Rule r : quest.getRules()) {
					Question parent=getQuestionById(r.getId());
					if (dependencies.get(parent) == null) {
						dependencies.put(parent, new ArrayList<Long>());
					}
					dependencies.get(parent).add(quest.getId());
				}
			}
		}
	}
	
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

		
	public List<Question> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<Question> questionsList) {
		this.questionsList = questionsList;
	}
	
	public String backToIndex(){
		conversation.end();
		return PageNavigator.INDEX_PAGE;
	}
	
	public String getDependentByQuestion(Question q){
		List<Long> result=dependencies.get(q);
		if(result==null){
			return "NO";
		}
		return result.toString();
	}
	
	//TODO TEMP
	public String getAAA(){
		if(questionsList!=null)
			return ""+questionsList.size();
		return "NETY";
	}
	
	//TODO TEMP
	public String getBBB(){
		return ""+listController.getCurrentTemplate().getId();
	}

	public Map<Question, List<Long>> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Map<Question, List<Long>> dependencies) {
		this.dependencies = dependencies;
	}

}
