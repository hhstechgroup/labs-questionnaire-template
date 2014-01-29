package com.engagepoint.xmlparser;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by kostiantyn.ustinov on 1/29/14.
 */
public class QuestionnaireForm {

    private List<FormName> formNameList;

    private List<Pages> pagesList;

    @XmlElement(name = "pages")
    public List<Pages> getPages() {
        return pagesList;
    }

    public void setPages(List<Pages> pages) {
        this.pagesList = pages;
    }


    @XmlElement(name = "form-name")
    public List<FormName> getFormNameList() {
        return formNameList;
    }

    public void setFormNameList(List<FormName> formNameList) {
        this.formNameList = formNameList;
    }

}
