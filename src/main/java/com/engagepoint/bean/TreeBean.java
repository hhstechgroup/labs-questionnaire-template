package com.engagepoint.bean;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 1/31/14
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean
@ViewScoped
public class TreeBean implements Serializable {

    private TreeNode root;

    private TreeNode selectedNode;
    private List<TreeNode> nodes;
    private TreeNode[] selectedNodes;


    public TreeBean() {
        nodes = new ArrayList<TreeNode>();
        root = new DefaultTreeNode("Sections", new DefaultTreeNode());
        TreeNode section1 = new DefaultTreeNode("Section 1", root);
        TreeNode section2 = new DefaultTreeNode("Section 2", root);
        TreeNode section3 = new DefaultTreeNode("Section 3", root);
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
}