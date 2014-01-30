package com.engagepoint.controller;


import com.engagepoint.bean.TemplateBean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean
@SessionScoped
public class SessionController implements Serializable {

    private List<TemplateBean> list;
    private TemplateBean currentTemplate;
    private ServiceConfigProperties properties;
    private List<TemplateBean> filteredList;

    public SessionController() {
        properties = new ServiceConfigProperties();
        list = new ArrayList<TemplateBean>();
        list.add(new TemplateBean("Template D"));
        list.add(new TemplateBean("Template B"));
        list.add(new TemplateBean("Template F"));
        list.add(new TemplateBean("Template A"));
        list.add(new TemplateBean("Template E"));
        list.add(new TemplateBean("Template C"));
        Collections.sort(list);
    }

    public List<TemplateBean> getTemplates() {
        return list;
    }

    public void setTemplates(List<TemplateBean> list) {
        this.list = list;
    }

    public TemplateBean getCurrentTemplate() {
        return currentTemplate;
    }

    public void setCurrentTemplate(TemplateBean currentTemplate) {
        this.currentTemplate = currentTemplate;
    }


    public int getProperties() {
        return properties.getPagesCount();
    }

    public void clone(TemplateBean template) {
        list.add((TemplateBean) template);
        if(filteredList!=null)
            filteredList.add(template);
        sort();
    }
    
    /**
	 * deleting Template from list
	 * 
	 * @param template to be deleted
	 * 
	 * @author dmytro.sorych
	 */
	public void delete(TemplateBean template) {
		list.remove(template);
        if(filteredList!=null)
            filteredList.remove(template);
	}

    public List<TemplateBean> getFilteredTemplates() {
        return filteredList;
    }

    public void setFilteredTemplates(List<TemplateBean> filteredList) {
        this.filteredList = filteredList;
    }
	
	/**
	 * showing message on delete popup
	 * 
	 * @param template
	 * 
	 * @return String message to display
	 * 
	 * @author dmytro.sorych
	 */
	public String showMessageOnDelete(TemplateBean template) {
		if (template==null)
			return "";
		if (template.getTemplateName()==null)
			return "";
		return "Please confirm deleting of "+template.getTemplateName();
	}

    /**
     * operations before editing a template
     *
     * @param event
     *
     * @author anna.zagrebelnaya
     */
    public void edit(ActionEvent event) {
        TemplateBean template = (TemplateBean) event.getComponent().getAttributes().get("template");
        setCurrentTemplate(template);
    }


    private void sort(){
        Collections.sort(list);
        if(filteredList!=null)
            Collections.sort(filteredList);
    }

    public void exportToXML() {
        //Код для экпорта в XML
        addExportInfo();
    }

    // Метод для добавления всплывающего сообщения File exported
    private void addExportInfo() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"File exported", "PrimeFaces rocks!"));
    }

    public void importFromXML() {
        // Код, отвечающий за импорт файла с диска.
        addImportInfo();
    }

    // Метод для добавления всплывающего сообщения File imported
    private void addImportInfo() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"File imported", "PrimeFaces rocks!"));
    }
}
