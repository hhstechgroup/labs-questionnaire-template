package com.engagepoint.bean;

import com.engagepoint.mock.MockTemplate;
import com.engagepoint.model.question.options.ChooseFromListQuestionBean;
import com.engagepoint.model.question.options.OptionsQuestion;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.questionnaire.QuestionType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
* Created by anton.kovunov on 3/5/14.
*/
public class ChooseFromListBeanTest {
    MockTemplate mock = new MockTemplate(QuestionType.CHOOSEFROMLIST);
    @Test
    public void testOptionsBeanClone() throws CloneNotSupportedException {
        ChooseFromListQuestionBean testBean = (ChooseFromListQuestionBean)mock.question();
        VariantItem var1 = new VariantItem("blahblah");
        VariantItem var2 = new VariantItem("blahblahn");
        VariantItem var3 = new VariantItem("defiler");
        List<VariantItem> allVariants = new ArrayList<VariantItem>();
        allVariants.add(var1);
        allVariants.add(var2);
        allVariants.add(var3);
        testBean.setOptions(allVariants);
        testBean.setDefaultOption(var2);
        Assert.assertTrue(testBean.equals(testBean.clone()));

    }
}
