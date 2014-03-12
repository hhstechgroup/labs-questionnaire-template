package com.engagepoint.model.question.rules;


public abstract class Rule {
    public static String description;
    protected String nameXML;
    protected RuleType type;

    public Rule(){
        this.description = "Not Supported";
    }

    public void setNameXML(String nameXML){
        this.nameXML = nameXML;
    }

    public  String getNameXML(){
        return nameXML;
    }

    public String getDescription(){
        return description;
    }

    public RuleType getType() {
        return type;
    }
}
