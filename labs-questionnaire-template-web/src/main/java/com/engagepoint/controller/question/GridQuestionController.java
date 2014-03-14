package com.engagepoint.controller.question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.engagepoint.model.question.options.GridQuestionBean;

@Named
@SessionScoped
public class GridQuestionController implements Serializable {
    GridQuestionBean questionBean = new GridQuestionBean();
    int currentI;
    int currentJ;

    public List<String> getRowsSize() {
        List<String> ints = new ArrayList<String>();
        for (int i = 0; i < questionBean.getRows().size(); i++) {
            ints.add("" + i);
        }
        return ints;
    }

    public List<String> getColumnsSize() {
        List<String> ints = new ArrayList<String>();
        for (int i = 0; i < questionBean.getCols().size(); i++) {
            ints.add("" + i);
        }
        return ints;
    }

    public String getRow(String i) {
        return questionBean.getRows().get(Integer.parseInt(i));
    }

    public String getColumn(String j) {
        return questionBean.getCols().get(Integer.parseInt(j));
    }

    public void addRow() {
        questionBean.addRow("New");
    }

    public void addColumn() {
        questionBean.addCol("New");
    }

    public GridQuestionController setCurrentPosition(String i, String j) {
        currentI = Integer.parseInt(i);
        currentJ = Integer.parseInt(j);

        return this;
    }

    public boolean isCurrentSelected() {
        return questionBean.isSelect(currentI, currentJ);
    }

    public void setCurrentSelected(boolean currentSelected) {
        questionBean.setSelect(currentI, currentJ, currentSelected);
    }

    public boolean isOnlyOneSelectInRow() {
        return questionBean.isOnlyOneSelectInRow();
    }

    public void setOnlyOneSelectInRow(boolean onlyOneSelectInRow) {
        this.questionBean.setOnlyOneSelectInRow(onlyOneSelectInRow);
    }

    public boolean isOnlyOneSelectInCol() {
        return questionBean.isOnlyOneSelectInCol();
    }

    public void setOnlyOneSelectInCol(boolean onlyOneSelectInCol) {
        this.questionBean.setOnlyOneSelectInCol(onlyOneSelectInCol);
    }
}
