package com.engagepoint.model.question.options;

import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "multipleChoiceQuestionBean", propOrder = {
        "id",
        "requiredAnswer",
        "questionText",
        "questionType",
        "rules",
        "helpText",
        "options",
        "defaultAnswers"
})
public class MultipleChoiceQuestionBean extends OptionsQuestion {

    public MultipleChoiceQuestionBean() {
        super();
    }

    public MultipleChoiceQuestionBean(GroupBean groupBean) {
        super(groupBean);
    }

}
