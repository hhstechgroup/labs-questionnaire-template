package com.engagepoint.model.questionnaire;


import com.engagepoint.model.question.Question;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents group tag.
 */
@XmlType(name = "", propOrder = {
        "groupId",
        "groupName",
        "questionsList"
})
public class GroupBean extends BasicBean
        implements Cloneable, BasicOperationWithBean {

    private String groupId; //absolutely unique and consists of template id, page number and group number (f.e. f1p1g1)
    private Long groupNumber; //unique in section
    private String groupName;
    private List<Question> questionsList = new ArrayList<Question>();
    private SectionBean sectionBean;


    public GroupBean() {
    }

    public GroupBean(SectionBean sectionBean) {
        this();
        this.sectionBean = sectionBean;
        this.groupNumber = getNextGroupNumberInSection();
        this.groupId = sectionBean.getPageId() + "g" + this.groupNumber;
        sectionBean.addToInnerList(this);
        setGroupName("Group " + groupNumber);
    }

    public GroupBean(String groupName, SectionBean sectionBean) {
        this(sectionBean);
        setGroupName(groupName);
    }

    public GroupBean(String groupName, List<Question> questionsList, SectionBean sectionBean) {
        this(sectionBean);
        setGroupName(groupName);
        this.questionsList = questionsList;
    }

    @XmlAttribute(name = "group-id")
    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
        //must set group number from xml
        if (groupNumber==null) {
            try {
                int indexOfP = groupId.lastIndexOf("g");
                setGroupNumber(Long.valueOf(groupId.substring(indexOfP+1)));
            } catch (NullPointerException e) {
                //log that groupId is null
            }
            catch (NumberFormatException e) {
                //log that groupId is not correct
            }
        }
    }

    /**
     * Gets next number of page for current template
     * @return SectionId
     */
    public Long getNextGroupNumberInSection() {
        List<GroupBean> groupList = sectionBean.getGroupsList();
        if (groupList.isEmpty()) {
            return 1L;
        }
        else {
            return ((groupList.get(groupList.size()-1)).getGroupNumber()+1);
        }
    }

    @XmlTransient
    private Long getGroupNumber() {
        return groupNumber;
    }

    private void setGroupNumber(Long groupNumber) {
        this.groupNumber = groupNumber;
    }

    @XmlElement(name = "group-name")
    public String getGroupName() {
        return this.groupName;
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
        copy.setGroupName(this.getGroupName());
        List<Question> copyQuestionsList = null;
        if (questionsList != null) {
            copyQuestionsList = new ArrayList<Question>();
            for (Question questionBean : questionsList) {
                if (questionBean != null) {
                    copyQuestionsList.add((Question) questionBean.clone());
                } else {
                    copyQuestionsList.add(null);
                }
            }
        }
        copy.setQuestionsList(copyQuestionsList);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GroupBean groupBean = (GroupBean) o;
        return groupId.equals(groupBean.groupId);
    }

    @Override
    public int hashCode() {
        return groupId.hashCode();
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

    @Override
    public String getDisplayedNodeType() {
        return "Group: ";
    }

    @Override
    @XmlTransient
    public String getDisplayedName() {
        return groupName;
    }

    @Override
    public String getDisplayedId() {
        return " (ID: " + String.valueOf(this.groupId) + ") ";
    }
}

