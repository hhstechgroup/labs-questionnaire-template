package com.engagepoint.model.question.rules;

import java.util.*;
import java.util.List;

import static com.engagepoint.model.question.rules.RuleType.RENDERED;

public class RulesContainer {
    private Map<String, RuleType> supportedRules;
    private List<String> mock;
    {
        supportedRules = new HashMap<String, RuleType>();
        supportedRules.put("1. " + RENDERED.description(), RENDERED);
    }

    public RulesContainer() {
        mock = new ArrayList<String>();
        mock.add("Rule 1");
        mock.add("Rule 2");
        mock.add("Rule 3");
        mock.add("Rule 4");
    }

    public List<String> getMock() {
        return mock;
    }

    public void setMock(List<String> mock) {
        this.mock = mock;
    }

    /**
     * Use this method to get List of unique String descriptions of Rules.
     * If you pass this description to createRule() method will get the necessary Rule instance.
     *
     * @return
     */
    public List<String> getSupportedRules() {
        List<String> list = new ArrayList<String>( supportedRules.keySet());
        return list;
    }

    public Rule createRule(String descriptionId) {
        switch(supportedRules.get(descriptionId)){
            case RENDERED:
                return new RenderedRule();
        }
        return null;
    }
}
