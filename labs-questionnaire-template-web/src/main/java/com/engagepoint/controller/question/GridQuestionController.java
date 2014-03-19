package com.engagepoint.controller.question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.engagepoint.controller.page.QuestionEditController;
import com.engagepoint.controller.page.TemplateEditController;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.options.GridQuestionBean;

@Named
@ConversationScoped
public class GridQuestionController extends QuestionEditController implements Serializable {
    GridQuestionBean currentQuestion;
    int currentI;
    int currentJ;

    @Inject
    TemplateEditController templateEditController;

    @PostConstruct
    public void postConstruct() {
        beginConversation();
        Question question = getTemplateTreeController().getCurrentQuestion();
        if (question == null) {
            setNew(true);
            currentQuestion = new GridQuestionBean(getTemplateTreeController().getCurrentGroup());
            currentQuestion.setQuestionType(templateEditController.getSelectedQuestionType());
        } else {
            currentQuestion = (GridQuestionBean) question;
        }
    }

    public GridQuestionBean getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(GridQuestionBean currentQuestion) {
        this.currentQuestion = currentQuestion;
    }

    public List<String> getRowsSize() {
        List<String> ints = new ArrayList<String>();
        for (int i = 0; i < currentQuestion.getRows().size(); i++) {
            ints.add("" + i);
        }
        return ints;
    }

    public List<String> getColumnsSize() {
        List<String> ints = new ArrayList<String>();
        for (int i = 0; i < currentQuestion.getCols().size(); i++) {
            ints.add("" + i);
        }
        return ints;
    }

    public String getRow(String i) {
        if (currentQuestion.getRows().get(Integer.parseInt(i)).length() > 10) {
            return currentQuestion.getRows().get(Integer.parseInt(i)).substring(0, 10) + "...";
        }
        return currentQuestion.getRows().get(Integer.parseInt(i));
    }

    public String getColumn(String j) {
        if (currentQuestion.getCols().get(Integer.parseInt(j)).length() > 10) {
            return currentQuestion.getCols().get(Integer.parseInt(j)).substring(0, 10) + "...";
        }
        return currentQuestion.getCols().get(Integer.parseInt(j));
    }

    public GridQuestionController setCurrentPosition(String i, String j) {
        currentI = Integer.parseInt(i);
        currentJ = Integer.parseInt(j);
        return this;
    }

    public boolean isCurrentSelected() {
        return currentQuestion.isSelect(currentI, currentJ);
    }

    public void setCurrentSelected(boolean currentSelected) {
        currentQuestion.setSelect(currentI, currentJ, currentSelected);
    }

    public boolean isOnlyOneSelectInRow() {
        return currentQuestion.isOnlyOneSelectInRow();
    }

    public void setOnlyOneSelectInRow(boolean onlyOneSelectInRow) {
        this.currentQuestion.setOnlyOneSelectInRow(onlyOneSelectInRow);
    }

    public boolean isOnlyOneSelectInCol() {
        return currentQuestion.isOnlyOneSelectInCol();
    }

    public void setOnlyOneSelectInCol(boolean onlyOneSelectInCol) {
        this.currentQuestion.setOnlyOneSelectInCol(onlyOneSelectInCol);
    }

    @Override
    public String actionSave() {
        getTemplateTreeController().setCurrentQuestion(currentQuestion);
        return super.actionSave();
    }

    public void setAddRow(String name) {
        currentQuestion.addRow(name);
    }

    public String getAddRow() {
        return "";
    }

    public void setAddCol(String name) {
        currentQuestion.addCol(name);
    }

    public String getAddCol() {
        return "";
    }
}