package com.engagepoint.controller;


import com.engagepoint.bean.TemplateBean;
import com.engagepoint.utils.XmlImportExport;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean
@SessionScoped
public class ListController implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<TemplateBean> list;
    private List<TemplateBean> filteredList;
    private String xmlPath;
    //TODO
    // 1. adding to filtered list and adding to main list must be together in one method (removing too)
    // 2. in the same method must be list sorting
    // 3. there is a bug: when list is filtered, after editing or adding filter (the field) becomes empty

    public ListController() {
        list = new ArrayList<TemplateBean>();
        //searching path of XML file in glassfish
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        xmlPath = classLoader.getResource("Questionnaire.xml").getPath();
        //adding Templates from XML file
        list.addAll(XmlImportExport.importXmlTemplate(xmlPath));
        Collections.sort(list);
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

    /**
     * Add template.
     *
     * @param template template to be added
     */
    public void addTemplateToList(TemplateBean template) {
        this.list.add(template);
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
        list.add(newTemplate);
        if (filteredList != null)
            filteredList.add(newTemplate);
        sort();
    }

    /**
     * Delete template from list.
     *
     * @param template template to be deleted
     */
    public void delete(TemplateBean template) {
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
}
