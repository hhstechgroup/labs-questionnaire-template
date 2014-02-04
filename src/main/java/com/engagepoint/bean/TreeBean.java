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
    private ArrayList<TreeNode> nodes;
    private TreeNode[] selectedNodes;
    private boolean flag = false;



    public TreeBean() {
        if (flag == false){
        root = new DefaultTreeNode("Root", null);
        ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
        setNodes(nodeList);
        }



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

    public TreeNode[] getSelectedNodes() {
        return selectedNodes;
    }

    public void setSelectedNodes(TreeNode[] selectedNodes) {
        this.selectedNodes = selectedNodes;
    }
    public void deleteSelectedMultiple(ActionEvent event){
       ArrayList<TreeNode> selectedNods = new ArrayList<TreeNode>();
       if (selectedNodes != null && selectedNodes.length > 0){
           for (int i = 0; i < selectedNodes.length ; i++) {
                   selectedNods.add(selectedNodes[i]);
           }
           nodes.removeAll(selectedNods);


       }

    }

    public void displaySelectedMultiple(ActionEvent event) {

        if(selectedNodes != null && selectedNodes.length > 0) {
            StringBuilder builder = new StringBuilder();

            for(TreeNode node : selectedNodes) {
                builder.append(node.getData().toString());
                builder.append("<br />");
            }

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", builder.toString());

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }


    public String editSelectedGroup(){
        GroupController controller = new GroupController();

        for (int i = 0; i <  selectedNodes.length; i++) {
            if (selectedNodes[i] != null && selectedNodes[i].getData().toString().contains("Group")){
                return controller.income();
            }
            else{
            FacesMessage errorMessage = new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "You've chosen not a group");
            FacesContext.getCurrentInstance().addMessage(null, errorMessage);
            }
    }
        return null;
    }
}