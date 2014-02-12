package com.engagepoint.bean;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents group tag.
 */
public class GroupBasicBean implements Cloneable, BasicOperationWithBean, BasicBeanProperty {
    private String groupName;
    private List<QuestionBasicBean> questionsList = new ArrayList<QuestionBasicBean>();

    public GroupBasicBean() {
    }

    public GroupBasicBean(String groupName, List<QuestionBasicBean> questionsList) {
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
    public List<QuestionBasicBean> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<QuestionBasicBean> questionsList) {
        this.questionsList = questionsList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        GroupBasicBean copy = (GroupBasicBean) super.clone();
        copy.setGroupName(this.groupName);
        List<QuestionBasicBean> copyQuestionsList =null;
        if(questionsList!=null){
            copyQuestionsList = new ArrayList<QuestionBasicBean>();
            for (QuestionBasicBean questionBean : questionsList) {
             copyQuestionsList.add((QuestionBasicBean) questionBean.clone());
            }
        }
        copy.setQuestionsList(copyQuestionsList);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupBasicBean groupBean = (GroupBasicBean) o;

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
        ((GroupBasicBean) o).questionsList.remove(o);
    }

    @Override
    public void addToInnerList(Object o) {
        questionsList.add((QuestionBasicBean) o);
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
