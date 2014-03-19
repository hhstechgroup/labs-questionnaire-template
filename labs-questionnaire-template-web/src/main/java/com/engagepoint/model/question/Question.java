package com.engagepoint.model.question;


import com.engagepoint.model.question.options.GridQuestionBean;
import com.engagepoint.model.question.options.*;
import com.engagepoint.model.question.rules.Rule;
import com.engagepoint.model.questionnaire.BasicBean;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.QuestionType;
import com.engagepoint.model.questionnaire.TemplateBean;
import org.apache.log4j.Logger;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represents question tag.
 */
@XmlSeeAlso({
        TextQuestionBean.class,
        DateQuestionBean.class,
        RangeQuestionBean.class,
        ChooseFromListQuestionBean.class,
        MultipleChoiceQuestionBean.class,
        CheckBoxQuestionBean.class,
        GridQuestionBean.class
})
@XmlTransient
public abstract class Question extends BasicBean implements Cloneable {

    protected String questionId;             //absolutely unique and consists of template id, page number, group number and question number (f.e. f1p1g1q1)
    protected Long questionNumber;           //unique in group
    protected boolean requiredAnswer;        //is answer required or not
    protected String questionText = "";      //questiontext
    protected QuestionType questionType;     //questiontype from ENUM of questiontypes
    protected String helpText = "";          //Help texts for questions
    protected List<String> defaultAnswers;

    protected GroupBean groupBean;
    private static final Logger LOG = Logger.getLogger(Question.class);

    private List<Rule> questionRules;

    public Question() {
        setRules(new ArrayList<Rule>());
        defaultAnswers = new ArrayList<String>();
    }

    public Question(GroupBean groupBean) {
        this();
        this.groupBean = groupBean;
        this.questionNumber = getNextQuestionNumberInGroup();
        this.questionId = groupBean.getId() + "q" + this.questionNumber;
    }

    public Question(String questionText, boolean requiredAnswer, QuestionType questionType) {
        this();
        this.questionText = questionText;
        this.requiredAnswer = requiredAnswer;
        this.questionType = questionType;
    }

    /**
     * Gets next number of page for current template
     * @return SectionId
     */
    public final Long getNextQuestionNumberInGroup() {
        List<Question> questionList = groupBean.getQuestionsList();
        if (questionList.isEmpty()) {
            return 1L;
        }else {
            return questionList.get(questionList.size()-1).getQuestionNumber()+1;
        }
    }

    @XmlTransient
    public Long getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Long questionNumber) {
        this.questionNumber = questionNumber;
    }

    @XmlAttribute(name = "question-id")
    @Override
    public String getId() {
        return questionId;
    }

    @Override
    public void setId(String questionId) {
        this.questionId = questionId;
        //must set group number from xml
        if (questionNumber==null) {
            try {
                int indexOfP = questionId.lastIndexOf('q');
                setQuestionNumber(Long.valueOf(questionId.substring(indexOfP+1)));
            } catch (NumberFormatException e) {
              LOG.warn("Id is not correct", e);
            }
        }
    }

    @XmlAttribute(name = "answer-required")
    public boolean isRequiredAnswer() {
        return requiredAnswer;
    }

    public void setRequiredAnswer(boolean requiredAnswer) {
        this.requiredAnswer = requiredAnswer;
    }

    @XmlElement(name = "question-title")
    public String getQuestionText() {
        return questionText;
    }

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

    @XmlElement(name = "question-type")
    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @XmlElementWrapper(name = "question-rules")
    @XmlElement(name = "question-rule")
    public List<Rule> getQuestionRules() {
        return getRules();
    }

    public void setQuestionRules(List<Rule> rules) {
        setRules(rules);
    }

    @XmlElement(name = "help-text")
    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    @XmlElementWrapper(name = "default-answers")
    @XmlElement(name = "default-answer")
    public List<String> getDefaultAnswers() {
        return defaultAnswers;
    }

    public void setDefaultAnswers(List<String> defaultAnswers) {
        this.defaultAnswers = defaultAnswers;
    }

    @XmlTransient
    public GroupBean getGroupBean() {
        return groupBean;
    }

    public void setGroupBean(GroupBean groupBean) {
        this.groupBean = groupBean;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Question copy = (Question) super.clone();
        if (TemplateBean.isDuplicate()) {
            copy.setId(this.questionId);
        }
        copy.setRequiredAnswer(this.requiredAnswer);
        copy.setHelpText(this.helpText);
        copy.setQuestionText(this.questionText);
        copy.setQuestionType(this.questionType);
        copy.setQuestionNumber(this.questionNumber);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Question question = (Question) o;

        if (requiredAnswer != question.requiredAnswer) {
            return false;
        }

        if (helpText != null ? !helpText.equals(question.helpText) : question.helpText != null) {
            return false;
        }
        if (!questionText.equals(question.questionText)) {
            return false;
        }
        if (questionType != question.questionType) {
            return false;
        }
        if (questionNumber != null ? !questionNumber.equals(question.questionNumber) : question.questionNumber != null) {
            return false;
        }


        return true;
    }

    @Override
    public int hashCode() {
        int result = questionNumber.hashCode();
        result = 31 * result + (requiredAnswer ? 1 : 0);
        result = 31 * result + (helpText != null ? helpText.hashCode() : 0);
        result = 31 * result + questionText.hashCode();
        result = 31 * result + questionType.hashCode();

        return result;
    }

    @Override
    public String toString() {
        return questionText;
    }

    @Override
    public String getType() {
        return "question";
    }

    @Override
    public String getDisplayedNodeType() {
        return "Question: ";
    }

    @Override
    @XmlTransient
    public String getDisplayedName() {
        return cutTextToNSymbols(questionText,9); //TODO: make property for quantity of symbols
    }

    @Override
    public String getDisplayedId() {
        return " (ID: " + String.valueOf(this.questionId) + ") ";
    }

    private String cutTextToNSymbols(String text, int n) {
        return text.length()>n ? text.substring(0, n)+"..." : text;
    }

}
