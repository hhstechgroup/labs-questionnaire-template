package com.engagepoint.model.question;


import com.engagepoint.model.question.options.OptionsQuestion;
import com.engagepoint.model.question.rules.Rule;
import com.engagepoint.model.question.utils.VariantItem;
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
@XmlSeeAlso({TextQuestionBean.class,
             DateQuestionBean.class,
             OptionsQuestion.class,
             RangeQuestionBean.class})
@XmlType(name = "XSDforWizard.xsd", propOrder = {
        "questionId",
        "requiredAnswer",
        "questionText",
        "questionType",
        "rules",
        "helpText",
        "options",
        "defaultAnswers"
})
public abstract class Question extends BasicBean implements Cloneable {
    private static Long lastId = 1L;

    private Long id;                    //id of the question

    private String questionId;
    protected String questionText = "";        //questiontext
    private boolean requiredAnswer;        //is answer required or not
    private QuestionType questionType;    //questiontype from ENUM of questiontypes
    private String helpText = "";            //Help texts for questions
    protected List<VariantItem> options;
    private List<Rule> rules;
    private List<String> defaultAnswers;

    private GroupBean groupBean;

    public Question() {
        this.id = lastId++;
        rules = new ArrayList<Rule>();
        defaultAnswers = new ArrayList<String>();
        options = new ArrayList<VariantItem>();
    }

    public Question(GroupBean groupBean) {
        this.groupBean = groupBean;
        id = Long.valueOf(groupBean.getId() + (lastId++).toString());
        rules = new ArrayList<Rule>();
        defaultAnswers = new ArrayList<String>();
        options = new ArrayList<VariantItem>();
    }

    public Question(String questionText, boolean requiredAnswer, QuestionType questionType) {
        this.questionText = questionText;
        this.requiredAnswer = requiredAnswer;
        this.questionType = questionType;
    }

    @XmlAttribute(name = "question-id")
    public String getQuestionId() {
        return "q" + id;
    }
    
    public void setQuestionId(String id) {
        try {
            this.id = Long.valueOf(id.substring(1));
        }
        catch (StringIndexOutOfBoundsException e) {
            //log that id in XML is empty
        }
        catch (NumberFormatException e) {
            //log that id in XML is incorrect (must be like "q[id]")
        }
    }

    @XmlTransient
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @XmlElementWrapper(name = "options")
    @XmlElement(name = "option")
    public List<VariantItem> getOptions() {
        return this.options;
    };

    public void setOptions(List<VariantItem> options) {
        this.options = options;
    };

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
            copy.setId(this.id);
        }
        copy.setQuestionType(this.questionType);
        copy.setQuestionText(this.questionText);
        copy.setRequiredAnswer(this.requiredAnswer);
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
        Question that = (Question) o;
        if (requiredAnswer != that.requiredAnswer) {
            return false;
        }
        if (questionText != null ? !questionText.equals(that.questionText) : that.questionText != null) {
            return false;
        }
        if (questionType != that.questionType) {
            return false;
        }
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
    public String getDisplayedNodeType() {
        return "Question: ";
    }

    @Override
    public String getDisplayedName() {
        return questionText.length() > 9 ? questionText.substring(0, 9) + "..." : questionText; //TODO: make property for quantity of symbols
    }

    @Override
    public String getDisplayedId() {
        String id = " (ID: " + String.valueOf(this.id) + ") ";
        return id;
    }


}
