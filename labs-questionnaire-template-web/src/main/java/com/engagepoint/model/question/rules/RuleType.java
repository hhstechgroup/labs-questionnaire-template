package com.engagepoint.model.question.rules;

/**
 * Created by yaroslav on 3/12/14.
 */
public enum RuleType {
    RENDERED("This Question Will be rendered if ...");

    private String description;
    RuleType(String description){
        this.description = description;
    }

    public String description(){
        return description;
    }
}
