package com.engagepoint.model.question;

import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.QuestionType;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlType(name = "dateQuestionBean", propOrder = {
        "id",
        "requiredAnswer",
        "questionText",
        "questionType",
        "rules",
        "helpText",
        "defaultAnswers"
})
public class DateQuestionBean extends Question {
    private Date defaultDate;

    public DateQuestionBean() {
        super();
        defaultDate = new Date();
    }

    public DateQuestionBean(GroupBean currentGroup) {
        super(currentGroup);
        defaultDate = new Date();
    }

    @XmlTransient
    public Date getDefaultDate() {
        return defaultDate;
    }

    public void setDefaultDate(Date defaultDate) {
        this.defaultDate = defaultDate;
    }

    @Override
    @XmlElementWrapper(name = "default-answers")
    @XmlElement(name = "default-answer")
    public List<String> getDefaultAnswers() {
        List<String> list = new ArrayList<String>();
        list.add(getDateFormat().format(defaultDate));
        return list;
    }

    @Override
    public void setDefaultAnswers(List<String> list) {
        try {
            String target = list.get(0);
            defaultDate =  getDateFormat().parse(target);
        }catch (StringIndexOutOfBoundsException e) {
            //log that string of default answer in XML is empty
        }catch (ParseException pe) {
            //log that format of date is incorrect
        }
    }

    private DateFormat getDateFormat() {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        if (this.getQuestionType() == QuestionType.TIME) {
            df = new SimpleDateFormat("HH:mm");
        }
        return df;
    }
}
