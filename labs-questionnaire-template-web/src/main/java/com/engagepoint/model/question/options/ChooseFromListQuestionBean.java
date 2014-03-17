package com.engagepoint.model.question.options;

import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "chooseFromListQuestionBean", propOrder = {
        "id",
        "requiredAnswer",
        "questionText",
        "questionType",
        "questionRules",
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
