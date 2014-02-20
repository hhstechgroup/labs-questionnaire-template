package com.engagepoint.controller;

import com.engagepoint.bean.*;

import javax.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.ArrayList;

import javax.inject.Named;

import com.engagepoint.bean.QuestionBeans.QuestionBean;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;


/**
 * Used for controlling tree on questForm.xhtml
 */

@Named
@SessionScoped
public class QuestFormTreeController implements Serializable {

    private static final long serialVersionUID = 1L;
    private TreeNode root = new DefaultTreeNode("Root", null);
    private TreeNode selectedNode;
    private String selectedType; //instead of method getSelectedType() to make code more clear
                                 //it is initialized in method onSelect

    private TemplateBean templateBean;
    private SectionBean currentSection;
    private GroupBean currentGroup;
    private QuestionBean currentQuestion;

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

    public QuestionBean getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(QuestionBean currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    /**
     * When some node is selected, we can verify
     * selected type, current group and current section.
     * Then it's more clear, what we are working with at the moment.
     */
    public void onSelect() {
        selectedType = ((BasicBeanProperty) selectedNode.getData()).getType();
        if (selectedType.equals("question")) {
            QuestionBean questionBean = (QuestionBean) selectedNode.getData();
            currentQuestion = questionBean;
            //check if current group has not been changed
            GroupBean groupBean = (GroupBean) selectedNode.getParent().getData();
            if (currentGroup!=groupBean) {
                currentGroup=groupBean;
            }
            //check if current section has not been changed
            SectionBean sectionBean = (SectionBean) selectedNode.getParent().getParent().getData();
            if (currentSection!=sectionBean) {
                currentSection=sectionBean;
            }
        } else if (selectedType.equals("group")) {
            currentGroup = (GroupBean) selectedNode.getData();
            //check if current section has not been changed
            SectionBean sectionBean = (SectionBean) selectedNode.getParent().getData();
            if (currentSection!=sectionBean) {
                currentSection=sectionBean;
            }
        } else {
            currentSection = (SectionBean) selectedNode.getData();
        }
    }

    public String getEditTitle() {
        if (selectedType.equals("question")) {
            return "Edit question";
        } else if (selectedType.equals("group")) {
            return "Add question";
        } else {
            return "Add group";
        }
    }

    public String getEditPicture() {
        if (selectedType.equals("question")) {
            return "ui-icon-edit";
        } else {
            return "ui-icon-add-v2";
        }
    }

    /** Style of selected node */
    public String getStyle(Object node) {
        if (selectedNode != null) {
            if (selectedNode.getData() == node) {
                return "color:white;background:#0075ac;";
            }
        }
        return "";
    }

    public boolean haveSelected() {
        return selectedNode != null;
    }

    public void setNodes() {
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

    public String edit() {
        if (selectedType.equals("question")) {
            return editQuestion();
        } else if (selectedType.equals("group")) {
            return addQuestion();
        } else {
            return addGroup();
        }

    }

    /**
     * Create new section and add it to current template.
     *
     * @return next page
     */
    public void addSection() {
        SectionBean sectionBean = new SectionBean();
        sectionBean.setPageNumber(templateBean.getSectionsList().size()+1);
        templateBean.getSectionsList().add(sectionBean);
        setNodes();
    }

    /**
     * Create new group and add it to current section.
     *
     * @return next page
     */
    private String addGroup() {
        GroupBean groupBean = new GroupBean();
        groupBean.setGroupName("GROUP_" + (currentSection.getGroupsList().size() + 1));
        addGroupToCurrentSection(groupBean);
        return null;
    }

    /**
     * Redirect to questionedit.xhtml page where new QuestionBean
     * will be created and edited
     */
    private String addQuestion() {
        if (selectedType.equals("group")) {
            return "questionedit?faces-redirect=true&includeViewParams=true";
        }
        //TODO ????
        return null;
    }

    /**
     * Redirect to questionedit.xhtml page where new QuestionBean
     * will be edited
     */
    private String editQuestion() {
        return "/question-pages/chooseFromList?faces-redirect=true&includeViewParams=true";
    }

    /**
     * Delete selected section, group or question
     */
    public void delete() {
        if (selectedType.equals("group")) {
            currentSection.deleteFromInnerList(currentGroup);
        } else if (selectedType.equals("question")) {
            currentGroup.deleteFromInnerList(currentQuestion);
        } else {
            templateBean.deleteFromInnerList(currentSection);
        }
        setNodes();
        selectedNode = null;
    }

    /**
     * Add group to current section bean
     * @param groupBean
     */
    public void addGroupToCurrentSection(GroupBean groupBean) {
        if (currentSection!=null && !currentSection.getGroupsList().contains(groupBean)) {
            currentSection.addToInnerList(groupBean);
            setNodes();
        }
    }

    /**
     * Add question to current group bean
     * @param questionbean
     */
    public void addQuestionToCurrentGroup(QuestionBean questionbean) {
        if (currentGroup!=null && !currentGroup.getQuestionsList().contains(questionbean)) {
            currentGroup.addToInnerList(questionbean);
            setNodes();
        }
    }





}
