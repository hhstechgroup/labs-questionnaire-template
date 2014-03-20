package com.engagepoint.model.questionnaire;

import java.util.ArrayList;
import java.util.List;


import javax.xml.bind.annotation.XmlTransient;

import com.engagepoint.model.question.rules.Rule;

/**
 * Basic properties of beans
 * Must have only methods need fot all bean type
 */
@XmlTransient
public abstract class BasicBean {
    private String displayedName="";
    private List<Rule> rules = new ArrayList<Rule>();

    /** Return type of bean */
    public abstract String getType();

    /** Return unique id of bean */
    public abstract String getId();
    public abstract void setId(String id);

    /** Return displayed type of bean as String */
    public abstract String getDisplayedNodeType();

    /** Return ID of bean as String */
    public abstract String getDisplayedId();

    @XmlTransient
    /** Return displayed name of bean */
    public String getDisplayedName() {
        return displayedName;
    }

    /** Set displayed name of bean */
    public void setDisplayedName(String name) {
        this.displayedName = name;
    }

    /**
     * get a list of rules
     * 
     * @return
     */
    @XmlTransient
	public List<Rule> getRules() {
		return rules;
	}

	/**
	 * set a list of rules
	 * 
	 * @param rules
	 */
	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}
}
