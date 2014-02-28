package com.engagepoint.model.question.utils;

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        VariantItem copy = (VariantItem) super.clone();
        copy.setValue(this.value);
        return copy;
    }
}
