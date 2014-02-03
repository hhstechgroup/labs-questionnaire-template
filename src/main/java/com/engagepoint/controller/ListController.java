package com.engagepoint.controller;


import com.engagepoint.bean.TemplateBean;
import com.engagepoint.utils.XmlImportExport;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import java.io.Serializable;
import java.util.*;

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

    public String getFilterValue() {
        return filterValue;
    }

    public void setFilterValue(String filterValue) {
        this.filterValue = filterValue;
    }

    private boolean containsFiltered(String name){
        if( name.toLowerCase().contains(filterValue.toLowerCase()))
            return true;
        else
            return false;
    }

    //operations on both lists

    /**
     * Add template.
     *
     * @param template template to be added
     */
    public void addTemplate(TemplateBean template) {
        this.list.add(template);
        if (filteredList != null && containsFiltered(template.getTemplateName()))
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
     * Perform export questionnaire to XML file.
     */
    public void exportToXML() {
        //TODO
        addMessage("dataExported");
    }

    /**
     * Perform import questionnaire from XML file.
     */
    public void importFromXML() {
        //TODO
        addMessage("dataImported");
        addAllTemplates(XmlImportExport.importXmlTemplate(xmlPath));
    }


    /**
     * Show message on default page.
     *
     * @param propertyKey key of messages.properties
     */
    private void addMessage(String propertyKey) {
        String summary = getMessageProperty(propertyKey);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * Get message from messages.properties.
     *
     * @param propertyKey key of messages.properties
     */
    public static String getMessageProperty(String propertyKey) {
        return getResourceBundleString("msgs", propertyKey);
    }

    /**
     * Get value from resource bundle.
     *
     * @param resourceBundleName name of resource bundle
     * @param resourceBundleKey key of resource bundle
     */
    public static String getResourceBundleString(
            String resourceBundleName,
            String resourceBundleKey)
            throws MissingResourceException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ResourceBundle bundle =
                facesContext.getApplication().getResourceBundle(
                        facesContext, resourceBundleName);
        return bundle.getString(resourceBundleKey);
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
