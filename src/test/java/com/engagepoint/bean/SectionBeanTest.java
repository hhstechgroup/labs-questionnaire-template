package com.engagepoint.bean;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class SectionBeanTest {

    @Test
    public void testCloneSectionBean() throws Exception {
        QuestionBean bean = new QuestionBean("blah",true, QuestionType.CHECKBOX);
        QuestionBean eqBean = new QuestionBean("blahn",true, QuestionType.CHECKBOX);
        List<QuestionBean> questionBeanList = new ArrayList<QuestionBean>();
        questionBeanList.add(bean);
        questionBeanList.add(eqBean);
        GroupBean testBean = new GroupBean("EqBeans",questionBeanList);
        GroupBean testBean2 = new GroupBean("EqBeans",questionBeanList);
        ArrayList<GroupBean> groupBeans = new ArrayList<GroupBean>();
        groupBeans.add(testBean);
        groupBeans.add(testBean2);
        SectionBean section1 = new SectionBean(2,groupBeans);
        Assert.assertTrue(section1.equals(section1.clone()));

    }
    @Test
    public void testEqualsSectionBean() throws Exception {
        QuestionBean bean = new QuestionBean("blah",true, QuestionType.CHECKBOX);
        QuestionBean eqBean = new QuestionBean("blah",true, QuestionType.CHECKBOX);
        List<QuestionBean> questionBeanList = new ArrayList<QuestionBean>();
        questionBeanList.add(bean);
        questionBeanList.add(eqBean);
        GroupBean testBean = new GroupBean("EqBeans",questionBeanList);
        GroupBean testBean2 = new GroupBean("EqBeans",questionBeanList);
        ArrayList<GroupBean> groupBeans = new ArrayList<GroupBean>();
        groupBeans.add(testBean);
        groupBeans.add(testBean2);
        SectionBean section1 = new SectionBean(2,groupBeans);
        SectionBean section2 = new SectionBean(2,groupBeans);
        Assert.assertTrue(section1.equals(section2));


    }


}
