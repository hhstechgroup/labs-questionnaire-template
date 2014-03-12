package com.engagepoint.bean;


import com.engagepoint.mock.MockTemplate;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.QuestionType;
import com.engagepoint.model.questionnaire.SectionBean;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
* Created by yurii.kukharskyi on 1/28/14.
*/
public class SectionBeanTest {
    /*MockTemplate mock = new MockTemplate(QuestionType.CHECKBOX);

    @Test
    public void testCloneSectionBean() throws Exception {
        Assert.assertTrue(mock.creatorSections().equals(mock.creatorSections().clone()));

    }
    @Test
    public void testEqualsSectionBean() throws Exception {
        /*Question bean = mock.question();
        Question eqBean = mock.question();
        List<Question> questionBeanList = new ArrayList<Question>();
        questionBeanList.add(bean);
        questionBeanList.add(eqBean);
        GroupBean testBean = new GroupBean("EqBeans",questionBeanList);
        GroupBean testBean2 = new GroupBean("EqBeans",questionBeanList);
        ArrayList<GroupBean> groupBeans = new ArrayList<GroupBean>();
        groupBeans.add(testBean);
        groupBeans.add(testBean2);
        SectionBean section1 = new SectionBean(groupBeans);
        SectionBean section2 = new SectionBean(groupBeans);
        Assert.assertTrue(section1.equals(section2));


    }*/


}
