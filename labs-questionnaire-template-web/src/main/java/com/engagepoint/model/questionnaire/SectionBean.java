package com.engagepoint.model.questionnaire;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents page tag.
 */
public class SectionBean extends BasicBean
                         implements Cloneable, Serializable, BasicOperationWithBean{
    private static Long lastId = 1L;

    private Long id;
    private Long pageNumber;
    private String pageName = "";
    private List<GroupBean> groupsList = new ArrayList<GroupBean>();
    private TemplateBean templateBean;

    public SectionBean() {
        id = lastId++;
    }

    public SectionBean(TemplateBean templateBean) {
        id = lastId++;
        this.templateBean = templateBean;
        this.pageNumber = getNextSectionIdInTemplate();
        templateBean.addToInnerList(this);
        setPageName("Page");
    }

    @XmlAttribute(name = "page-id")
    public String getQuestionId() {
        return "p" + id;
    }

    public void setQuestionId(String id) {
        try {
            this.id = Long.valueOf(id.substring(1));
        }
        catch (StringIndexOutOfBoundsException e) {
            //log that id in XML is empty
        }
        catch (NumberFormatException e) {
            //log that id in XML is incorrect (must be like "p[id]")
        }
    }

    @XmlTransient
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets next number of page for current template
     * @return SectionId
     */
    public Long getNextSectionIdInTemplate() {
        List<SectionBean> sectionList = templateBean.getSectionsList();
        if (sectionList.isEmpty()) {
            return 1L;
        }
        else {
            return ((sectionList.get(sectionList.size()-1)).getId()+1);
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
        List<GroupBean> copyGroupsList=null;
        if(groupsList!=null){
            copyGroupsList = new ArrayList<GroupBean>();
            for (GroupBean groupBean : groupsList) {
             copyGroupsList.add((GroupBean) groupBean.clone());
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

        if (!id.equals(that.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
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
        return "Page " + id;
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
    public String getDisplayedName() {
        return pageName;
    }

    @Override
    public String getDisplayedId() {
        String id = " (ID: "+String.valueOf(this.id)+") ";
        return id;
    }
}
