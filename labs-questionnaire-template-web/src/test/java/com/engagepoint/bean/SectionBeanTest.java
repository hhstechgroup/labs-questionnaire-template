package com.engagepoint.bean;


import com.engagepoint.mock.MockTemplate;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.options.CheckBoxQuestionBean;
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
    MockTemplate mock = new MockTemplate(QuestionType.CHECKBOX);

    @Test
    public void testCloneSectionBean() throws Exception {
        CheckBoxQuestionBean testBean = (CheckBoxQuestionBean)mock.question();
        CheckBoxQuestionBean testBean1 = (CheckBoxQuestionBean)mock.question();
        List<Question> questionBeanList = new ArrayList<Question>();
        questionBeanList.add(testBean1);
        questionBeanList.add(testBean);
        GroupBean groupTest = mock.creatorGroup();
        groupTest.setId(new Long(1));
        groupTest.setQuestionsList(questionBeanList);
        List<GroupBean> groupBeans = new ArrayList<GroupBean>();
        groupBeans.add(groupTest);
        SectionBean testSection = mock.creatorSections();
        testSection.setGroupsList(groupBeans);
        Assert.assertTrue(testSection.equals(testSection.clone()));

    }
    @Test
    public void testDeleteFromList(){
        GroupBean group1 = mock.creatorGroup();
        GroupBean group2 = mock.creatorGroup();
        SectionBean section1 = mock.creatorSections();
        section1.addToInnerList(group1);
        section1.addToInnerList(group2);
    }

}
