package com.engagepoint.model.questionnaire;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class represents questionnaire-form tag.
 */
@XmlRootElement(name = "questionnaire-form")
@XmlType(name = "", propOrder = {
        "formId",
        "templateName",
        "sectionsList"
})
public class TemplateBean implements Cloneable, Comparable<TemplateBean>, BasicOperationWithBean {
    private static Long lastId = 1L;

    public static Long getLastId() {
        return lastId++;
    }

    private Long id;
    private String formId;
    private String templateName = "";
    private List<SectionBean> sectionsList = new ArrayList<SectionBean>();

    public static boolean duplicate;

    public TemplateBean() {
        setId(getLastId());
        formId = "f" + id;
    }

    public TemplateBean(String templateName) {
        this();
        this.templateName = templateName;
    }

    public TemplateBean(String templateName, List<SectionBean> sectionsList) {
        this(templateName);
        this.sectionsList = sectionsList;
    }

    public TemplateBean(Long id, String templateName, List<SectionBean> sectionsList) {
        this.id = id;
        this.templateName = templateName;
        this.sectionsList = sectionsList;
    }

    @XmlAttribute(name = "form-id")
    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    @XmlTransient
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @XmlElement(name = "form-name")
    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    @XmlElementWrapper(name = "pages")
    @XmlElement(name = "page")
    public List<SectionBean> getSectionsList() {
        return sectionsList;
    }

    public void setSectionsList(List<SectionBean> sectionsList) {
        this.sectionsList = sectionsList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TemplateBean copy = clone1();
        copy.setId(getLastId());
        return copy;
    }

    public TemplateBean duplicate() throws CloneNotSupportedException {
        duplicate=true;
        TemplateBean copy = clone1();
        copy.setId(this.id);
        duplicate=false;
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemplateBean that = (TemplateBean) o;

        return that.getFormId().equals(this.getFormId());
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result;
        return result;
    }

    /**
     * Compares names of objects.
     *
     * @param o object to compare
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(TemplateBean o) {
        return this.getTemplateName().compareTo(o.getTemplateName());
    }

    @Override
    public void deleteFromInnerList(Object o) {
        sectionsList.remove(o);
    }

    @Override
    public void addToInnerList(Object o) {
        sectionsList.add((SectionBean) o);
    }

    @Override
    public String toString() {
        // Isn't necessary
        return null;
    }

    private TemplateBean clone1() throws CloneNotSupportedException {
        TemplateBean copy = (TemplateBean) super.clone();
        List<SectionBean> copySectionsList = null;
        if(sectionsList!=null){
            copySectionsList = new ArrayList<SectionBean>();
            for (SectionBean sectionBean : sectionsList) {
                copySectionsList.add((SectionBean) sectionBean.clone());
            }
        }
        copy.setSectionsList(copySectionsList);
        return copy;
    }
}
