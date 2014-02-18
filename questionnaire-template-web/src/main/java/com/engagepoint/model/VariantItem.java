package com.engagepoint.model;

/**
 * Representation of answer variant for a question.
 */
public class VariantItem {
    private String value;

    public VariantItem(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
