package com.engagepoint.controller;


import com.engagepoint.bean.TemplateBean;
import com.engagepoint.utils.XmlImportExport;
import com.engagepoint.model.TemplateDataModel;
import org.primefaces.event.FileUploadEvent;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;

@Named
@SessionScoped
public class ListController implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<TemplateBean> list;
    private List<TemplateBean> filteredList;
    private List<TemplateBean> selectedTemplates;

    private TemplateDataModel templatesModel;

    private String filterValue = "";

    public ListController() {
        list = new ArrayList<TemplateBean>();
        //searching path of XML file in glassfish
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String xmlPath = classLoader.getResource("Questionnaire.xml").getPath();
        //adding Templates from XML file
        addAllTemplates(XmlImportExport.importXmlTemplate(xmlPath));

        templatesModel = new TemplateDataModel(list);
    }

    public TemplateDataModel getTemplatesModel() {
        return templatesModel;
    }

    //operations on list
    public List<TemplateBean> getTemplates() {
        return list;
    }

    public void setTemplates(List<TemplateBean> list) {
        this.list = list;
    }

    public List<TemplateBean> getSelectedTemplates() {
        return selectedTemplates;
    }

    public void setSelectedTemplates(List<TemplateBean> selectedTemplates) {
        this.selectedTemplates = selectedTemplates;
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

    private boolean containsFiltered(String name) {
        return name.toLowerCase().contains(filterValue.toLowerCase());
    }

    //operations on both lists

    /**
     * Add template.
     *
     * @param template template to be added
     */
    public void addTemplate(TemplateBean template) {
        if (this.list.contains(template)) { //check if template with the same id exists
            //addMessage("Template with id " + template.getId().toString() + " already exists");
            return;
        }
        this.list.add(template);
    }

    /**
     * Add template and update lists.
     *
     * @param template template to be added
     */
    public void addTemplateAndUpdateLists(TemplateBean template) {
        addTemplate(template);
        addTemplateToFilteredList(template);
        templatesModel = new TemplateDataModel(list);
        sort();
    }

    /**
     * Add template to filtered list.
     *
     * @param template template to be added
     */
    public void addTemplateToFilteredList(TemplateBean template) {
        if (filteredList != null) {
            if (filteredList.contains(template)) {//check if template with the same id exists
                return;
            }
            else {
                if (containsFiltered(template.getTemplateName())) //check if template satisfies current filter
                    filteredList.add(template);
                else {
                    //addMessage("changesDontSatisfyFilter");
                }
            }
        }
    }

    /**
     * Add template to filtered list.
     *
     * @param template template to be added
     */
    public void removeTemplateFromFilteredList(TemplateBean template) {
        if (filteredList != null) {
            if (!containsFiltered(template.getTemplateName())) {
                filteredList.remove(template);
                //addMessage("changesDontSatisfyFilter");
            }
        }
    }

    /**
     * Add templates.
     *
     * @param templateBeanList template list to be added
     */
    public void addAllTemplates(List<TemplateBean> templateBeanList) {
        for (TemplateBean templateBean : templateBeanList) {
            addTemplate(templateBean);
            addTemplateToFilteredList(templateBean);
        }
        templatesModel = new TemplateDataModel(list);
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
        removeTemplateFromFilteredList(template);
    }

    /**
     * Clone template.
     *
     * @param template template to be clonned
     * @throws CloneNotSupportedException
     */
    public void clone(TemplateBean template) throws CloneNotSupportedException {
        TemplateBean newTemplate = (TemplateBean) template.clone();
        newTemplate.setTemplateName(newTemplate.getTemplateName() + " - clone");
        addTemplate(newTemplate);
    }

    /**
     * Create temporary XML file before downloading
     */
    public void onExportXML() {
        Collections.sort(selectedTemplates);
        try {
            File tmpFile = FileController.createTempXml(selectedTemplates);
            FileController.setPathToTempFile(tmpFile.getPath());
        }
        catch(IOException e) {

        }
    }

    /**
     * Perform import questionnaire from XML file.
     */
    public void importFromXML(FileUploadEvent event) throws IOException {
        addAllTemplates(XmlImportExport.importXmlTemplate(event.getFile().getInputstream()));
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
     * @param resourceBundleKey  key of resource bundle
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
