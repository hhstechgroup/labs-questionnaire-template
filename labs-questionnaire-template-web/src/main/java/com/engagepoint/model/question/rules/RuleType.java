package com.engagepoint.model.question.rules;

/**
 * Represents all rule types.
 */
public enum RuleType {
    RENDERED("This Question Will be rendered if ...");

    private String description;

    RuleType(String description) {
        this.description = description;
    }

    public String description() {
        return description;
    }
}
