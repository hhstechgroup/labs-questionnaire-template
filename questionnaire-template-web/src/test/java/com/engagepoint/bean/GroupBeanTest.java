package com.engagepoint.bean;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class GroupBeanTest {


    @Test
    public void testCloneGroupBean() throws Exception {
        QuestionBasicBean bean = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        QuestionBasicBean eqBean = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        List<QuestionBasicBean> questionBeanList = new ArrayList<QuestionBasicBean>();
        questionBeanList.add(bean);
        questionBeanList.add(eqBean);
        GroupBasicBean testBean = new GroupBasicBean("EqBeans",questionBeanList);


        Assert.assertTrue(testBean.equals(testBean.clone()));

    }
    @Test
    public void testEqualsGroupBean(){
        QuestionBasicBean bean = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        QuestionBasicBean eqBean = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        List<QuestionBasicBean> questionBeanList = new ArrayList<QuestionBasicBean>();
        questionBeanList.add(bean);
        questionBeanList.add(eqBean);
        GroupBasicBean testBean = new GroupBasicBean("EqBeans",questionBeanList);
        GroupBasicBean testBean2 = new GroupBasicBean("EqBeans",questionBeanList);
        Assert.assertTrue(testBean.equals(testBean2));

    }

}
