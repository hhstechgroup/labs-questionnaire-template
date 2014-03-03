package com.engagepoint.controller.page;

import javax.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.engagepoint.model.question.QuestionBean;
import com.engagepoint.model.questionnaire.BasicBeanProperty;
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
            if (currentGroup != groupBean) {
                currentGroup = groupBean;
            }
            //check if current section has not been changed
            SectionBean sectionBean = (SectionBean) selectedNode.getParent().getParent().getData();
            if (currentSection != sectionBean) {
                currentSection = sectionBean;
            }
        } else if (selectedType.equals("group")) {
            currentQuestion = null;
            currentGroup = (GroupBean) selectedNode.getData();
            //check if current section has not been changed
            SectionBean sectionBean = (SectionBean) selectedNode.getParent().getData();
            if (currentSection != sectionBean) {
                currentSection = sectionBean;
            }
        } else {
            currentQuestion = null;
            currentGroup = null;
            currentSection = (SectionBean) selectedNode.getData();
        }
    }

    /**
     * Style of selected node
     */
    public String getStyle(Object node) {
        if (selectedNode != null) {
            if (selectedNode.getData() == node) {
                return "color:white;background:#0075ac;";
            }
        }
        return "";
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

    /**
     * Create new section and add it to current template.
     *
     * @return next page
     */
    public void addSection() {
        FacesMessage msg = new FacesMessage("Selected");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        SectionBean sectionBean = new SectionBean();
        sectionBean.setPageNumber(templateBean.getSectionsList().size() + 1);
        templateBean.getSectionsList().add(sectionBean);
        setNodes();
    }

    /**
     * Create new group and add it to current section.
     *
     * @return next page
     */
    public String addGroup() {
        GroupBean groupBean = new GroupBean();
        groupBean.setGroupName("GROUP_" + (currentSection.getGroupsList().size() + 1));
        addGroupToCurrentSection(groupBean);
        return null;
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
     *
     * @param groupBean
     */
    public void addGroupToCurrentSection(GroupBean groupBean) {
        if (currentSection != null && !currentSection.getGroupsList().contains(groupBean)) {
            currentSection.addToInnerList(groupBean);
            setNodes();
        }
    }

    /**
     * Add current question to current group bean
     */
    public void addQuestionToCurrentGroup() {
        if (currentGroup != null) {
            currentQuestion.setId(getNextQuestionIdInCurrentGroup());
            currentGroup.addToInnerList(currentQuestion);
            setNodes();
        }
    }

    /**
     * Gets next id for current group
     * @return QuestionId
     */
    public long getNextQuestionIdInCurrentGroup() {
        if (currentGroup.getQuestionsList().isEmpty()) {
            return 1L;
        }
        else {
            return ((currentGroup.getQuestionsList().get(currentGroup.getQuestionsList().size()-1)).getId()+1);
        }
    }


}