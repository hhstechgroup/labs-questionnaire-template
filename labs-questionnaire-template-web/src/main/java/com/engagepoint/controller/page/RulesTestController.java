package com.engagepoint.controller.page;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.engagepoint.controller.utils.PageNavigator;
import com.engagepoint.model.question.rules.Rule;
import com.engagepoint.model.questionnaire.BasicBean;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.SectionBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@ConversationScoped
public class RulesTestController implements Serializable {
	
	private List<BasicBean> TemplateElementsList;
	private Map<BasicBean, List<BasicBean>> dependencies;
	private Map<BasicBean, String> styles;
	
	@Inject
	Conversation conversation;
	
	@Inject
	ListController listController;
	
	
	@PostConstruct
	public void postconstruct(){
		conversation.begin();
		prepareQuestionList();
		prepareDependencies();
	}

	
	public Map<BasicBean, List<BasicBean>> getDependencies() {
		return dependencies;
	}


	public void setDependencies(Map<BasicBean, List<BasicBean>> dependencies) {
		this.dependencies = dependencies;
	}


	public List<BasicBean> getTemplateElementsList() {
		return TemplateElementsList;
	}

	public void setTemplateElementsList(List<BasicBean> templateElementsList) {
		TemplateElementsList = templateElementsList;
	}

	public ListController getListController() {
		return listController;
	}

	public void setListController(ListController listController) {
		this.listController = listController;
	}

	
	/**
	 * build a list of all template elements from current template
	 */
	private void prepareQuestionList() {
		if(listController.getCurrentTemplate()!=null){
			TemplateElementsList=new ArrayList<BasicBean>();
			for(SectionBean s : listController.getCurrentTemplate().getSectionsList()){
				TemplateElementsList.add(s);
				for(GroupBean gr : s.getGroupsList()){
					TemplateElementsList.add(gr);
					TemplateElementsList.addAll(gr.getQuestionsList());
				}
			}
		}
	}
	
	
	/**
	 * prepare a String presentation of Template element to display in table 
	 * 
	 * @param bb
	 * @return
	 */
	public String displayTemplateElement(BasicBean bb){
		String result = bb.getId();						//TODO change to element name

        String s = bb.getType();
        if (s.equals("section")) {
            return result;
        } else if (s.equals("group")) {
            return "___" + result;
        } else if (s.equals("question")) {
            return "______" + result;
        } else {
            return "";
        }
	}
	
	
	/**
	 * build a map of dependencies which contains template element 
	 * and a list of elements ids that are dependent on this question
	 */
	private void prepareDependencies() {
		dependencies = new HashMap<BasicBean, List<BasicBean>>();
		
		for (BasicBean bb : TemplateElementsList){
			if ((bb.getRules() != null) && (!bb.getRules().isEmpty())) {
				for (Rule r : bb.getRules()) {
					BasicBean parent=getElementById(r.getId());
					if (dependencies.get(parent) == null) {
						dependencies.put(parent, new ArrayList<BasicBean>());
					}
					dependencies.get(parent).add(bb);
				}
			}
			
		}
	}
	
	/**
	 * get an Template element object with specified ID
	 * 
	 * @param id
	 * @return
	 */
	private BasicBean getElementById(String id) {
		for (BasicBean bb : TemplateElementsList) {
			if (bb.getId().equals(id)) {
				return bb;
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
	public String backToIndex(){
		conversation.end();
		return PageNavigator.INDEX_PAGE;
	}
	
	/**
	 * TODO TEMP method for development phase, will 
	 * 
	 * @param q
	 * @return
	 */
	
	public String getDependentByQuestion(BasicBean q){
		List<BasicBean> result=dependencies.get(q);
		if(result==null){
			return "";
		}
		
		String res="";
		
		for(BasicBean bb : result)
			res+=bb.getId()+" ";
		return res;
	}
	
	/**
	 * get String style for current Question to use in style field on page
	 * 
	 * @param q
	 * @return
	 */
	public String getStyle(BasicBean q){
		
		if (styles!=null && styles.get(q)!=null)
			return "background-color: "+styles.get(q)+";color: white;";
		return "";
	}
		
	/**
	 * set style green for this question and red for depended elements 
	 * 
	 * @param q
	 */
	public void setStyles(BasicBean basicBean){
		styles = new HashMap<BasicBean, String>();
		styles.put(basicBean, "green");
		setRedColour(basicBean);
	}
	
	private void setRedColour(BasicBean basicBean) {
		List<BasicBean> dependent = dependencies.get(basicBean);
		
		if (dependent != null) {
			for (int i = 0; i <= dependent.size(); i++) { // TODO SHOULD BE
															// TESTED!!!!
				BasicBean bb = dependent.get(i);
				if (bb.getType().equals("question")) {
					styles.put(bb, "red");
					setRedColour(bb);			//set Red to all dependent elements from this question
				} else if (bb.getType().equals("qroup")) {
					styles.put(bb, "red");
					i++;
					while (i != dependent.size() && dependent.get(i).getType().equals("question")) {
						styles.put(dependent.get(i), "red");
						setRedColour(dependent.get(i));
						i++;
					}
				} else if (bb.getType().equals("section")) {
					styles.put(bb, "red");
					i++;
					while (i!=dependent.size() && (dependent.get(i).getType().equals("group") || 
							dependent.get(i).getType().equals("question") )) {
						styles.put(dependent.get(i), "red");
						setRedColour(dependent.get(i));
						i++;
					}
				}
			}
		}
	}
	
}
