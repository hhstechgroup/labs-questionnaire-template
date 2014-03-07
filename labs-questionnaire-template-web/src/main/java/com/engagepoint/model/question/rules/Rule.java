package com.engagepoint.model.question.rules;


public abstract class Rule {
    protected static String description;
    protected String nameXML;

    public Rule(){
        this.description = "Not Supported";
    }

    public void setNameXML(String nameXML){
        this.nameXML = nameXML;
    }

    public  String getNameXML(){
        return nameXML;
    }
}
