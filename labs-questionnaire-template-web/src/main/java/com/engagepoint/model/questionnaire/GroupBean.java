package com.engagepoint.model.questionnaire;


import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.rules.Rule;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represents group tag.
 */
@XmlType(name = "", propOrder = {
        "id",
        "groupName",
        "groupRules",
        "questionsList"
})
public class GroupBean extends BasicBean
        implements Cloneable, BasicOperationWithBean {

    private String groupId; //absolutely unique and consists of template id, page number and group number (f.e. f1p1g1)
    private Long groupNumber; //unique in section
    private String groupName;
    private List<Question> questionsList = new ArrayList<Question>();
    private SectionBean sectionBean;
    private static final Logger LOG = Logger.getLogger(GroupBean.class);

    private List<Rule> groupRules;

    public GroupBean() {
        setRules(new ArrayList<Rule>());
    }

    public GroupBean(SectionBean sectionBean) {
        this();
        this.sectionBean = sectionBean;
        this.groupNumber = getNextGroupNumberInSection();
        this.groupId = sectionBean.getId() + "g" + this.groupNumber;
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

    @XmlTransient
    public SectionBean getSectionBean() {
        return sectionBean;
    }

    public void setSectionBean(SectionBean sectionBean) {
        this.sectionBean = sectionBean;
    }

    @XmlAttribute(name = "group-id")
    @Override
    public String getId() {
        return groupId;
    }

    @Override
    public void setId(String groupId) {
        this.groupId = groupId;
        //must set group number from xml
        if (groupNumber==null) {
            try {
                int indexOfP = groupId.lastIndexOf('g');
                setGroupNumber(Long.valueOf(groupId.substring(indexOfP+1)));
            } catch (NumberFormatException e) {
                LOG.warn("Group id is incorrect", e);
            }
        }
    }

    /**
     * Gets next number of page for current template
     * @return SectionId
     */
    public final Long getNextGroupNumberInSection() {
        List<GroupBean> groupList = sectionBean.getGroupsList();
        if (groupList.isEmpty()) {
            return 1L;
        }else {
            return groupList.get(groupList.size()-1).getGroupNumber()+1;
        }
    }

    @XmlTransient
    public Long getGroupNumber() {
        return groupNumber;
    }

    public final void setGroupNumber(Long groupNumber) {
        this.groupNumber = groupNumber;
    }

    @XmlElement(name = "group-name")
    public String getGroupName() {
        return this.groupName;
    }

    public final void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @XmlElementWrapper(name = "group-rules")
    @XmlElement(name = "group-rule")
    public List<Rule> getGroupRules() {
        return getRules();
    }

    public void setGroupRules(List<Rule> rules) {
        setRules(rules);
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
        copy.setGroupNumber(this.groupNumber);

        List<Question> copyQuestionsList = null;
        if (questionsList != null) {
            copyQuestionsList = new ArrayList<Question>();
            for (Question questionBean : questionsList) {
                if (questionBean != null) {
                    Question clonedQuestion = (Question) questionBean.clone();
                    clonedQuestion.setGroupBean(copy);
                    copyQuestionsList.add(clonedQuestion);
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
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        GroupBean groupBean = (GroupBean) o;

        if (groupName != null ? !groupName.equals(groupBean.groupName) : groupBean.groupName != null){
            return false;
        }
        if (questionsList != null ? !questionsList.equals(groupBean.questionsList) : groupBean.questionsList != null){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = groupName.hashCode();
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

