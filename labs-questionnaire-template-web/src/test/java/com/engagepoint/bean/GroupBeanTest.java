package com.engagepoint.bean;


import com.engagepoint.mock.MockTemplate;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.QuestionType;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GroupBeanTest {
    MockTemplate mock = new MockTemplate(QuestionType.CHECKBOX);

    @Test
    public void testCloneGroupBean() throws Exception {
//        QuestionBean bean = mock. //new QuestionBean("blah",true, QuestionType.CHECKBOX);
//        QuestionBean eqBean = new QuestionBean("blah",true, QuestionType.CHECKBOX);
//        List<QuestionBean> questionBeanList = new ArrayList<QuestionBean>();
//        questionBeanList.add(bean);
//        questionBeanList.add(eqBean);
        /*GroupBean testBean = mock.creatorGroup(); //new GroupBean("EqBeans",questionBeanList);


        Assert.assertTrue(testBean.equals(testBean.clone())); */

    }
}

