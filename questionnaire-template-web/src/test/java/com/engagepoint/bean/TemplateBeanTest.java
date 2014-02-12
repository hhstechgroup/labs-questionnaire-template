package com.engagepoint.bean;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class TemplateBeanTest {

    @Test
    public void testCloneTemplateBean() throws Exception {
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
        ArrayList<GroupBasicBean> groupBeans1 = new ArrayList<GroupBasicBean>();
        QuestionBasicBean bean1 = new QuestionBasicBean("blahn",true, QuestionType.CHECKBOX);
        QuestionBasicBean eqBean1 = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        List<QuestionBasicBean> questionBeanList1 = new ArrayList<QuestionBasicBean>();
        questionBeanList1.add(bean1);
        questionBeanList1.add(eqBean1);
        GroupBasicBean groupBean2 = new GroupBasicBean("EqBeans",questionBeanList1);
        GroupBasicBean groupBean3 = new GroupBasicBean("EqBeans",questionBeanList1);
        groupBeans1.add(groupBean2);
        groupBeans1.add(groupBean3);
        SectionBasicBean section2 = new SectionBasicBean(2,groupBeans1);
        ArrayList<SectionBasicBean> sectionsList = new ArrayList<SectionBasicBean>();
        sectionsList.add(section1);
        sectionsList.add(section2);
        TemplateBean testTemplate = new TemplateBean(new Long(5),"Questonnaire",sectionsList);
        Assert.assertEquals(testTemplate, testTemplate.clone());
    }
    @Test
    public void testEqualityTemplates(){
        QuestionBasicBean bean = new QuestionBasicBean("blah",false, QuestionType.CHECKBOX);
        QuestionBasicBean eqBean = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        //---------------------------------1---------------------------------------
        List<QuestionBasicBean> questionBeanList = new ArrayList<QuestionBasicBean>();
        questionBeanList.add(bean);
        questionBeanList.add(eqBean);
        //-----------------------------1----------------------------------------------
        GroupBasicBean testBean = new GroupBasicBean("EqBeans",questionBeanList);
        GroupBasicBean testBean2 = new GroupBasicBean("EqBeans",questionBeanList);
        ArrayList<GroupBasicBean> groupBeans = new ArrayList<GroupBasicBean>();
        groupBeans.add(testBean);
        groupBeans.add(testBean2);
        //--------------------------------1------------------------------------
        SectionBasicBean section1 = new SectionBasicBean(2,groupBeans);
        QuestionBasicBean bean1 = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        QuestionBasicBean eqBean1 = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        //-----------------------------------1-------------------------------
        List<QuestionBasicBean> questionBeanList1 = new ArrayList<QuestionBasicBean>();
        questionBeanList1.add(bean1);
        questionBeanList1.add(eqBean1);
        //-------------------------------------------1------------------------------
        GroupBasicBean groupBean2 = new GroupBasicBean("EqBeans",questionBeanList1);
        GroupBasicBean groupBean3 = new GroupBasicBean("EqBeans",questionBeanList1);
        ArrayList<GroupBasicBean> groupBeans1 = new ArrayList<GroupBasicBean>();
        groupBeans1.add(groupBean2);
        groupBeans1.add(groupBean3);
        SectionBasicBean section2 = new SectionBasicBean(2,groupBeans1);
        //----------------------------------1-----------------------------
        ArrayList<SectionBasicBean> sectionsList = new ArrayList<SectionBasicBean>();
        sectionsList.add(section1);
        sectionsList.add(section2);
        TemplateBean testTemplate = new TemplateBean(new Long(5),"Questionnaire",sectionsList);
        //end of first template
        //
        QuestionBasicBean bean12 = new QuestionBasicBean("blah",false, QuestionType.CHECKBOX);
        QuestionBasicBean eqBean13 = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        List<QuestionBasicBean> questionBeanList13 = new ArrayList<QuestionBasicBean>();
        questionBeanList13.add(bean12);
        questionBeanList13.add(eqBean13);
        GroupBasicBean testBean21 = new GroupBasicBean("EqBeans",questionBeanList13);
        GroupBasicBean testBean22 = new GroupBasicBean("EqBeans",questionBeanList13);
        ArrayList<GroupBasicBean> groupBeans12 = new ArrayList<GroupBasicBean>();
        groupBeans12.add(testBean21);
        groupBeans12.add(testBean22);
        SectionBasicBean section12 = new SectionBasicBean(2,groupBeans12);
        ArrayList<GroupBasicBean> groupBeans11 = new ArrayList<GroupBasicBean>();
        QuestionBasicBean bean18 = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        QuestionBasicBean eqBean19 = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        List<QuestionBasicBean> questionBeanList14 = new ArrayList<QuestionBasicBean>();
        questionBeanList14.add(bean18);
        questionBeanList14.add(eqBean19);
        GroupBasicBean groupBean24 = new GroupBasicBean("EqBeans",questionBeanList14);
        GroupBasicBean groupBean37 = new GroupBasicBean("EqBeans",questionBeanList14);
        groupBeans11.add(groupBean24);
        groupBeans11.add(groupBean37);
        SectionBasicBean section21 = new SectionBasicBean(2,groupBeans11);
        ArrayList<SectionBasicBean> sectionsList1 = new ArrayList<SectionBasicBean>();
        sectionsList1.add(section12);
        sectionsList1.add(section21);
        TemplateBean testTemplate1 = new TemplateBean(new Long(5),"Questionnaire",sectionsList1);
        Assert.assertTrue(testTemplate.equals(testTemplate1));

    }
}
