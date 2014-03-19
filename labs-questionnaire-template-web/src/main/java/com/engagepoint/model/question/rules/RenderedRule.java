package com.engagepoint.model.question.rules;


import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "rule", propOrder = {
        "nameXML",
        "id"
})
public class RenderedRule extends Rule {

    private List<String> answers;
    private String xmlTemplate = "this.ruleExecutor.renderedRule";

    public RenderedRule() {
        description = RuleType.RENDERED.description();
        type = RuleType.RENDERED;
        update();
        answers = new ArrayList<String>();
    }

    @Override
    public void parseRuleViewToAnswer(String nameXML) {
        int beginIndex = nameXML.lastIndexOf("['")+2;
        int endIndex = nameXML.lastIndexOf("']");
        if (beginIndex==-1 || endIndex==-1) {
            //log or throw exception that string is not correct
            return;
        }
        String answer="";
        try {
            answer = nameXML.substring(beginIndex,endIndex);
        } catch (StringIndexOutOfBoundsException e) {
            //log or throw exception that string is not correct
        }
        answers.add(answer);
    }

    public void setId(String id) {
        this.id = id;
        update();
    }

    public void setAnswer(String answer) {
        this.answers.add(answer);
        update();
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
        update();
    }

    @XmlTransient
    public List<String> getAnswers() {
        return answers;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        RenderedRule copy = (RenderedRule) super.clone();
        copy.answers = new ArrayList<String>(this.answers);
        copy.xmlTemplate = this.xmlTemplate;
        return copy;
    }

    /**
     * Create rule representation in XML.
     *
     * @return answer as String
     */
    private String answerToString() {
        StringBuilder answer = new StringBuilder();
        answer.append("[");
        if (answers != null) {
            for (String str : answers) {
                answer.append("'" + str + "'" + ", ");
            }
        }
        if (answer.length() > 2) {
            answer.setLength(answer.length() - 2);
        }
        answer.append("]");
        return answer.toString();
    }

    /**
     * Update rule.
     */
    private void update() {
        description = "This Question Will be rendered if question with " + "id=" + id + " will have answer=" + answerToString();
        String answer = answerToString();
        nameXML = xmlTemplate + "(" + "'%s', " + answer + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RenderedRule)) return false;

        RenderedRule that = (RenderedRule) o;

        if (answers != null ? !answers.equals(that.answers) : that.answers != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return answers != null ? answers.hashCode() : 0;
    }
}
