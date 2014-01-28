package com.engagepoint.bean;


import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 1/28/14
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class GroupBean implements Cloneable {
    private String groupName;
    private List<QuestionBean> questionsList = new ArrayList<QuestionBean>();

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

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
        List<QuestionBean> copyQuestionsList = new ArrayList<QuestionBean>();
        for (QuestionBean questionBean : questionsList) {
            copyQuestionsList.add((QuestionBean) questionBean.clone());
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
}
