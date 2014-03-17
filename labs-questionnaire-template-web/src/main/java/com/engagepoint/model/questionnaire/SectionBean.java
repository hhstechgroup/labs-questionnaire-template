package com.engagepoint.model.questionnaire;

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

    public SectionBean() {
    }

    public SectionBean(TemplateBean templateBean) {
        this();
        this.templateBean = templateBean;
        this.pageNumber = getNextSectionNumberInTemplate();
        this.pageId = templateBean.getFormId() + "p" + this.pageNumber;
        templateBean.addToInnerList(this);
        setPageName("Page " + pageNumber);
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
        List<GroupBean> copyGroupsList = null;
        if (groupsList != null) {
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SectionBean that = (SectionBean) o;
        if (!pageId.equals(that.pageId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return pageId.hashCode();
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
