package com.engagepoint.model.questionnaire;

import com.engagepoint.controller.page.ListController;
import com.engagepoint.model.question.DateQuestionBean;
import com.engagepoint.model.question.Question;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.enterprise.event.Event;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
    private Long id;
    private String formId;
    private String templateName = "";
    private List<SectionBean> sectionsList = new ArrayList<SectionBean>();
    private static boolean duplicate;
    private static Long lastId = 1L;

    public static boolean isDuplicate() {
        return duplicate;
    }


    public  Long getLastId() {
        return lastId++;
    }

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
        formId = "f" + id;
        this.templateName = templateName;
        this.sectionsList = sectionsList;
    }

    @XmlAttribute(name = "form-id")
    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        if(formId!=null && formId.length()>0){
            this.id = Long.valueOf(formId.substring(1));
        }
        if(id>=lastId){
            lastId=++id;
        }
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
        TemplateBean copy = clone1(getLastId());
        //copy.setId();
        return copy;
    }

    public TemplateBean duplicate() throws CloneNotSupportedException {
        duplicate = true;
        TemplateBean copy = clone1(this.id);
        //copy.setId();
        duplicate = false;
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemplateBean that = (TemplateBean) o;

        if (!formId.equals(that.formId)) return false;
        if (sectionsList != null ? !sectionsList.equals(that.sectionsList) : that.sectionsList != null) return false;
        if (!templateName.equals(that.templateName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = formId.hashCode();
        result = 31 * result + templateName.hashCode();
        result = 31 * result + (sectionsList != null ? sectionsList.hashCode() : 0);
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

    private TemplateBean clone1(Long id) throws CloneNotSupportedException {
        TemplateBean copy = (TemplateBean) super.clone();
        copy.setId(id);
        copy.setFormId("f" + id.toString());

        List<SectionBean> copySectionsList = null;
        if (sectionsList != null) {
            copySectionsList = new ArrayList<SectionBean>();
            for (SectionBean sectionBean : sectionsList) {
                SectionBean clonedSection = (SectionBean) sectionBean.clone();
                clonedSection.setTemplateBean(copy);
                copySectionsList.add(clonedSection);
            }

            //change id of all children due to cloned template
            for (SectionBean sectionBean : copySectionsList) {
                sectionBean.setId(copy.formId + "p" + sectionBean.getPageNumber());
                for (GroupBean groupBean : sectionBean.getGroupsList()) {
                    groupBean.setId(sectionBean.getId() + "g" + groupBean.getGroupNumber());
                    for (Question questionBean : groupBean.getQuestionsList()) {
                        questionBean.setId(groupBean.getId() + "q" + questionBean.getQuestionNumber());
                    }
                }
            }
        }
        copy.setSectionsList(copySectionsList);
        copy.setTemplateName(this.templateName);
        return copy;
    }
}
