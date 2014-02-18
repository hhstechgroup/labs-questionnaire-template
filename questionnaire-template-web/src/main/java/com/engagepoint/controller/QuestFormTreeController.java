package com.engagepoint.controller;

import com.engagepoint.bean.*;

import javax.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;


/**
 * Use for control
 *
 * @version 1.0
 */

@Named
@SessionScoped
public class QuestFormTreeController implements Serializable {

    private static final long serialVersionUID = 1L;
    private TreeNode root = new DefaultTreeNode("Root", null);
    private TreeNode selectedNode;
    private TemplateBean templateBean;
    private QuestionBean addedquestion;
    private TemplateBean duplicateTemplate;
    @Inject
    private QuestFormController questFormController;

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

    /**
     * There is no need to pass an argument to this method now. It's done via CDI
     *
     * @param templateBean
     */
    public void setTemplateBean(TemplateBean templateBean) {
        this.templateBean = questFormController.getCurrentTemplate();
        try {
            duplicateTemplate = this.templateBean.duplicate();
        } catch (CloneNotSupportedException e) {
            //NOP
        }
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

    /**
     * Add group to template.
     *
     * @return next page
     */
    private String addGroup() {
        GroupBean groupBean = new GroupBean();
        groupBean.setGroupName("GROUP_" + (selectedNode.getChildCount() + 1));
        //adding group to the tree
        TreeNode node = new DefaultTreeNode(groupBean, selectedNode);
        //adding group to templateBean
        ((SectionBean) selectedNode.getData()).getGroupsList().add(groupBean);
        return null;
    }


    /**
     * adding new QuestionBean to the group and redirect to questionedit.xhtml page where this QestionBean will be edited
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

    /**
     * duplicateTemplate - is old template before editing( same ID, etc).
     * But the address in memory is differ(two instance that match each other via equals).
     * So, in case, if this is existing template, there is need to delete edited templateBean
     * in ListControler, in order not to have them both, ot other kind of ambiguity.
     * And if this is new, not yet saved template, just skip saving.
     *
     * @return index page
     */
    public String cancel() {
        boolean isNew = questFormController.isNew();
        questFormController.getListController().deleteTemplate(templateBean);
        if (!isNew) {
            questFormController.setCurrentTemplate(duplicateTemplate);
            questFormController.setTemplateName(duplicateTemplate.getTemplateName());
            questFormController.saveTemplate();
        }
        return ListController.income();
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

}
