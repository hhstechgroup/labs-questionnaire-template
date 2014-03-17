package com.engagepoint.model.questionnaire;

import com.engagepoint.model.question.rules.Rule;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents page tag.
 */
@XmlType(name = "", propOrder = {
        "id",
        "pageNumber",
        "pageName",
        "pageRules",
        "groupsList"
})
public class SectionBean extends BasicBean
        implements Cloneable, Serializable, BasicOperationWithBean {
    private static Long lastId = 1L;

    private String pageId; //absolutely unique and consists of template id and page number (f.e. f1p1)
    private Long pageNumber; //unique in template
    private String pageName = "";
    private List<GroupBean> groupsList = new ArrayList<GroupBean>();
    private TemplateBean templateBean;

    private List<Rule> pageRules;

    public SectionBean() {
        setRules(new ArrayList<Rule>());
    }

    public SectionBean(TemplateBean templateBean) {
        this();
        this.templateBean = templateBean;
        this.pageNumber = getNextSectionNumberInTemplate();
        this.pageId = templateBean.getFormId() + "p" + this.pageNumber;
        templateBean.addToInnerList(this);
        setPageName("Page " + pageNumber);
    }

    @XmlTransient
    public TemplateBean getTemplateBean() {
        return templateBean;
    }

    public void setTemplateBean(TemplateBean templateBean) {
        this.templateBean = templateBean;
    }

    @XmlAttribute(name = "page-id")
    @Override
    public String getId() {
        return pageId;
    }

    @Override
    public void setId(String pageId) {
        this.pageId = pageId;
    }

    /**
     * Gets next number of page for current template
     *
     * @return SectionId
     */
    public Long getNextSectionNumberInTemplate() {
        List<SectionBean> sectionList = templateBean.getSectionsList();
        if (sectionList.isEmpty()) {
            return 1L;
        } else {
            return (sectionList.get(sectionList.size() - 1)).getPageNumber() + 1;
        }
    }

    @XmlAttribute(name = "page-number")
    public Long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Long pageNumber) {
        this.pageNumber = pageNumber;
    }

    @XmlElement(name = "page-name")
    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @XmlElementWrapper(name = "page-rules")
    @XmlElement(name = "page-rule")
    public List<Rule> getPageRules() {
        return getRules();
    }

    public void setPageRules(List<Rule> rules) {
        setRules(rules);
    }

    @XmlElementWrapper(name = "groups-of-questions")
    @XmlElement(name = "group")
    public List<GroupBean> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<GroupBean> groupsList) {
        this.groupsList = groupsList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        SectionBean copy = (SectionBean) super.clone();
        copy.setPageName(this.pageName);
        copy.setPageNumber(this.pageNumber);

        List<GroupBean> copyGroupsList = null;
        if (groupsList != null) {
            copyGroupsList = new ArrayList<GroupBean>();
            for (GroupBean groupBean : groupsList) {
                GroupBean clonedGroup = (GroupBean) groupBean.clone();
                clonedGroup.setSectionBean(copy);
                copyGroupsList.add(clonedGroup);
            }
        }
        copy.setGroupsList(copyGroupsList);

        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionBean that = (SectionBean) o;

        if (groupsList != null ? !groupsList.equals(that.groupsList) : that.groupsList != null) return false;
        if (pageNumber != null ? !pageNumber.equals(that.pageNumber) : that.pageNumber != null) return false;
        if (pageName != null ? !pageName.equals(that.pageName) : that.pageName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pageName.hashCode();
        result = 31 * result + (pageNumber != null ? pageNumber.hashCode() : 0);
        result = 31 * result + (groupsList != null ? groupsList.hashCode() : 0);
        return result;
    }

    @Override
    public void deleteFromInnerList(Object o) {
        groupsList.remove(o);
    }

    @Override
    public void addToInnerList(Object o) {
        groupsList.add((GroupBean) o);
    }

    @Override
    public String toString() {
        return pageName;
    }

    @Override
    public String getType() {
        return "section";
    }

    @Override
    public String getDisplayedNodeType() {
        return "Page: ";
    }

    @Override
    @XmlTransient
    public String getDisplayedName() {
        return pageName;
    }

    @Override
    public String getDisplayedId() {
        return " (ID: "+String.valueOf(this.pageId)+") ";
    }
}
