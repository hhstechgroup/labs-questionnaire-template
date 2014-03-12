package com.engagepoint.model.question.rules;


public abstract class Rule {
    public static String description;
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

    public String getDescription(){
        return description;
    }
}
