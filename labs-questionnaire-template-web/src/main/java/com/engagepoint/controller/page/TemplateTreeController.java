package com.engagepoint.controller.page;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.engagepoint.model.question.Question;
import com.engagepoint.model.questionnaire.BasicBean;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.SectionBean;
import com.engagepoint.model.questionnaire.TemplateBean;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * Used for controlling tree on templateEdit.xhtml
 */
@Named
@SessionScoped
public class TemplateTreeController implements Serializable {

    private static final long serialVersionUID = 1L;
    private TreeNode root = new DefaultTreeNode("Root", null);
    private TreeNode selectedNode;
    // instead of method getSelectedType() to make
    private String selectedType;
    // code more clear
    // it is initialized in method onSelect
    private TemplateBean templateBean;
    private SectionBean currentSection;
    private GroupBean currentGroup;
    private Question currentQuestion;

    private String nameOfCurrentNode = "";

	public TreeNode getRoot() {
		return root;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public String getSelectedType() {
		return selectedType;
	}

	public TemplateBean getTemplateBean() {
		return templateBean;
	}

	public void setTemplateBean(TemplateBean templateBean) {
		this.templateBean = templateBean;
		setNodes();
	}

    public GroupBean getCurrentGroup() {
        return currentGroup;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

    public String getNameOfCurrentNode() {
        return nameOfCurrentNode;
    }

    public void setNameOfCurrentNode(String nameOfCurrentNode) {
        this.nameOfCurrentNode = nameOfCurrentNode;
    }

    /**
     * When some node is selected, we can verify
     * selected type, current group and current section.
     * Then it's more clear, what we are working with at the moment.
     */
    public void onSelect() {
        selectedType = ((BasicBean) selectedNode.getData()).getType();
        if ("question".equals(selectedType)) {
            currentQuestion = (Question) selectedNode.getData();
            //check if current group has not been changed
            GroupBean groupBean = (GroupBean) selectedNode.getParent().getData();
            if (currentGroup==null || !currentGroup.equals(groupBean)) {
                currentGroup = groupBean;
            }
            //check if current section has not been changed
            SectionBean sectionBean = (SectionBean) selectedNode.getParent().getParent().getData();
            if (currentSection==null || !currentSection.equals(sectionBean)) {
                currentSection = sectionBean;
            }
        } else if ("group".equals(selectedType)) {
            currentQuestion = null;
            currentGroup = (GroupBean) selectedNode.getData();
            nameOfCurrentNode = currentGroup.getGroupName();
            //check if current section has not been changed
            SectionBean sectionBean = (SectionBean) selectedNode.getParent().getData();
            if (currentSection==null || !currentSection.equals(sectionBean)) {
                currentSection = sectionBean;
            }
        } else {
            currentQuestion = null;
            currentGroup = null;
            currentSection = (SectionBean) selectedNode.getData();
            nameOfCurrentNode = currentSection.getPageName();
        }
    }

    /**
     * Style of selected node
     */
    public String getStyle(Object node) {
        if (selectedNode != null && selectedNode.getData().equals(node)) {
            return "color:white;background:#0075ac;";
        }
        return "";
    }

    public void setNodes() {
        root = new DefaultTreeNode("Root", null);
        // Iterator LEVEL_0 for filling sections of choosed template
        for (SectionBean sectionBean : templateBean.getSectionsList()) {
            TreeNode section = new DefaultTreeNode(sectionBean, root);
            // Iterator LEVEL_1 for filling groups of choosed section
            for (GroupBean groupBean : sectionBean.getGroupsList()) {
                TreeNode group = new DefaultTreeNode(groupBean, section);
                // Iterator LEVEL_2 for filling questions of choosed section
                for (Question question : groupBean.getQuestionsList()) {
                    new DefaultTreeNode(question, group);
                } // END of QUESTION Iterator
            } // END of GROUP Iterator
        } // END of SECTION Iterator

    } // END of setNodes() METHOD

    /**
     * Create new section and add it to current template.
     */
    public void addSection() {
        new SectionBean(templateBean);
        setNodes();
    }

    /**
     * Create new group and add it to current section.
     */
    public void addGroup() {
        new GroupBean(currentSection);
        setNodes();
    }

    /**
     * Delete selected section, group or question
     */
    public void delete() {
        if ("group".equals(selectedType)) {
            currentSection.deleteFromInnerList(currentGroup);
        } else if ("question".equals(selectedType)) {
            currentGroup.deleteFromInnerList(currentQuestion);
        } else {
            templateBean.deleteFromInnerList(currentSection);
        }
        setNodes();
        selectedNode = null;
    }

    /**
     * Add current question to current group bean
     */
    public void addQuestionToCurrentGroup() {
        if (currentGroup != null) {
            currentGroup.addToInnerList(currentQuestion);
            setNodes();
        }
    }

    /**
     * checks if EDIT button is rendered for this treenode object.
     *
     * @param tr object in tree node
     * @return true only for selected node if it is group or section
     */
    public boolean editButtonRendering(Object tr) {
        if (selectedNode != null) {
            selectedType = ((BasicBean) selectedNode.getData()).getType();
            if ("question".equals(selectedType)) {
                return false;
            }
            return selectedNode.getData().equals(tr);
        }
        return false;
    }

    public void revertNameOfCurrentNode() {
        if ("section".equals(selectedType)) {
            setNameOfCurrentNode(currentSection.getPageName());
        } else if ("group".equals(selectedType)) {
            setNameOfCurrentNode(currentGroup.getGroupName());
        }

    }

    public void commitNameOfCurrentNode() {
        if ("section".equals(selectedType)) {
            currentSection.setPageName(nameOfCurrentNode);
        } else if ("group".equals(selectedType)) {
            currentGroup.setGroupName(nameOfCurrentNode);
        }
        revertNameOfCurrentNode();
    }
}
