package com.engagepoint.controller.question;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class GridEditParamsController implements Serializable {
    List<Boolean> markAsDelete;
    /**
     * Reference to titles list of columns or rows in GridBean
     */
    List<String> params;
    Integer position;

    @Inject
    GridQuestionController gridQuestionController;

    public List<String> getPositions() {
        List<String> positions = new ArrayList<>();
        for (int i = 0; i < params.size(); i++) {
            positions.add("" + i);
        }
        return positions;
    }

    public GridEditParamsController setPosition(String position) {
        this.position = Integer.parseInt(position);
        return this;
    }

    public Boolean getMarkAsDelete() {
        return markAsDelete.get(position);
    }

    public void setMarkAsDelete(Boolean markAsDelete) {
        this.markAsDelete.set(position, markAsDelete);
    }

    @PostConstruct
    public void setParams() {
        if (gridQuestionController.getParams() == null) {
            params = new ArrayList<>();
        } else {
            params = gridQuestionController.getParams();
        }
        markAsDelete = new ArrayList<>();
        for (String param : params) {
            markAsDelete.add(false);
        }
    }

    public void setParam(String param) {
        this.params.set(position, param);
    }

    public String getParam() {
        return this.params.get(position);
    }

    public void add() {
        if (gridQuestionController.getCurrentQuestion().getCols() == params) {
            gridQuestionController.getCurrentQuestion().addCol("");
        } else {
            gridQuestionController.getCurrentQuestion().addRow("");
        }
    }
}
