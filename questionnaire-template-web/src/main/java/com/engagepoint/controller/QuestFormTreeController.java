package com.engagepoint.controller;

import com.engagepoint.bean.*;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.inject.Named;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@Named
@SessionScoped
public class QuestFormTreeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TreeNode root = new DefaultTreeNode("Root", null);
	private TreeNode selectedNode;
	private TemplateBean templateBean;
	
	private QuestionBean addedquestion;

	public String getSelectedType() {
		return ((BasicBeanProperty) selectedNode.getData()).getType();
	}

	public String getEditTitle() {
		if (getSelectedType().equals("question")) {
			return "Edit question";
		} else if (getSelectedType().equals("group")) {
			return "Add question";
		} else {
			return "Add group";
		}
	}

	public String getEditPicture() {
		if (getSelectedType().equals("question")) {
			return "ui-icon-edit";
		} else {
			return "ui-icon-add-v2";
		}
	}

	public boolean haveSelected() {
		return selectedNode != null;
	}

	public TemplateBean getTemplateBean() {
		return templateBean;
	}

	public void setTemplateBean(TemplateBean templateBean) {
		this.templateBean = templateBean;
		setNodes();
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public QuestionBean getAddedquestion() {
		return addedquestion;
	}

	public void setAddedquestion(QuestionBean addedquestion) {
		this.addedquestion = addedquestion;
		addQuestionToNode(addedquestion);
	}

	/**
	 * if currentnode is group add question to group and rebuild tree
	 * 
	 * @param questionbean
	 */
	private void addQuestionToNode(QuestionBean questionbean) {
		if (getSelectedType().equals("group")) {
			((GroupBean) selectedNode.getData()).addToInnerList(addedquestion);
			setNodes();
		}
	}

	private void setNodes() {
		root = new DefaultTreeNode("Root", null);
		ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();

		// Iterator LEVEL_0 for filling sections of choosed template
		for (SectionBean sectionBean : templateBean.getSectionsList()) {
			TreeNode section = new DefaultTreeNode(sectionBean, root);

			// Iterator LEVEL_1 for filling groups of choosed section
			for (GroupBean groupBean : sectionBean.getGroupsList()) {
				TreeNode group = new DefaultTreeNode(groupBean, section);

				// Iterator LEVEL_2 for filling questions of choosed section
				for (QuestionBean questionBean : groupBean.getQuestionsList()) {
					new DefaultTreeNode(questionBean, group);
				} // END of QUESTION Iterator
			} // END of GROUP Iterator
		} // END of SECTION Iterator

	} // END of setNodes() METHOD

	public TreeNode getRoot() {
		return root;
	}

	public String edit() {
		if (getSelectedType().equals("question")) {
			return editQuestion();
		} else if (getSelectedType().equals("group")) {
			return addQuestion();
		} else {
			return addGroup();
		}

	}

	private String addGroup() {
		return null;
		// TODO Auto-generated method stub
		
	}

	/**
	 * adding new QuestionBean to the group and redirect to questionedit.xhtml page where this QestionBean will be edited
	 * 
	 */
	private String addQuestion() {
		if (getSelectedType().equals("group")) {
			return "questionedit?faces-redirect=true";
						
		}
		
		//TODO ????
		return null;
		
	}

	private String editQuestion() {
		return null;
		// TODO Auto-generated method stub
		
	}

	public void delete() {
		selectedNode.getParent().getChildren().remove(selectedNode);
		if (!selectedNode.getParent().getData().equals("Root")) {
			((BasicOperationWithBean) selectedNode.getParent().getData())
					.deleteFromInnerList(selectedNode.getData());
		} else {
			templateBean.deleteFromInnerList(selectedNode.getData());
		}
		selectedNode = null;
	}
}
