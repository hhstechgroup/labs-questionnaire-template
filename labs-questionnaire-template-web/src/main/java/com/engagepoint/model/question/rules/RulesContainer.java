package com.engagepoint.model.question.rules;

import java.util.*;
import java.util.List;

public class RulesContainer {
    private List<Rule> rules;
    private static Map<String, Class<? extends Rule> > supportedRules;

    static{
        generateSupportedRules();
    }


    public RulesContainer(){
        rules = new ArrayList<Rule>();
    }

    /**
     * Use this method to get List of unique String descriptions of Rules.
     * If you pass this description to createRule() method will get the necessary Rule instance.
     * @return
     */
    public static List<String> getSupportedRules(){
        return new ArrayList<String>(supportedRules.keySet());
    }

    public static Rule createRule(String descriptionId){
        Rule rule = null;
        try {
            rule = supportedRules.get(descriptionId).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return  rule;
    }

    public void setRule(Rule rule){
        rules.add(rule);
    }

    public void setRules(List<Rule> rules){
        this.rules = rules;
    }

    public List<Rule> getRules(){
        return rules;
    }

    private static void generateSupportedRules(){
        supportedRules=new HashMap<String, Class<? extends Rule>>();
        supportedRules.put("1. "+RenderedRule.description, RenderedRule.class);
    }
}
