package com.engagepoint.controller;


import com.engagepoint.bean.TemplateBean;
import com.engagepoint.utils.XmlImportExport;
import com.engagepoint.model.TemplateDataModel;
import org.primefaces.event.FileUploadEvent;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

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

    private String xmlPath;

    private String exportFileName;

    private String exportDirectoryName;

    private String filterValue = "";

    public ListController() {
        list = new ArrayList<TemplateBean>();
        //searching path of XML file in glassfish
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        xmlPath = classLoader.getResource("Questionnaire.xml").getPath();
        //adding Templates from XML file
        addAllTemplates(XmlImportExport.importXmlTemplate(xmlPath));

        templatesModel = new TemplateDataModel(list);
    }

    public String getExportFileName() {
        return exportFileName;
    }

    public void setExportFileName(String exportFileName) {
        this.exportFileName = exportFileName;
    }

    public String getExportDirectoryName() {
        return exportDirectoryName;
    }

    public void setExportDirectoryName(String exportDirectoryName) {
        this.exportDirectoryName = exportDirectoryName;
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
        this.list.add(template);
        addTemplateToFilteredList(template);
        sort();
    }

    /**
     * Add template to filtered list.
     *
     * @param template template to be added
     */
    public void addTemplateToFilteredList(TemplateBean template) {
        if (filteredList != null) {
            if (containsFiltered(template.getTemplateName()))
                filteredList.add(template);
            else {
                //addMessage("changesDontSatisfyFilter");
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
        this.list.addAll(templateBeanList);
        for (TemplateBean templateBean : templateBeanList) {
            addTemplateToFilteredList(templateBean);
        }
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
        addTemplate(newTemplate);
    }

    /**
     * Perform export selected questionnairies to one XML file.
     */
    public void exportSelectedToOneXML() {
        Collections.sort(selectedTemplates);
        XmlImportExport.exportXmlTemplates(selectedTemplates, getResourceBundleString("config", "pathForXMLs") + exportFileName + ".xml");
        addMessage("dataExported");
        selectedTemplates.clear();
    }

    /**
     * Perform export selected questionnairies to separate XML files.
     */
    public void exportSelectedToSeparateXMLs() {
        Collections.sort(selectedTemplates);
        String directoryPath = getResourceBundleString("config", "pathForXMLs") + exportDirectoryName;

        //create directory
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (!directory.mkdir()) {
                addMessage("dataNotExported");
                return;
            }
        }

        for (TemplateBean template : selectedTemplates) {
            String filePath = directoryPath + "//" + template.getTemplateName() + ".xml";

            //create file if not exists
            File file = new File(filePath);
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    addMessage("dataNotExported");
                    return;
                }
            }
            XmlImportExport.exportXmlTemplate(template, filePath);
        }

        addMessage("dataExported");
        selectedTemplates.clear();
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
