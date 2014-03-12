package com.engagepoint.model.questionnaire;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents page tag.
 */
public class SectionBean extends BasicBean
                         implements Cloneable, Serializable, BasicOperationWithBean{
    private static Long lastId = 1L;

    private Long id=0L;
    private List<GroupBean> groupsList = new ArrayList<GroupBean>();

    public SectionBean() {
        this.id = lastId++;
        super.setDisplayedName("PageDefault");
    }

    public SectionBean(List<GroupBean> groupsList) {
        this.id = lastId++;
        this.groupsList = groupsList;
        super.setDisplayedName("Page");
    }

    @XmlElement(name = "page-number")
    public Long getId() {
        return id;
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
    public String getDisplayedId() {
        String id = " (ID: "+String.valueOf(this.id)+") ";
        return id;
    }

}
