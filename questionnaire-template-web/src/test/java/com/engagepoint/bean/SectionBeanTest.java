package com.engagepoint.bean;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class SectionBeanTest {

    @Test
    public void testCloneSectionBean() throws Exception {
        QuestionBasicBean bean = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        QuestionBasicBean eqBean = new QuestionBasicBean("blahn",true, QuestionType.CHECKBOX);
        List<QuestionBasicBean> questionBeanList = new ArrayList<QuestionBasicBean>();
        questionBeanList.add(bean);
        questionBeanList.add(eqBean);
        GroupBasicBean testBean = new GroupBasicBean("EqBeans",questionBeanList);
        GroupBasicBean testBean2 = new GroupBasicBean("EqBeans",questionBeanList);
        ArrayList<GroupBasicBean> groupBeans = new ArrayList<GroupBasicBean>();
        groupBeans.add(testBean);
        groupBeans.add(testBean2);
        SectionBasicBean section1 = new SectionBasicBean(2,groupBeans);
        Assert.assertTrue(section1.equals(section1.clone()));

    }
    @Test
    public void testEqualsSectionBean() throws Exception {
        QuestionBasicBean bean = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        QuestionBasicBean eqBean = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        List<QuestionBasicBean> questionBeanList = new ArrayList<QuestionBasicBean>();
        questionBeanList.add(bean);
        questionBeanList.add(eqBean);
        GroupBasicBean testBean = new GroupBasicBean("EqBeans",questionBeanList);
        GroupBasicBean testBean2 = new GroupBasicBean("EqBeans",questionBeanList);
        ArrayList<GroupBasicBean> groupBeans = new ArrayList<GroupBasicBean>();
        groupBeans.add(testBean);
        groupBeans.add(testBean2);
        SectionBasicBean section1 = new SectionBasicBean(2,groupBeans);
        SectionBasicBean section2 = new SectionBasicBean(2,groupBeans);
        Assert.assertTrue(section1.equals(section2));


    }


}
