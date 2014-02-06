package com.engagepoint.bean;
import com.engagepoint.controller.GroupController;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 1/31/14
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */


import javax.enterprise.context.SessionScoped;

import javax.faces.context.FacesContext;


import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import com.engagepoint.controller.ListController;
import com.engagepoint.controller.TemplateController;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@Named
@SessionScoped
public class TreeBean implements Serializable {

    private TreeNode root;
    private TreeNode selectedNode;

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public TreeBean() {
        root = new DefaultTreeNode("Root", null);
        ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
        setNodes(nodeList);
    }

    public void setNodes(ArrayList<TreeNode> nodes) {
        //To work with sections of templates we need to call listController which contains the information
        //about all the templates we have and inner parameters including sections, groups, questions e.t.c.
        ListController listController = new ListController();
        List<TemplateBean> templateBeanList = listController.getTemplates();
        List<SectionBean> sectionBeanArrayList = templateBeanList.get(0).getSectionsList();

        //We are adding all sections from the sections list of current template.
        //section ID created using number of section in list and some string
        for(int i=0; i<sectionBeanArrayList.size(); i++) {
            Integer sectionNumber = sectionBeanArrayList.get(i).getPageNumber();
            String sectionID = "SECTION" + sectionNumber.toString();
            TreeNode section = new DefaultTreeNode(sectionID, getRoot());
            nodes.add(section);
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

    public String editSelectedGroup(){
        GroupController controller = new GroupController();
            if (selectedNode != null && selectedNode.getData().toString().contains("Group")){
                return controller.income();
            }
            else{
            FacesMessage errorMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "You've chosen not a group or more than one group");
            FacesContext.getCurrentInstance().addMessage(null, errorMessage);
            }

        return null;
    }
}