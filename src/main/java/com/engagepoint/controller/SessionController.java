package com.engagepoint.controller;


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

    private List<Template> list;

    public SessionController() {
        list = new ArrayList<Template>();
        list.add(new Template("A"));
        list.add(new Template("B"));
        list.add(new Template("C"));
    }

    public List<Template> getTemplates() {
        return list;
    }

    public void setList(List<Template> list) {
        this.list = list;
    }
}


