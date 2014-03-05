//package com.engagepoint.bean;
//
//
//import com.engagepoint.model.question.QuestionBean;
//import com.engagepoint.model.questionnaire.GroupBean;
//import com.engagepoint.model.questionnaire.QuestionType;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by yurii.kukharskyi on 1/28/14.
// */
//public class GroupBeanTest {
//
//
//    @Test
//    public void testCloneGroupBean() throws Exception {
//        QuestionBean bean = new QuestionBean("blah",true, QuestionType.CHECKBOX);
//        QuestionBean eqBean = new QuestionBean("blah",true, QuestionType.CHECKBOX);
//        List<QuestionBean> questionBeanList = new ArrayList<QuestionBean>();
//        questionBeanList.add(bean);
//        questionBeanList.add(eqBean);
//        GroupBean testBean = new GroupBean("EqBeans",questionBeanList);
//
//
//        Assert.assertTrue(testBean.equals(testBean.clone()));
//
//    }
//    @Test
//    public void testEqualsGroupBean(){
//        QuestionBean bean = new QuestionBean("blah",true, QuestionType.CHECKBOX);
//        QuestionBean eqBean = new QuestionBean("blah",true, QuestionType.CHECKBOX);
//        List<QuestionBean> questionBeanList = new ArrayList<QuestionBean>();
//        questionBeanList.add(bean);
//        questionBeanList.add(eqBean);
//        GroupBean testBean = new GroupBean("EqBeans",questionBeanList);
//        GroupBean testBean2 = new GroupBean("EqBeans",questionBeanList);
//        Assert.assertTrue(testBean.equals(testBean2));
//
//    }
//
//}
