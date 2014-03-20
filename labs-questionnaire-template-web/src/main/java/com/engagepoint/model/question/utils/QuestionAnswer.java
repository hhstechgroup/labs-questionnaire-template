package com.engagepoint.model.question.utils;


import com.engagepoint.model.question.rules.RenderedRule;
import com.engagepoint.model.question.rules.Rule;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuestionAnswer {
    private String answer;

    public String getAnswer(){
        return this.answer;
    }

    public void  setAnswer(String answer){
        this.answer = wrapper(answer);
    }

    public void  setAnswer(Date answer){
        this.answer = wrapper(answer.toString());
    }

    public void  setAnswer(RangeItem answer){
        this.answer = wrapper(answer.toString());
    }

    public void  setAnswer(VariantItem answer){
        this.answer = wrapper(answer.getValue());
    }

    public void  setAnswer(List<VariantItem> answer){
        List<String> temporary = new ArrayList<String>();
        for (VariantItem item : answer) {
            temporary.add(item.getValue());
        }
        this.answer = turnListToString(temporary);
    }

    public void setAnswer(Rule rule){
        switch(rule.getType()){
            case RENDERED:
                RenderedRule temp = (RenderedRule)rule;
                answer = turnListToString(temp.getAnswers());
        }
    }


    private String turnListToString(List<String> list){
        StringBuilder answer = new StringBuilder();
        answer.append("[");
        if (list != null)
            for (String str : list) {
                answer.append("'" + str + "'" + ", ");
            }
        if (answer.length() > 2)
            answer.setLength(answer.length() - 2);
        answer.append("]");

        return answer.toString();
    }

    private String wrapper(String string){
        StringBuilder answer = new StringBuilder();
        answer.append("['");
        answer.append(string);
        answer.append("']");
        return answer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionAnswer that = (QuestionAnswer) o;

        if (answer != null ? !answer.equals(that.answer) : that.answer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return answer != null ? answer.hashCode() : 0;
    }
}

