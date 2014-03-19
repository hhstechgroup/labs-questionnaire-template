package com.engagepoint.controller.page;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.engagepoint.controller.utils.PageNavigator;
import com.engagepoint.model.question.rules.Rule;
import com.engagepoint.model.questionnaire.BasicBean;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.SectionBean;
import com.engagepoint.model.questionnaire.TemplateBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@SessionScoped
public class RulesTestController extends RuleController implements Serializable { 

	private List<BasicBean> templateElementsList;
	private Map<BasicBean, List<BasicBean>> dependencies;
	private Map<BasicBean, String> styles;

	private TemplateBean currentTemplate;
	
	public void resetRulerList(){
		prepareQuestionList();
		prepareDependencies();
		if(styles!=null)
			styles.clear();
	}
	

	public Map<BasicBean, List<BasicBean>> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Map<BasicBean, List<BasicBean>> dependencies) {
		this.dependencies = dependencies;
	}

	public List<BasicBean> getTemplateElementsList() {
		return templateElementsList;
	}

	public void setTemplateElementsList(List<BasicBean> templateElementsList) {
		this.templateElementsList = templateElementsList;
	}

	
	/**
	 * build a list of all template elements from current template
	 */
	private void prepareQuestionList() {
		if (currentTemplate != null) {
			templateElementsList = new ArrayList<BasicBean>();
			for (SectionBean s : currentTemplate.getSectionsList()) {
				templateElementsList.add(s);
				for (GroupBean gr : s.getGroupsList()) {
					templateElementsList.add(gr);
					templateElementsList.addAll(gr.getQuestionsList());
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
	public String displayTemplateElement(BasicBean bb) {
		String result = bb.getId(); // TODO change to element name

		String s = bb.getType();
		if ("section".equals(s)) {
			return result;
		} else if ("group".equals(s)) {
			return "___" + result;
		} else if ("question".equals(s)) {
			return "______" + result;
		} else {
			return "";
		}
	}

	/**
	 * build a map of dependencies which contains template element and a list of
	 * elements ids that are dependent on this question
	 */
	private void prepareDependencies() {
		dependencies = new HashMap<BasicBean, List<BasicBean>>();

		for (BasicBean bb : templateElementsList) {
			if ((bb.getRules() != null) && (!bb.getRules().isEmpty())) {
				for (Rule r : bb.getRules()) {
					BasicBean parent = getElementById(r.getId());
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
		for (BasicBean bb : templateElementsList) {
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
	 * TODO TEMP method for development phase, will
	 * 
	 * @param q
	 * @return
	 */

	public String getDependentByQuestion(BasicBean q) {
		List<BasicBean> result = dependencies.get(q);
		if (result == null) {
			return "";
		}

		String res = "";

		for (BasicBean bb : result){
			res += bb.getId() + " ";
        }
		return res;
	}

	/**
	 * get String style for current Question to use in style field on page
	 * 
	 * @param q
	 * @return
	 */
	public String getStyle(BasicBean q) {

		if (styles != null && styles.get(q) != null){
			return "background-color: " + styles.get(q) + ";color: white;";
        }
		return "";
	}

	/**
	 * set style green for this question and red for depended elements
	 * 
	 * @param
	 */
	public void setStyles(BasicBean basicBean) {
		styles = new HashMap<BasicBean, String>();
		styles.put(basicBean, "green");
		setRedColour(basicBean);
	}

	
	
	private void setRedColour(BasicBean basicBean) {
		List<BasicBean> dependent = dependencies.get(basicBean);

		if (dependent != null) {
			for (int i = 0; i < dependent.size(); i++) { // TODO SHOULD BE
															// TESTED!!!!
				BasicBean bb = dependent.get(i);
				if ("question".equals(bb.getType())) {
					styles.put(bb, "red");
					setRedColour(bb); // set Red to all dependent elements from
										// this question
				} else if ("group".equals(bb.getType())) {
					setRedGroup(bb);
				} else if ("section".equals(bb.getType())) {
					setRedSection(bb);
				}
			}
		}
	}

	private void setRedSection(BasicBean bb) {
		styles.put(bb, "red");
		for (int i = templateElementsList.indexOf(bb) + 1; i < templateElementsList
				.size()
				&& ("group".equals(templateElementsList.get(i).getType()) || "question".equals(templateElementsList.get(i).getType())); i++) {
			styles.put(templateElementsList.get(i), "red");
			setRedColour(templateElementsList.get(i));
		}

	}

	private void setRedGroup(BasicBean bb) {
		styles.put(bb, "red");
		for (int i = templateElementsList.indexOf(bb) + 1; i < templateElementsList
				.size()
				&& "question".equals(templateElementsList.get(i).getType()); i++) {
			styles.put(templateElementsList.get(i), "red");
			setRedColour(templateElementsList.get(i));
		}

	}


	public TemplateBean getCurrentTemplate() {
		return currentTemplate;
	}


	public void setCurrentTemplate(TemplateBean currentTemplate) {
		this.currentTemplate = currentTemplate;
		resetRulerList();				//TODO change to invocation
		
	}

}
