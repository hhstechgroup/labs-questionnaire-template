package com.engagepoint.model.question.rules;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@XmlSeeAlso({
        RenderedRule.class
})
@XmlTransient
public abstract class Rule implements Cloneable {
    protected String description;
    protected String id;
    protected String nameXML;
    protected RuleType type;

    public Rule() {
        this.description = "Not Supported";
    }

    @XmlElement(name = "method")
    public String getNameXML() {
        return nameXML;
    }

    public void setNameXML(String nameXML) {
        this.nameXML = nameXML;
        parseRuleViewToAnswer(nameXML);
    }

    public abstract void parseRuleViewToAnswer(String nameXML);

    public String getDescription() {
        return description;
    }

    public RuleType getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "parentId")
    public String getId() {
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
