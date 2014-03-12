package com.engagepoint.model.question;


import com.engagepoint.controller.page.TemplateTreeController;
import com.engagepoint.model.question.options.OptionsQuestion;
import com.engagepoint.model.questionnaire.*;

import javax.inject.Inject;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * Class represents question tag.
 */
@XmlSeeAlso({TextQuestionBean.class, DateQuestionBean.class, OptionsQuestion.class, RangeQuestionBean.class})
public abstract class Question extends BasicBean implements Cloneable {
    private static Long lastId=1L;

    private Long id;                    //id of the question
    protected String questionText = "";        //questiontext
    private boolean requiredAnswer=false;        //is answer required or not
    private QuestionType questionType;    //questiontype from ENUM of questiontypes
    private String helpText = "";            //Help texts for questions
    private GroupBean groupBean;

    //Dependent questions

    public Question(GroupBean groupBean) {
        this.groupBean = groupBean;
        id = Long.valueOf(groupBean.getId() + (lastId++).toString());
        super.setDisplayedName("QuestionDefault");
        //groupBean.addToInnerList(this);
    }

    @XmlElement(name = "question-title")
    public String getQuestionText() {
        return questionText;
    }

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

    @XmlElement(name = "help-text")
    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    @XmlAttribute(name = "question-id")
    public Long getId() {
        return id;
    }

    @Override
    public String getDisplayedName() {
        return questionText;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @XmlAttribute(required = true)
    public boolean isRequiredAnswer() {
        return requiredAnswer;
    }

    public void setRequiredAnswer(boolean requiredAnswer) {
        this.requiredAnswer = requiredAnswer;
    }

    @XmlElement(name = "question-type")
    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public Question(String questionText, boolean requiredAnswer, QuestionType questionType) {
        this.questionText = questionText;
        this.requiredAnswer = requiredAnswer;
        this.questionType = questionType;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Question copy = (Question) super.clone();
        if (TemplateBean.duplicate)
            copy.setId(this.id);
        copy.setQuestionType(this.questionType);
        copy.setQuestionText(this.questionText);
        copy.setRequiredAnswer(this.requiredAnswer);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question that = (Question) o;

        if (requiredAnswer != that.requiredAnswer) return false;

        if (questionText != null ? !questionText.equals(that.questionText) : that.questionText != null)
            return false;
        if (questionType != that.questionType) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (questionText != null ? questionText.hashCode() : 0);
        result = 31 * result + (requiredAnswer ? 1 : 0);
        result = 31 * result + (questionType != null ? questionType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Question " + id;
    }

    @Override
    public String getType() {
        return "question";
    }

    @Override
    public String getDisplayedId() {
        String questionID = " (ID: "+String.valueOf(id)+") ";
        return questionID;
    }
}
