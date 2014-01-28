package com.engagepoint.controller;


import beans.TemplateBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ManagedBean
@SessionScoped
public class SessionController implements Serializable {

    private List<TemplateBean> list;

    public SessionController() {
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
    
    public void delete(String templatename){
    	for (TemplateBean tb : list) {
    		if (tb.getTemplateName().equals(templatename)){
    			list.remove(tb);
    			break;
    		}
    		
    	}
    	
    }
        
}


