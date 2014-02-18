package com.engagepoint.bean;


import com.engagepoint.bean.QuestionBeans.QuestionBean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents group tag.
 */
public class GroupBean implements Cloneable, BasicOperationWithBean, BasicBeanProperty {
    private String groupName;
    private List<QuestionBean> questionsList = new ArrayList<QuestionBean>();

    public GroupBean() {
    }

    public GroupBean(String groupName, List<QuestionBean> questionsList) {
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
    public List<QuestionBean> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<QuestionBean> questionsList) {
        this.questionsList = questionsList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        GroupBean copy = (GroupBean) super.clone();
        copy.setGroupName(this.groupName);
        List<QuestionBean> copyQuestionsList =null;
        if(questionsList!=null){
            copyQuestionsList = new ArrayList<QuestionBean>();
            for (QuestionBean questionBean : questionsList) {
             copyQuestionsList.add((QuestionBean) questionBean.clone());
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
        ((GroupBean) o).questionsList.remove(o);
    }

    @Override
    public void addToInnerList(Object o) {
        questionsList.add((QuestionBean) o);
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
