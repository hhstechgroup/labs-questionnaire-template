package com.engagepoint.xmlparser;

import com.engagepoint.bean.TemplateBean;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "questionnaire-forms")
public class QuestionnaireForms {

    private List<TemplateBean> questionnaireFormList;

    @XmlElement(name = "questionnaire-form")
    public List<TemplateBean> getQuestionnaireFormList() {
        return questionnaireFormList;
    }
    public void setQuestionnaireFormList(List<TemplateBean> questionnaireFormList) {
        this.questionnaireFormList = questionnaireFormList;
    }

}
