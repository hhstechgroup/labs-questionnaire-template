package com.engagepoint.bean;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 1/28/14
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuestionBean implements Cloneable {
    private Long id;
    private String questionTitle;
    private boolean requiredAnswer;
    private QuestionType questionType;


    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRequiredAnswer() {
        return requiredAnswer;
    }

    public void setRequiredAnswer(boolean requiredAnswer) {
        this.requiredAnswer = requiredAnswer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        QuestionBean copy = (QuestionBean) super.clone();
        copy.setQuestionType(this.questionType);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionBean that = (QuestionBean) o;

        if (requiredAnswer != that.requiredAnswer) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (questionTitle != null ? !questionTitle.equals(that.questionTitle) : that.questionTitle != null)
            return false;
        if (questionType != that.questionType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (questionTitle != null ? questionTitle.hashCode() : 0);
        result = 31 * result + (requiredAnswer ? 1 : 0);
        result = 31 * result + (questionType != null ? questionType.hashCode() : 0);
        return result;
    }
}
