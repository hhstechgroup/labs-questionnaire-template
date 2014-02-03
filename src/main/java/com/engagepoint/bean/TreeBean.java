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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@ManagedBean
@ViewScoped
public class TreeBean implements Serializable {

    private TreeNode root;

    private TreeNode selectedNode;

    public TreeBean() {
        root = new DefaultTreeNode("Sections", new SectionBean());
        TreeNode node0 = new DefaultTreeNode("Section 1", root);
        TreeNode node1 = new DefaultTreeNode("Section 2", root);
        TreeNode node2 = new DefaultTreeNode("Section 3", root);

        TreeNode node00 = new DefaultTreeNode("Group 1.1", node0);
        TreeNode node01 = new DefaultTreeNode("Group 1.2", node0);

        TreeNode node10 = new DefaultTreeNode("Group 2.1", node1);
        TreeNode node11 = new DefaultTreeNode("Group 2.2", node1);

        TreeNode node000 = new DefaultTreeNode("Question 1.1.1", node00);
        TreeNode node001 = new DefaultTreeNode("Question 1.1.2", node00);
        TreeNode node010 = new DefaultTreeNode("Question 1.1.2", node01);

        TreeNode node100 = new DefaultTreeNode("Node 1.0.0", node10);
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

    public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    public void deleteNode() {
        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);

        selectedNode = null;
    }
}