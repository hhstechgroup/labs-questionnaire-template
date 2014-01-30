package com.engagepoint.xmlparser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;


public class QuestionnaireForm {

    private String formName;
    private List<Page> pageList;

    @XmlElementWrapper(name = "pages")
    @XmlElement(name = "page")
    public List<Page> getPageList() {
        return pageList;
    }

    public void setPageList(List<Page> pageList) {
        this.pageList = pageList;
    }

    @XmlElement(name = "form-name")
    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }
}
