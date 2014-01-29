package com.engagepoint.xmlparser;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "questionnaire-forms")
public class QuestionnaireForms {
    private List<QuestionnaireForm> questionnaireFormList;

    @XmlElement(name = "questionnaire-form")
    public List<QuestionnaireForm> getQuestionnaireFormList() {
        return questionnaireFormList;
    }

    public void setQuestionnaireFormList(List<QuestionnaireForm> questionnaireFormList) {
        this.questionnaireFormList = questionnaireFormList;
    }
}
