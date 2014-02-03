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

    public ListController() {
        list = new ArrayList<TemplateBean>();
        //TODO
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
    public void addTemplate(TemplateBean template) {
        this.list.add(template);
        if (filteredList != null)
            filteredList.add(template);
        sort();
    }

    public void addAllTemplates(List<TemplateBean> templateBeanList) {
        this.list.addAll(templateBeanList);
        if (filteredList != null)
            filteredList.addAll(templateBeanList);
        sort();
    }

    /**
     * deleting Template from list
     *
     * @param template to be deleted
     *
     * @author dmytro.sorych
     */
    public void deleteTemplate(TemplateBean template) {
        list.remove(template);
        if(filteredList!=null)
            filteredList.remove(template);
    }

    public void sort() {
        Collections.sort(list);
        if (filteredList != null)
            Collections.sort(filteredList);
    }

    //operations on current template
    public void clone(TemplateBean template) throws CloneNotSupportedException {
        TemplateBean newTemplate = (TemplateBean) template.clone();
        addTemplate(newTemplate);
    }

    /**
     * deleting Template from list
     *
     * @param template to be deleted
     * @author dmytro.sorych
     */
    public void delete(TemplateBean template) {
        list.remove(template);
        if (filteredList != null)
            filteredList.remove(template);
    }

    //exporting/importing XML
    public void exportToXML() {
        addMessage("Data exported");
    }

    public void importFromXML() {
        addMessage("Data imported");
        addAllTemplates(XmlImportExport.importXmlTemplate(xmlPath));
    }

    //messaging

    /**
     * showing message on delete popup
     *
     * @param template
     * @return String message to display
     * @author dmytro.sorych
     */
    public String getMessageOnDelete(TemplateBean template) {
        if (template == null)
            return "";
        if (template.getTemplateName() == null)
            return "";
        return "Please confirm deleting of " + template.getTemplateName();
    }

    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    //income
    public String income() {
        return "/index?faces-redirect=true";
    }
}
