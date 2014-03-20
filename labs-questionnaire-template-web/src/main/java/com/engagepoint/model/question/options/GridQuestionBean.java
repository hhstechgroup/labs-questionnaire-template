package com.engagepoint.model.question.options;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.engagepoint.model.question.Question;
import com.engagepoint.model.questionnaire.GroupBean;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "gridQuestionBean", propOrder = {
        "id",
        "requiredAnswer",
        "questionText",
        "questionType",
        "onlyOneSelectInCol",
        "onlyOneSelectInRow",
        "questionRules",
        "helpText",
        "grid",
        "defaultAnswers"
})
public class GridQuestionBean extends Question {
    Grid grid;
    boolean[][] selected;
    private boolean onlyOneSelectInRow;
    private boolean onlyOneSelectInCol;


    public GridQuestionBean() {
        grid = new Grid();
        selected = new boolean[0][0];
    }

    public GridQuestionBean(GroupBean currentGroup) {
        super(currentGroup);
        grid = new Grid();
        selected = new boolean[0][0];
    }
    @XmlElement(name = "grid")
    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    @Override
    @XmlElementWrapper(name = "default-answers")
    @XmlElement(name = "default-answer")
    public List<String> getDefaultAnswers() {
        List<String>defaultAnswers =new ArrayList<String>();
        for (int i = 0; i <selected.length; i++) {
            String defaultAnswer ="";
            defaultAnswers.add(defaultAnswer);
            for (int j = 0; j <selected[i].length ; j++) {
                if (i < grid.getRows().size() - 1){
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

    @Override
    public void setDefaultAnswers(List<String> defaultAnswers) {
       this.defaultAnswers = defaultAnswers;
        for (int i = 0; i <defaultAnswers.size() ; i++) {
            String[] inRow = defaultAnswers.get(i).split(",");
            for (int j = 0; j < inRow.length; j++) {
                selected[i][j]= Boolean.parseBoolean(inRow[j]);
            }

            
        }

    }

    @XmlTransient
    public List<String> getCols() {
        return grid.getCols();
    }

    public void setCols(List<String> cols) {
        this.grid.setCols(cols);
    }

    @XmlTransient
    public List<String> getRows() {
        return grid.getRows();
    }

    public void setRows(List<String> rows) {
        this.grid.setRows(rows);
    }

    public void addRow(String name) {
        grid.getRows().add(name);
        selected = Arrays.copyOf(selected, grid.getRows().size());
        selected[grid.getRows().size() - 1] = new boolean[grid.getCols().size()];
    }

    public void addCol(String name) {
        grid.getCols().add(name);
        for (int i = 0; i < selected.length; i++) {
            selected[i] = Arrays.copyOf(selected[i], grid.getCols().size());
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

    public void setSelect(int i, int j, boolean b) {
        selected[i][j] = b;
    }

    public void unsetSelect(int i, int j) {
        selected[i][j] = false;
    }

    public boolean isSelect(int i, int j) {
        return selected[i][j];
    }

    @XmlElement(name = "grid-oneInRow")
    public boolean isOnlyOneSelectInRow() {
        return onlyOneSelectInRow;
    }

    public void setOnlyOneSelectInRow(boolean onlyOneSelectInRow) {
        this.onlyOneSelectInRow = onlyOneSelectInRow;
    }

    @XmlElement(name = "grid-oneInCol")
    public boolean isOnlyOneSelectInCol() {
        return onlyOneSelectInCol;
    }

    public void setOnlyOneSelectInCol(boolean onlyOneSelectInCol) {
        this.onlyOneSelectInCol = onlyOneSelectInCol;
    }


}
