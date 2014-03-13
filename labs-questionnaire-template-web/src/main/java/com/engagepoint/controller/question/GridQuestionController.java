package com.engagepoint.controller.question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.engagepoint.controller.page.QuestionEditController;
import com.engagepoint.controller.page.TemplateEditController;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.TextQuestionBean;
import com.engagepoint.model.question.options.GridQuestionBean;
import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.table.ListOfOptionsDataModel;

@Named
@ConversationScoped
public class GridQuestionController implements Serializable {
    GridQuestionBean gridQuestionController = new GridQuestionBean();
    boolean f;

    public List<String> getRowsSize() {
        List<String> ints = new ArrayList<String>();
        for (int i = 0; i < gridQuestionController.getRows().size(); i++) {
            ints.add("" + i);
        }
        return ints;
    }

    public List<String> getColumnsSize() {
        List<String> ints = new ArrayList<String>();
        for (int i = 0; i < gridQuestionController.getCols().size(); i++) {
            ints.add("" + i);
        }
        return ints;
    }

    public void setRowsSize(String t) {
    }

    public void setColumnsSize(String t) {
    }

    public String getRow(String i) {
        return gridQuestionController.getRows().get(Integer.parseInt(i));
    }

    public String getColumn(String j) {
        return gridQuestionController.getCols().get(Integer.parseInt(j));
    }

    public void addRow() {
    }

    public void addColumn() {
    }

    public boolean isF() {
        return f;
    }

    public void setF(boolean f) {
        this.f = f;
    }
}
