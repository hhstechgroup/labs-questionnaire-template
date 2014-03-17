package com.engagepoint.model.question.options;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.engagepoint.model.question.Question;
import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class GridQuestionBean extends Question {
    List<String> rows;
    /**
     * List of columns
     */
    List<String> cols;
    boolean[][] selected;
    boolean onlyOneSelectInRow;
    boolean onlyOneSelectInCol;

    public void clear() {
        rows = new ArrayList<String>();
        cols = new ArrayList<String>();
        selected = new boolean[0][0];
    }

    public GridQuestionBean() {
        clear();
    }

    public GridQuestionBean(GroupBean currentGroup) {
        super(currentGroup);
        clear();
    }

    @XmlElementWrapper(name = "Rows")
    @XmlElement(name = "row")
    public List<String> getRows() {
        return rows;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }

    @XmlElementWrapper(name = "Columns")
    @XmlElement(name = "column")
    public List<String> getCols() {
        return cols;
    }

    @XmlElementWrapper(name = "default-answers")
    @XmlElement(name = "default-answer")
    public List<String> getSelected() {
        List<String>defaultAnswers =new ArrayList<String>();
        for (int i = 0; i <selected.length; i++) {
            String defaultAnswer ="";
            defaultAnswers.add(defaultAnswer);
            for (int j = 0; j <selected[i].length ; j++) {
                if (i < rows.size()){
                    defaultAnswer +=selected[i][j]+",";
                defaultAnswers.set(i,defaultAnswer);
                }else {
                    defaultAnswer +=selected[i][j];
                    defaultAnswers.set(i, defaultAnswer);
                }
            }

        }
        return defaultAnswers;
    }

    public void addRow(String name) {
        rows.add(name);
        selected = Arrays.copyOf(selected, rows.size());
        selected[rows.size() - 1] = new boolean[cols.size()];
    }

    public void addCol(String name) {
        cols.add(name);
        for (int i = 0; i < selected.length; i++) {
            selected[i] = Arrays.copyOf(selected[i], cols.size());
        }
    }

    public void unselectRow(int row) {
        for (int i = 0; i < selected[row].length; i++) {
            unsetSelect(row, i);
        }
    }

    public void unselectCol(int col) {
        for (int j = 0; j < selected.length; j++) {
            unsetSelect(j, col);
        }
    }

    public void setSelect(int i, int j) {
        setSelect(i, j, true);
    }

    public void setSelect(int i, int j, boolean b) {
        selected[i][j] = b;
    }

    public void unsetSelect(int i, int j) {
        selected[i][j] = false;
    }

    public boolean isSelect(int i, int j) {
        return selected[i][j];
    }

    @XmlElement(name = "OnlyOneInRow")
    public boolean isOnlyOneSelectInRow() {
        return onlyOneSelectInRow;
    }

    public void setOnlyOneSelectInRow(boolean onlyOneSelectInRow) {
        this.onlyOneSelectInRow = onlyOneSelectInRow;
    }

    @XmlElement(name = "OnlyOneInCol")
    public boolean isOnlyOneSelectInCol() {
        return onlyOneSelectInCol;
    }

    public void setOnlyOneSelectInCol(boolean onlyOneSelectInCol) {
        this.onlyOneSelectInCol = onlyOneSelectInCol;
    }
}
