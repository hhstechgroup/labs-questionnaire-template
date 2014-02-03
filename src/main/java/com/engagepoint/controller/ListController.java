package com.engagepoint.controller;


import com.engagepoint.bean.TemplateBean;
import com.engagepoint.utils.XmlImportExport;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
@SessionScoped
public class ListController implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<TemplateBean> list;
    private List<TemplateBean> filteredList;
    private String xmlPath;
    private String filterValue = "";

    public ListController() {
        list = new ArrayList<TemplateBean>();
        //searching path of XML file in glassfish
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        xmlPath = classLoader.getResource("Questionnaire.xml").getPath();
        //adding Templates from XML file
        addAllTemplates(XmlImportExport.importXmlTemplate(xmlPath));
    }

    //operations on list
    public List<TemplateBean> getTemplates() {
        return list;
    }

    public void setTemplates(List<TemplateBean> list) {
        this.list = list;
    }

    //operations on filtered list
    public List<TemplateBean> getFilteredTemplates() {
        return filteredList;
    }

    public void setFilteredTemplates(List<TemplateBean> filteredList) {
        this.filteredList = filteredList;
    }

    //operations on both lists

    /**
     * Add template.
     *
     * @param template template to be added
     */
    public void addTemplate(TemplateBean template) {
        this.list.add(template);
        if (filteredList != null)
            filteredList.add(template);
        sort();
    }

    /**
     * Add templates.
     *
     * @param templateBeanList template list to be added
     */
    public void addAllTemplates(List<TemplateBean> templateBeanList) {
        this.list.addAll(templateBeanList);
        if (filteredList != null)
            filteredList.addAll(templateBeanList);
        sort();
    }


    /**
     * Sort list of templates.
     */
    public void sort() {
        Collections.sort(list);
        if (filteredList != null)
            Collections.sort(filteredList);
    }

    /**
     * Clone template.
     *
     * @param template template to be clonned
     * @throws CloneNotSupportedException
     */
    public void clone(TemplateBean template) throws CloneNotSupportedException {
        TemplateBean newTemplate = (TemplateBean) template.clone();
        addTemplate(newTemplate);
    }

    /**
     * Delete template from list.
     *
     * @param template template to be deleted
     */
    public void deleteTemplate(TemplateBean template) {
        list.remove(template);
        if (filteredList != null)
            filteredList.remove(template);
    }

    /**
     * Perform export questionnaire to XML file.
     */
    public void exportToXML() {
        //TODO
        addMessage("Data exported");
    }

    /**
     * Perform import questionnaire from XML file.
     */
    public void importFromXML() {
        //TODO
        addMessage("Data imported");
    }

    /**
     * Show message on delete pop-up.
     *
     * @param template template to delete
     * @return message to display
     */
    public String getMessageOnDelete(TemplateBean template) {
        if (template == null)
            return "";
        if (template.getTemplateName() == null)
            return "";
        return "Please confirm deleting of " + template.getTemplateName();
    }

    /**
     * Show message on default page.
     *
     * @param summary message content
     */
    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Get page name and perform redirect.
     *
     * @return page name
     */
    public String income() {
        return "/index?faces-redirect=true";
    }

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }
}
