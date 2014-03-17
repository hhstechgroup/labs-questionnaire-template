package com.engagepoint.bean;


import com.engagepoint.mock.MockTemplate;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.QuestionType;
import com.engagepoint.model.questionnaire.SectionBean;
import com.engagepoint.model.questionnaire.TemplateBean;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
* Created by yurii.kukharskyi on 1/28/14.
*/
public class TemplateBeanTest {
    MockTemplate mock = new MockTemplate(QuestionType.CHECKBOX);

    @Test
    public void testCloneTemplateBean() throws Exception {
        TemplateBean testTemplateClone = (TemplateBean) mock.template().clone();
        Assert.assertEquals(mock.template().getTemplateName(), testTemplateClone.getTemplateName());
        Assert.assertEquals(mock.template().getSectionsList(), testTemplateClone.getSectionsList());
    }
    @Test
    public void testEqualityTemplates(){
        Question bean = mock.question();
        Question eqBean = null;
        try {
            eqBean = (Question)mock.question().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //---------------------------------1---------------------------------------
        List<Question> questionBeanList = new ArrayList<Question>();
        questionBeanList.add(bean);
        questionBeanList.add(eqBean);
        //-----------------------------1----------------------------------------------
        GroupBean testBean = mock.creatorGroup();
        GroupBean testBean2 = mock.creatorGroup();
        ArrayList<GroupBean> groupBeans = new ArrayList<GroupBean>();
        groupBeans.add(testBean);
        groupBeans.add(testBean2);
        //--------------------------------1------------------------------------
        SectionBean section1 = mock.creatorSections();
        Question bean1 = null;
        Question eqBean1 = null;
        try {
            bean1 = (Question)mock.question().clone();
            eqBean1 = (Question)mock.question().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //-----------------------------------1-------------------------------
        List<Question> questionBeanList1 = new ArrayList<Question>();
        questionBeanList1.add(bean1);
        questionBeanList1.add(eqBean1);
        //-------------------------------------------1------------------------------
        GroupBean groupBean2 = mock.creatorGroup();
        GroupBean groupBean3 = mock.creatorGroup();
        ArrayList<GroupBean> groupBeans1 = new ArrayList<GroupBean>();
        groupBeans1.add(groupBean2);
        groupBeans1.add(groupBean3);
        SectionBean section2 = mock.creatorSections();
        //----------------------------------1-----------------------------
        ArrayList<SectionBean> sectionsList = new ArrayList<SectionBean>();
        sectionsList.add(section1);
        sectionsList.add(section2);
        TemplateBean testTemplate = new TemplateBean(new Long(5),"Questionnaire",sectionsList);
        //end of first template
        //
        Question bean12 = null;
        Question eqBean13 = null;
        try {
            bean12 = (Question)mock.question().clone();
            bean12.setRequiredAnswer(false);
            eqBean13 = (Question)mock.question().clone();
            eqBean13.setRequiredAnswer(true);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        List<Question> questionBeanList13 = new ArrayList<Question>();
        questionBeanList13.add(bean12);
        questionBeanList13.add(eqBean13);
        GroupBean testBean21 = mock.creatorGroup();
        GroupBean testBean22 = mock.creatorGroup();
        ArrayList<GroupBean> groupBeans12 = new ArrayList<GroupBean>();
        groupBeans12.add(testBean21);
        groupBeans12.add(testBean22);
        SectionBean section12 = mock.creatorSections();
        ArrayList<GroupBean> groupBeans11 = new ArrayList<GroupBean>();
        Question bean18 = null;
        Question eqBean19 = null;
        try {
            eqBean19 = (Question)mock.question().clone();
            bean18 = (Question)mock.question().clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        List<Question> questionBeanList14 = new ArrayList<Question>();
        questionBeanList14.add(bean18);
        questionBeanList14.add(eqBean19);
        GroupBean groupBean24 = mock.creatorGroup();
        GroupBean groupBean37 = mock.creatorGroup();
        groupBeans11.add(groupBean24);
        groupBeans11.add(groupBean37);
        SectionBean section21 = mock.creatorSections();
        ArrayList<SectionBean> sectionsList1 = new ArrayList<SectionBean>();
        sectionsList1.add(section12);
        sectionsList1.add(section21);
        TemplateBean testTemplate1 = new TemplateBean(new Long(5),"Questionnaire",sectionsList1);
        Assert.assertTrue(testTemplate.equals(testTemplate1));

    }
}
