package com.engagepoint.uib;

import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean(name = "topMenuBar")
@RequestScoped
public class TopMenuBarBean {

    private MenuModel model;

    @PostConstruct
    public void initModel() {
        model = new DefaultMenuModel();
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        String viewId = viewRoot.getViewId();
        addMenuItem(viewId, "bootstrapItem", "/bootstrap", "Team A", "/bootstrap/button/index.xhtml");
        addMenuItem(viewId, "demoItem", "/demo", "Questionnaire", "/demo/default.xhtml");
        addMenuItem(viewId, "toolsItem", "/tools", "Editor", "/tools/grid/index.xhtml");
    }

    public MenuModel getModel() {
        return model;
    }

    private void addMenuItem(String viewId, String id, String startsWith, String value, String url) {
        MenuItem menuItem = new MenuItem();
        menuItem.setId(id);
        if (viewId.startsWith(startsWith)) {
            menuItem.setStyleClass("active");
        }
        menuItem.setValue(value);
        menuItem.setUrl(url);
        model.addMenuItem(menuItem);
    }
}
