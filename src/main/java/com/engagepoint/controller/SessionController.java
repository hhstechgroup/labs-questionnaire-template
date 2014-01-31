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
public class SessionController implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<TemplateBean> list;
    private TemplateBean currentTemplate;
    private ServiceConfigProperties properties;
    private List<TemplateBean> filteredList;
    private String xmlPath;
    private boolean showNewQuestionForm;
    
    public SessionController() {
        properties = new ServiceConfigProperties();
        list = new ArrayList<TemplateBean>();
        list.add(new TemplateBean("Template D"));
        list.add(new TemplateBean("Template B"));
        list.add(new TemplateBean("Template F"));
        list.add(new TemplateBean("Template A"));
        list.add(new TemplateBean("Template E"));
        list.add(new TemplateBean("Template C"));
        list.add(new TemplateBean("Template C"));
        //TODO
        //searching path of XML file in glassfish
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        xmlPath = classLoader.getResource("Questionnaire.xml").getPath();
        //adding Templates from XML file

        //replaced list.addAll to public void importFromXML()
        Collections.sort(list);
    }

    public boolean isShowNewQuestionForm() {
		return showNewQuestionForm;
	}

	public void setShowNewQuestionForm(boolean showNewQuestionForm) {
		this.showNewQuestionForm = showNewQuestionForm;
	}

	public void changeEditable() {
		this.showNewQuestionForm = true;
	}

	public List<TemplateBean> getTemplates() {
        return list;
    }

    public void setTemplates(List<TemplateBean> list) {
        this.list = list;
    }

    public int getProperties() {
        return properties.getPagesCount();
    }

    public void clone(TemplateBean template) throws CloneNotSupportedException {
        list.add((TemplateBean) template.clone());
        if (filteredList != null)
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

    public void sort() {
        Collections.sort(list);
        if (filteredList != null)
            Collections.sort(filteredList);
    }


    public void exportToXML() {
        addMessage("Data exported");
    }

    public void importFromXML() {
        addMessage("Data imported");
        list.addAll(XmlImportExport.importXmlTemplate(xmlPath));
    }

    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public String income() {
        return "/index?faces-redirect=true";
    }
}
