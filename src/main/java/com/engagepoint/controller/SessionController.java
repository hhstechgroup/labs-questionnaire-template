package com.engagepoint.controller;


import beans.TemplateBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaroslav.nikolaiko on 1/28/14.
 */

@ManagedBean
@SessionScoped
public class SessionController implements Serializable {

    private List<TemplateBean> list;

    public SessionController() {
        list = new ArrayList<TemplateBean>();
        list.add(new TemplateBean("A"));
        list.add(new TemplateBean("B"));
        list.add(new TemplateBean("C"));
    }

    public List<TemplateBean> getTemplates() {
        return list;
    }

    public void setTemplates(List<TemplateBean> list) {
        this.list = list;
    }
}


