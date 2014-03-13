package com.engagepoint.model.question.options;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.engagepoint.model.question.Question;

public class GridQuestionBean extends Question {
    List<String> rows;
    List<String> cols;
    boolean[][] selected;

    public void clear() {
        rows = new ArrayList<String>();
        cols = new ArrayList<String>();
        selected = new boolean[rows.size()][cols.size()];
    }

    public GridQuestionBean() {
        rows = new ArrayList<String>();
        rows.add("row1");
        rows.add("row2");
        rows.add("row3");
        cols = new ArrayList<String>();
        cols.add("col1");
        cols.add("col2");
        cols.add("col3");
        selected = new boolean[rows.size()][cols.size()];
    }

    public List<String> getRows() {
        return rows;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }

    public List<String> getCols() {
        return cols;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }

    public boolean[][] getSelected() {
        return selected;
    }

    public void setSelected(boolean[][] selected) {
        this.selected = selected;
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
        selected[i][j] = true;
    }

    public void unsetSelect(int i, int j) {
        selected[i][j] = false;
    }

    public boolean isSelect(int i, int j) {
        return selected[i][j];
    }
}
