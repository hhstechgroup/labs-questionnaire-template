package com.engagepoint.model.questionnaire;


import com.engagepoint.model.question.Question;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents group tag.
 */
public class GroupBean implements Cloneable, BasicOperationWithBean, BasicBeanProperty {
    private String groupName;

    private List<Question> questionsList = new ArrayList<Question>();

    public GroupBean() {
    }

    public GroupBean(String groupName, List<Question> questionsList) {
        this.groupName = groupName;
        this.questionsList = questionsList;
    }

    @XmlElement(name = "group-name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @XmlElementWrapper(name = "questions")
    @XmlElement(name = "question")
    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        GroupBean copy = (GroupBean) super.clone();
        copy.setGroupName(this.groupName);
        List<Question> copyQuestionsList = null;
        if (questionsList != null) {
            copyQuestionsList = new ArrayList<Question>();
            for (Question questionBean : questionsList) {
                if(questionBean!=null)
                    copyQuestionsList.add((Question) questionBean.clone());
                else
                    copyQuestionsList.add(null);
            }
        }
        copy.setQuestionsList(copyQuestionsList);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupBean groupBean = (GroupBean) o;

        if (groupName != null ? !groupName.equals(groupBean.groupName) : groupBean.groupName != null) return false;
        if (questionsList != null ? !questionsList.equals(groupBean.questionsList) : groupBean.questionsList != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupName != null ? groupName.hashCode() : 0;
        result = 31 * result + (questionsList != null ? questionsList.hashCode() : 0);
        return result;
    }

    @Override
    public void deleteFromInnerList(Object o) {
        questionsList.remove(o);
    }

    @Override
    public void addToInnerList(Object o) {
        questionsList.add((Question) o);
    }

    @Override
    public String toString() {
        return groupName;
    }

    @Override
    public String getType() {
        return "group";
    }
}
