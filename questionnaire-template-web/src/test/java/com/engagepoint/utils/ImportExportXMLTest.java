package com.engagepoint.utils;

import com.engagepoint.bean.*;
import com.engagepoint.controller.FileController;
import junit.framework.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 2/10/14
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class ImportExportXMLTest {
    @Test
    public void testEqualityXML() throws FileNotFoundException {
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
        List<TemplateBean> tempList = new ArrayList<TemplateBean>();
        tempList.add(testTemplate);
        tempList.add(testTemplate1);
        //-----------------------------------------------------------------------------------------
        File file = null;
        try {
            file = FileController.createTempXml(tempList);
        }
        catch (IOException e) {
            Assert.fail();
            return;
        }
        FileInputStream stream = new FileInputStream(file.getAbsolutePath());
        List<TemplateBean> newTempsList = new ArrayList<TemplateBean>();
        newTempsList.addAll(XmlImportExport.importXmlTemplate(stream));
        Assert.assertTrue(tempList.equals(newTempsList));
    }
}
