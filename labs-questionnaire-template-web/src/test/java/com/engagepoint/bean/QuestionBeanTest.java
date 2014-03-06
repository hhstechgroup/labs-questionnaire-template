//package com.engagepoint.bean;
//
//
//import com.engagepoint.model.question.Question;
//import com.engagepoint.model.questionnaire.QuestionType;
//import org.junit.Assert;
//import org.junit.Test;
//
///**
// * Created by yurii.kukharskyi on 1/28/14.
// */
//public class QuestionBeanTest {
//
//    @Test
//    public void testCloneQuestionBean() throws CloneNotSupportedException {
//        Question bean = new Question("blah",true,QuestionType.CHOOSEFROMLIST);
//
//        Assert.assertTrue(bean.equals(bean.clone()));
//    }
//    @Test
//    public void testEqualsQuestionBean(){
//        Question bean = new Question("blah",true, QuestionType.CHECKBOX);
//        Question eqBean = new Question("blah",true, QuestionType.CHECKBOX);
//        Assert.assertTrue(bean.equals(eqBean));
//
//    }
//
//}
