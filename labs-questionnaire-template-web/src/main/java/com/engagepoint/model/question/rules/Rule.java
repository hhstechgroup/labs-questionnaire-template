package com.engagepoint.model.question.rules;


import javax.xml.bind.annotation.XmlElement;

public abstract class Rule implements Cloneable {
    protected String description;
    protected long id;
    protected String nameXML;
    protected RuleType type;

    public Rule() {
        this.description = "Not Supported";
    }

    public void setNameXML(String nameXML) {
        this.nameXML = nameXML;
    }

    @XmlElement(name = "method")
    public String getNameXML() {
        return nameXML;
    }

    public String getDescription() {
        return description;
    }

    public RuleType getType() {
        return type;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement(name = "parentId")
    public long getId() {
        return id;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Rule copy = (Rule) super.clone();
        copy.description = this.description;
        copy.nameXML = this.nameXML;
        copy.type = this.type;
        copy.id = this.id;

        return copy;
    }
}
