package com.engagepoint.bean;


import com.engagepoint.mock.MockTemplate;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.options.CheckBoxQuestionBean;
import com.engagepoint.model.question.options.OptionsQuestion;
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
       groupTest.setId(new String("1"));
       groupTest.setQuestionsList(questionBeanList);

       Assert.assertTrue(groupTest.equals(groupTest.clone()));

    }
    @Test
    public void testDeleteFromInnerListAndOthers(){
        CheckBoxQuestionBean testBean = (CheckBoxQuestionBean)mock.question();
        CheckBoxQuestionBean testBean1 = (CheckBoxQuestionBean)mock.question();
        List<Question> questionBeanList = new ArrayList<Question>();
        questionBeanList.add(testBean1);
        questionBeanList.add(testBean);
        GroupBean groupTest = mock.creatorGroup();
        groupTest.setId(new String("1"));
        groupTest.setQuestionsList(questionBeanList);
        groupTest.deleteFromInnerList(testBean);
        Assert.assertTrue(groupTest.getQuestionsList().size() == 1);
        Assert.assertTrue(groupTest.getDisplayedNodeType().contains("Group"));
        Assert.assertTrue(groupTest.getDisplayedId().contains("ID"));
        OptionsQuestion optBean = (OptionsQuestion)mock.question();
        groupTest.addToInnerList(optBean);
        Assert.assertTrue(groupTest.getQuestionsList().size() == 2);
    }
    @Test
    public void testType(){
        GroupBean groupTest = mock.creatorGroup();
        Assert.assertTrue(groupTest.getType().contains("group"));

    }
    @Test
    public void testEquals(){
        CheckBoxQuestionBean testBean = (CheckBoxQuestionBean)mock.question();
        CheckBoxQuestionBean testBean1 = (CheckBoxQuestionBean)mock.question();
        List<Question> questionBeanList = new ArrayList<Question>();
        questionBeanList.add(testBean1);
        questionBeanList.add(testBean);
        GroupBean groupTest = mock.creatorGroup();
        groupTest.setId(new String("1"));
        groupTest.setQuestionsList(questionBeanList);

        questionBeanList.add(testBean1);
        questionBeanList.add(testBean);
        GroupBean groupTest2 = mock.creatorGroup();
        groupTest2.setId(new String("1"));
        groupTest2.setQuestionsList(questionBeanList);
        Assert.assertTrue(groupTest.equals(groupTest2));
    }
}

