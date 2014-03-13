package com.engagepoint.model.question.rules;


import java.util.ArrayList;
import java.util.List;

public class RenderedRule extends Rule{
    private long id;
    private List<String> answers;
    private String xmlTemplate = "this.ruleExecutor.renderedRule";
    static{
        description="This Question Will be rendered if ...";
    }


    public RenderedRule(){
        type = RuleType.RENDERED;
        changeNameXML();
        answers = new ArrayList<String>();
    }

    public void setId(long id) {
        this.id=id;
        changeNameXML();
    }


    public long getId() {
        return id;
    }


    public void setAnswer(String answer) {
        this.answers.add(answer);
        changeNameXML();
    }

    public void setAnswers(List<String> answers) {
        this.answers=answers;
        changeNameXML();
    }


    public List<String> getAnswers() {
        return answers;
    }

    private void changeNameXML(){
        StringBuilder answer = new StringBuilder();
        for(String str : answers){
            answer.append("'"+str+"'"+", ");
        }
        if(answer.length()>0)
            answer.setLength(answer.length() -1);
        nameXML = xmlTemplate+"("+"'"+id+"'"+", "+"["+answer+"]"+")";
    }



}
