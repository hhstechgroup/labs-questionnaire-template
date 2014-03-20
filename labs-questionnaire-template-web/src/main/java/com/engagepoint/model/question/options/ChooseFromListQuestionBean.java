package com.engagepoint.model.question.options;

import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlTransient;
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
        getDefaultAnswers().add(0, "");
    }

    public ChooseFromListQuestionBean(GroupBean groupBean) {
        super(groupBean);
        getDefaultAnswers().add(0, "");
    }

    @XmlTransient
    public VariantItem getDefaultOption() {
        return new VariantItem(getDefaultAnswers().get(0));
    }

    public void setDefaultOption(VariantItem defaultAnswer) {
        if (defaultAnswer != null) {
            getDefaultAnswers().set(0, defaultAnswer.getValue());
        }
    }

}
