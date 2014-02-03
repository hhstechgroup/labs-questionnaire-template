package com.engagepoint.controller;

import com.engagepoint.bean.QuestionType;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "groupController")
@SessionScoped
public class GroupController implements Serializable {
    private static final long serialVersionUID = 1L;
    private QuestionType selectedQuestionType;
    private boolean showNewQuestionForm;

    public QuestionType getSelectedQuestionType() {
        return selectedQuestionType;
    }

    public void setSelectedQuestionType(QuestionType selectedQuestionType) {
        this.selectedQuestionType = selectedQuestionType;
    }

    public QuestionType[] getQuestionTypes() {
        return QuestionType.values();
    }

    public boolean isShowNewQuestionForm() {
        return showNewQuestionForm;
    }

    public void setShowNewQuestionForm(boolean showNewQuestionForm) {
        this.showNewQuestionForm = showNewQuestionForm;
    }

    public void changeEditable() {
        this.showNewQuestionForm = true;
    }

    public String income() {
        return "pages/group?faces-redirect=true";
    }

}
