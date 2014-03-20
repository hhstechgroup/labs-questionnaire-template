package com.engagepoint.model.question.rules;

import java.util.*;
import java.util.List;

import static com.engagepoint.model.question.rules.RuleType.RENDERED;

/**
 * Contains all rules.
 */
public class RulesContainer {
    private Map<String, RuleType> supportedRules;

    public RulesContainer() {
        supportedRules = new HashMap<String, RuleType>();
        supportedRules.put("1. " + RENDERED.description(), RENDERED);
    }

    /**
     * Use this method to get List of unique String descriptions of Rules.
     * If you pass this description to createRule() method will get the necessary Rule instance.
     *
     * @return list of rules
     */
    public List<String> getSupportedRules() {
        return new ArrayList<String>(supportedRules.keySet());
    }

    /**
     * Create rule.
     *
     * @param description rule description.
     * @return rule object.
     */
    public Rule createRule(String description) {
        if (description != null){
            switch (supportedRules.get(description)) {
            case RENDERED:
                return new RenderedRule();
            default:



        }
        }

       return null;
    }
    }



