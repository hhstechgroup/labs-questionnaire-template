package com.engagepoint.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 1/28/14
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class TemplateBean implements Cloneable, Comparable<TemplateBean> {
    private String templateName;
    private List<SectionBean> sectionsList = new ArrayList<SectionBean>();

    public TemplateBean() {
    }

    public TemplateBean(String templateName) {
        this.templateName = templateName;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public List<SectionBean> getSectionsList() {
        return sectionsList;
    }

    public void setSectionsList(List<SectionBean> sectionsList) {
        this.sectionsList = sectionsList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        TemplateBean copy = (TemplateBean) super.clone();
        copy.setTemplateName(this.templateName);
        List<SectionBean> copySectionsList = new ArrayList<SectionBean>();
        for (SectionBean sectionBean : sectionsList) {
            copySectionsList.add((SectionBean) sectionBean.clone());
        }
        copy.setSectionsList(copySectionsList);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemplateBean that = (TemplateBean) o;

        if (sectionsList != null ? !sectionsList.equals(that.sectionsList) : that.sectionsList != null) return false;
        if (templateName != null ? !templateName.equals(that.templateName) : that.templateName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = templateName != null ? templateName.hashCode() : 0;
        result = 31 * result + (sectionsList != null ? sectionsList.hashCode() : 0);
        return result;
    }

    /**
     * Compares names of objects.
     * @param o object to compare
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(TemplateBean o) {
        return this.getTemplateName().compareTo(o.getTemplateName());
    }
}
