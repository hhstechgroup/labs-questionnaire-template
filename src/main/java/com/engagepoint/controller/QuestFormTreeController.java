package com.engagepoint.controller;

import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;
import com.engagepoint.controller.GroupController;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 1/31/14
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */


import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@Named
@SessionScoped
public class QuestFormTreeController implements Serializable {

    private TreeNode root = new DefaultTreeNode("Root", null);
    private TreeNode selectedNode;
    private TemplateBean templateBean;

    public TemplateBean getTemplateBean() {
        return templateBean;
    }

    public void setTemplateBean(TemplateBean templateBean) {
        root = new DefaultTreeNode("Root", null);
        this.templateBean = templateBean;
        setNodes();
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void setNodes() {
        for (SectionBean sectionBean : templateBean.getSectionsList()) {
            String sectionID = templateBean.getTemplateName() +
                               "_SECTION_" + sectionBean.getPageNumber();
            TreeNode section = new DefaultTreeNode(sectionID, root);
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void deleteNode() {
        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);
        selectedNode = null;
    }

    public String editSelectedGroup() {
        GroupController controller = new GroupController();
        if (selectedNode != null && selectedNode.getData().toString().contains("Group")) {
            return controller.income();
        } else {
            FacesMessage errorMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "You've chosen not a group or more than one group");
            FacesContext.getCurrentInstance().addMessage(null, errorMessage);
        }

        return null;
    }
}