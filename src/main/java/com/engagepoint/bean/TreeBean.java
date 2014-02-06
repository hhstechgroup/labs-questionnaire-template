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

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@Named
@SessionScoped
public class TreeBean implements Serializable {

    private TreeNode root = new DefaultTreeNode("Root",null);

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
        TreeNode section1 = new DefaultTreeNode("Section 1", getRoot());
        TreeNode section2 = new DefaultTreeNode("Section 2", getRoot());
        TreeNode section3 = new DefaultTreeNode("Section 3", getRoot());
        nodes.add(section1);
        nodes.add(section2);
        nodes.add(section3);
        nodes.add(new DefaultTreeNode("Group 1", section1));
        nodes.add(new DefaultTreeNode("Group 2", section1));
        nodes.add(new DefaultTreeNode("Group 3", section2));

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