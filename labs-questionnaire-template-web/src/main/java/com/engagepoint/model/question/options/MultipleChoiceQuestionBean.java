package com.engagepoint.model.question.options;

import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.questionnaire.GroupBean;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "multipleChoiceQuestionBean", propOrder = {
        "id",
        "requiredAnswer",
        "questionText",
        "questionType",
        "questionRules",
        "helpText",
        "options",
        "defaultAnswers"
})
public class MultipleChoiceQuestionBean extends OptionsQuestion {

    public MultipleChoiceQuestionBean() {
        super();
        getDefaultAnswers().add(0, "");
    }

    public MultipleChoiceQuestionBean(GroupBean groupBean) {
        super(groupBean);
        getDefaultAnswers().add(0, "");
    }

    @XmlTransient
    public VariantItem getDefaultOption() {
        return new VariantItem(getDefaultAnswers().get(0));
    }

    public void setDefaultOption(VariantItem defaultAnswer) {
        getDefaultAnswers().set(0, defaultAnswer.getValue());
    }

}
