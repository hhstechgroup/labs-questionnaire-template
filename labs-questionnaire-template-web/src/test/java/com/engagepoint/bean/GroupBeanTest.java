package com.engagepoint.bean;


import com.engagepoint.mock.MockTemplate;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.options.CheckBoxQuestionBean;
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
       CheckBoxQuestionBean testBean = (CheckBoxQuestionBean)mock.question();
       CheckBoxQuestionBean testBean1 = (CheckBoxQuestionBean)mock.question();
       List<Question> questionBeanList = new ArrayList<Question>();
       questionBeanList.add(testBean1);
       questionBeanList.add(testBean);
       GroupBean groupTest = mock.creatorGroup();
       groupTest.setId(new Long(1));
       groupTest.setQuestionsList(questionBeanList);

       Assert.assertTrue(groupTest.equals(groupTest.clone()));

    }
    @Test
    public void testDeleteFromInnerList(){
        CheckBoxQuestionBean testBean = (CheckBoxQuestionBean)mock.question();
        CheckBoxQuestionBean testBean1 = (CheckBoxQuestionBean)mock.question();
        List<Question> questionBeanList = new ArrayList<Question>();
        questionBeanList.add(testBean1);
        questionBeanList.add(testBean);
        GroupBean groupTest = mock.creatorGroup();
        groupTest.setId(new Long(1));
        groupTest.setQuestionsList(questionBeanList);
        groupTest.deleteFromInnerList(testBean);
        Assert.assertTrue(groupTest.getQuestionsList().size() == 1);
    }
}

