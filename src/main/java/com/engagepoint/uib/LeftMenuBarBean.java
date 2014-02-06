package com.engagepoint.uib;

import com.engagepoint.component.menu.UIMenu;
import com.engagepoint.component.menu.UIMenuSection;
import org.primefaces.component.menu.Menu;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

@ManagedBean(name = "leftMenuBar")
@RequestScoped
public class LeftMenuBarBean {

    private MenuModel model;
    private UIViewRoot viewRoot;


    @PostConstruct
    public void initModel() {
        model = new DefaultMenuModel();
        viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        String viewId = viewRoot.getViewId();

        UIMenu leftMenu = new UIMenu();
        leftMenu.setId("menu");
        leftMenu.setStyleClass("sub-navigation");

        MenuItem menuItem = new MenuItem();
        menuItem.setValue("test1");
        menuItem.setUrl("/bootstrap/button/index.xhtml");
        menuItem.setParent(leftMenu);
    }

    public MenuModel getModel() {
        return model;
    }

}
