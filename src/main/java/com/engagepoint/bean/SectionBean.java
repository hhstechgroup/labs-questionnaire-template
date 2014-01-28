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
public class SectionBean implements Cloneable {
    private int pageNumber;
    private List<GroupBean> groupsList = new ArrayList<GroupBean>();

    public List<GroupBean> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<GroupBean> groupsList) {
        this.groupsList = groupsList;
    }

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
        List<GroupBean> copyGroupsList = new ArrayList<GroupBean>();
        for (GroupBean groupBean : copyGroupsList) {
            copyGroupsList.add((GroupBean) groupBean.clone());
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
