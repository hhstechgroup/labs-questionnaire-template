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
public class SectionBean implements Cloneable,Serializable {
    private int pageNumber;
    private List<GroupBean> groupsList = new ArrayList<GroupBean>();

    public SectionBean() {
    }

    public SectionBean(int pageNumber, List<GroupBean> groupsList) {
        this.pageNumber = pageNumber;
        this.groupsList = groupsList;
    }

    @XmlElementWrapper(name = "groups-of-questions")
    @XmlElement(name = "group")
    public List<GroupBean> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<GroupBean> groupsList) {
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
        SectionBean copy = (SectionBean) super.clone();
        copy.setPageNumber(this.pageNumber);
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
}
