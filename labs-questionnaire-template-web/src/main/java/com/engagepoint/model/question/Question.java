package com.engagepoint.model.question;


import com.engagepoint.model.question.options.*;
import com.engagepoint.model.question.rules.Rule;
import com.engagepoint.model.questionnaire.BasicBean;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.QuestionType;
import com.engagepoint.model.questionnaire.TemplateBean;

import javax.xml.bind.annotation.*;
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
        CheckBoxQuestionBean.class
})
@XmlTransient
public abstract class Question extends BasicBean implements Cloneable {

    protected String questionId;             //absolutely unique and consists of template id, page number, group number and question number (f.e. f1p1g1q1)
    protected Long questionNumber;           //unique in group
    protected boolean requiredAnswer;        //is answer required or not
    protected String questionText = "";      //questiontext
    protected QuestionType questionType;     //questiontype from ENUM of questiontypes
    protected List<Rule> rules;
    protected String helpText = "";          //Help texts for questions
    protected List<String> defaultAnswers;

    protected GroupBean groupBean;

    public Question() {
        rules = new ArrayList<Rule>();
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
    public Long getNextQuestionNumberInGroup() {
        List<Question> questionList = groupBean.getQuestionsList();
        if (questionList.isEmpty()) {
            return 1L;
        }
        else {
            return ((questionList.get(questionList.size()-1)).getQuestionNumber()+1);
        }
    }

    @XmlTransient
    private Long getQuestionNumber() {
        return questionNumber;
    }

    private void setQuestionNumber(Long questionNumber) {
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
                int indexOfP = questionId.lastIndexOf("q");
                setQuestionNumber(Long.valueOf(questionId.substring(indexOfP+1)));
            } catch (NullPointerException e) {
                //log that questionId is null
            }
            catch (NumberFormatException e) {
                //log that questionId is not correct
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

    @XmlElementWrapper(name = "rules")
    @XmlElement(name = "rule")
    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        Question copy = (Question) super.clone();
        if (TemplateBean.duplicate) {
            copy.setId(this.questionId);
        }
        copy.setQuestionType(this.questionType);
        copy.setQuestionText(this.questionText);
        copy.setRequiredAnswer(this.requiredAnswer);
        return copy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Question)) return false;

        Question question = (Question) o;

        if (!questionId.equals(question.questionId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return questionId.hashCode();
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
