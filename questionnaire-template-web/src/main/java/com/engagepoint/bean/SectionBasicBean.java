package com.engagepoint.bean;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents page tag.
 */
@Named
@SessionScoped
public class SectionBasicBean implements Cloneable, Serializable, BasicOperationWithBean,
        BasicBeanProperty {
    private int pageNumber;
    private List<GroupBasicBean> groupsList = new ArrayList<GroupBasicBean>();

    public SectionBasicBean() {
    }

    public SectionBasicBean(int pageNumber, List<GroupBasicBean> groupsList) {
        this.pageNumber = pageNumber;
        this.groupsList = groupsList;
    }

    @XmlElementWrapper(name = "groups-of-questions")
    @XmlElement(name = "group")
    public List<GroupBasicBean> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<GroupBasicBean> groupsList) {
        this.groupsList = groupsList;
    }

    @XmlElement(name = "page-number")
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        SectionBasicBean copy = (SectionBasicBean) super.clone();
        copy.setPageNumber(this.pageNumber);
        List<GroupBasicBean> copyGroupsList=null;
        if(groupsList!=null){
            copyGroupsList = new ArrayList<GroupBasicBean>();
            for (GroupBasicBean groupBean : groupsList) {
             copyGroupsList.add((GroupBasicBean) groupBean.clone());
            }
        }
        copy.setGroupsList(copyGroupsList);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionBasicBean that = (SectionBasicBean) o;

        if (pageNumber != that.pageNumber) return false;
        if (groupsList != null ? !groupsList.equals(that.groupsList) : that.groupsList != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pageNumber;
        result = 31 * result + (groupsList != null ? groupsList.hashCode() : 0);
        return result;
    }

    @Override
    public void deleteFromInnerList(Object o) {
        groupsList.remove(o);
    }

    @Override
    public void addToInnerList(Object o) {
        groupsList.add((GroupBasicBean) o);
    }

    @Override
    public String toString() {
        return "Page " + pageNumber;
    }

    @Override
    public String getType() {
        return "section";
    }
}
