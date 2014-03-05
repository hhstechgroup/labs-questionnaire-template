package com.engagepoint.model.question.utils;

import javax.xml.bind.annotation.XmlElement;

/**
 * Representation of answer variant for a question.
 */
public class VariantItem implements Cloneable{
    private String value;

    public VariantItem() {
    }

    public VariantItem(String value) {
        this.value = value;
    }

    @XmlElement(name = "value")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VariantItem)) return false;

        VariantItem that = (VariantItem) o;

        if (!value.equals(that.value)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
