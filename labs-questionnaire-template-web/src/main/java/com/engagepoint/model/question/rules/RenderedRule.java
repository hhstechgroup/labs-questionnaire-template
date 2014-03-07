package com.engagepoint.model.question.rules;


public class RenderedRule extends Rule{
    private long id;
    private String answer;
    private String xmlTemplate = "this.rule.renderedRule";


    public RenderedRule(){
        this.description="This Question Will be rendered if ...";
        nameXML = xmlTemplate+"("+"'"+id+"'"+", "+"'"+answer+"'"+")";
    }

    public void setId(long id) {
        this.id=id;
        changeNameXML();
    }


    public long getId() {
        return id;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
        changeNameXML();
    }


    public String getAnswer() {
        return answer;
    }

    private void changeNameXML(){
        nameXML = xmlTemplate+"("+"'"+id+"'"+", "+"'"+answer+"'"+")";
    }

}
