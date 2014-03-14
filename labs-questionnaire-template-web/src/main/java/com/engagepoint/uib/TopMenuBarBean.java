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
    private static final String STYLE_CLASS = "active";

    @PostConstruct
    public void initModel() {
        model = new DefaultMenuModel();
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        String viewId = viewRoot.getViewId();

        MenuItem menuItem = new MenuItem();
        menuItem.setId("bootstrapItem");
        if (viewId.startsWith("/bootstrap")) {
            menuItem.setStyleClass(STYLE_CLASS);
        }
        menuItem.setValue("But but 1");
        menuItem.setUrl("/bootstrap/button/index.xhtml");
        model.addMenuItem(menuItem);

        menuItem = new MenuItem();
        menuItem.setId("demoItem");
        if (viewId.startsWith("/demo")) {
            menuItem.setStyleClass(STYLE_CLASS);
        }
        menuItem.setValue("But but 2");
        menuItem.setUrl("/demo/default.xhtml");
        model.addMenuItem(menuItem);

        menuItem = new MenuItem();
        menuItem.setId("toolsItem");
        if (viewId.startsWith("/tools")) {
            menuItem.setStyleClass(STYLE_CLASS);
        }
        menuItem.setValue("But but 3");
        menuItem.setUrl("/tools/grid/index.xhtml");
        model.addMenuItem(menuItem);
    }

    public MenuModel getModel() {
        return model;
    }
}
