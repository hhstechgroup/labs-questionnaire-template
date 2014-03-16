package com.engagepoint.model.question.options;

import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "chooseFromListQuestionBean", propOrder = {
        "questionId",
        "requiredAnswer",
        "questionText",
        "questionType",
        "rules",
        "helpText",
        "options",
        "defaultAnswers"
})
public class ChooseFromListQuestionBean extends OptionsQuestion {

    public ChooseFromListQuestionBean() {
        super();
    }

    public ChooseFromListQuestionBean(GroupBean groupBean) {
        super(groupBean);
    }

}
