package com.engagepoint.bean;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class TemplateBeanTest {

   /* @Test
    public void testCloneTemplateBean() throws Exception {
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
        ArrayList<GroupBean> groupBeans1 = new ArrayList<GroupBean>();
        QuestionBean bean1 = new QuestionBean("blahn",true, QuestionType.CHECKBOX);
        QuestionBean eqBean1 = new QuestionBean("blah",true, QuestionType.CHECKBOX);
        List<QuestionBean> questionBeanList1 = new ArrayList<QuestionBean>();
        questionBeanList1.add(bean1);
        questionBeanList1.add(eqBean1);
        GroupBean groupBean2 = new GroupBean("EqBeans",questionBeanList1);
        GroupBean groupBean3 = new GroupBean("EqBeans",questionBeanList1);
        groupBeans1.add(groupBean2);
        groupBeans1.add(groupBean3);
        SectionBean section2 = new SectionBean(2,groupBeans1);
        ArrayList<SectionBean> sectionsList = new ArrayList<SectionBean>();
        sectionsList.add(section1);
        sectionsList.add(section2);
        TemplateBean testTemplate = new TemplateBean(new Long(5),"Questonnaire",sectionsList);
        TemplateBean testTemplateClone = (TemplateBean) testTemplate.clone();
        Assert.assertEquals(testTemplate.getTemplateName(), testTemplateClone.getTemplateName());
        Assert.assertEquals(testTemplate.getSectionsList(), testTemplateClone.getSectionsList());
    }
    @Test
    public void testEqualityTemplates(){
        QuestionBean bean = new QuestionBean("blah",false, QuestionType.CHECKBOX);
        QuestionBean eqBean = new QuestionBean("blah",true, QuestionType.CHECKBOX);
        //---------------------------------1---------------------------------------
        List<QuestionBean> questionBeanList = new ArrayList<QuestionBean>();
        questionBeanList.add(bean);
        questionBeanList.add(eqBean);
        //-----------------------------1----------------------------------------------
        GroupBean testBean = new GroupBean("EqBeans",questionBeanList);
        GroupBean testBean2 = new GroupBean("EqBeans",questionBeanList);
        ArrayList<GroupBean> groupBeans = new ArrayList<GroupBean>();
        groupBeans.add(testBean);
        groupBeans.add(testBean2);
        //--------------------------------1------------------------------------
        SectionBean section1 = new SectionBean(2,groupBeans);
        QuestionBean bean1 = new QuestionBean("blah",true, QuestionType.CHECKBOX);
        QuestionBean eqBean1 = new QuestionBean("blah",true, QuestionType.CHECKBOX);
        //-----------------------------------1-------------------------------
        List<QuestionBean> questionBeanList1 = new ArrayList<QuestionBean>();
        questionBeanList1.add(bean1);
        questionBeanList1.add(eqBean1);
        //-------------------------------------------1------------------------------
        GroupBean groupBean2 = new GroupBean("EqBeans",questionBeanList1);
        GroupBean groupBean3 = new GroupBean("EqBeans",questionBeanList1);
        ArrayList<GroupBean> groupBeans1 = new ArrayList<GroupBean>();
        groupBeans1.add(groupBean2);
        groupBeans1.add(groupBean3);
        SectionBean section2 = new SectionBean(2,groupBeans1);
        //----------------------------------1-----------------------------
        ArrayList<SectionBean> sectionsList = new ArrayList<SectionBean>();
        sectionsList.add(section1);
        sectionsList.add(section2);
        TemplateBean testTemplate = new TemplateBean(new Long(5),"Questionnaire",sectionsList);
        //end of first template
        //
        QuestionBean bean12 = new QuestionBean("blah",false, QuestionType.CHECKBOX);
        QuestionBean eqBean13 = new QuestionBean("blah",true, QuestionType.CHECKBOX);
        List<QuestionBean> questionBeanList13 = new ArrayList<QuestionBean>();
        questionBeanList13.add(bean12);
        questionBeanList13.add(eqBean13);
        GroupBean testBean21 = new GroupBean("EqBeans",questionBeanList13);
        GroupBean testBean22 = new GroupBean("EqBeans",questionBeanList13);
        ArrayList<GroupBean> groupBeans12 = new ArrayList<GroupBean>();
        groupBeans12.add(testBean21);
        groupBeans12.add(testBean22);
        SectionBean section12 = new SectionBean(2,groupBeans12);
        ArrayList<GroupBean> groupBeans11 = new ArrayList<GroupBean>();
        QuestionBean bean18 = new QuestionBean("blah",true, QuestionType.CHECKBOX);
        QuestionBean eqBean19 = new QuestionBean("blah",true, QuestionType.CHECKBOX);
        List<QuestionBean> questionBeanList14 = new ArrayList<QuestionBean>();
        questionBeanList14.add(bean18);
        questionBeanList14.add(eqBean19);
        GroupBean groupBean24 = new GroupBean("EqBeans",questionBeanList14);
        GroupBean groupBean37 = new GroupBean("EqBeans",questionBeanList14);
        groupBeans11.add(groupBean24);
        groupBeans11.add(groupBean37);
        SectionBean section21 = new SectionBean(2,groupBeans11);
        ArrayList<SectionBean> sectionsList1 = new ArrayList<SectionBean>();
        sectionsList1.add(section12);
        sectionsList1.add(section21);
        TemplateBean testTemplate1 = new TemplateBean(new Long(5),"Questionnaire",sectionsList1);
        Assert.assertTrue(testTemplate.equals(testTemplate1));

    }*/
}
