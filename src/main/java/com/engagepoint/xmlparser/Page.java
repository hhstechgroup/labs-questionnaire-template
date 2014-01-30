package com.engagepoint.xmlparser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;


public class Page {

    private int pageNumber;
    private List<Group> groupList;

    @XmlElementWrapper(name = "groups-of-questions")
    @XmlElement(name = "group")
    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }


    @XmlElement(name = "page-count")
    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
