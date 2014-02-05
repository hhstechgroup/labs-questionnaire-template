package com.engagepoint.utils;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;
import com.engagepoint.mock.TemplateBeanMock;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;


public class XmlImportExportTest {
    String filePath = "temp.xml";
    List<TemplateBean> templatesImported;

    public XmlImportExportTest() throws Exception {
        exportXmlTemplate();
        templatesImported = importXmlTemplate();
    }

    public void exportXmlTemplate() throws Exception {
        XmlImportExport.exportXmlTemplates(TemplateBeanMock.getList(), filePath);
    }

    public List<TemplateBean> importXmlTemplate() throws Exception {
        return XmlImportExport.importXmlTemplate(filePath);
    }

    @Test
    public void testAllImportExportXmlTemplate() throws Exception {
        Assert.assertEquals(TemplateBeanMock.getList(), templatesImported);
    }

    @Test
    @Ignore
    public void testFirstImportDesignThanExportToTempAll()throws Exception{
        List<TemplateBean> temp = XmlImportExport.importXmlTemplate("Design.xml");
        XmlImportExport.exportXmlTemplates(temp, "tempExport.xml");
        Assert.assertEquals(temp,
                XmlImportExport.importXmlTemplate("tempAll.xml"));
    }

    @Test
    public void testTemplateName()throws Exception{
        Assert.assertEquals(TemplateBeanMock.getList().get(0).getTemplateName(),
                templatesImported.get(0).getTemplateName());
    }

    @Test
    public void testSectionPageNumber()throws Exception{
        SectionBean section = TemplateBeanMock.getList().get(0).getSectionsList().get(0);
        Assert.assertEquals(section.getPageNumber(),
                templatesImported.get(0).getSectionsList().get(0).getPageNumber());
    }

    @Test
    public void testGroupName()throws Exception{
        GroupBean group = TemplateBeanMock.getList().get(0).getSectionsList().get(0).getGroupsList().get(0);
        Assert.assertEquals(group.getGroupName(),
                templatesImported.get(0).getSectionsList().get(0).getGroupsList().get(0).getGroupName());
    }

    @Test
    public void testQuestionId()throws Exception{
        QuestionBean question = TemplateBeanMock.getList().get(0).getSectionsList().
                get(0).getGroupsList().get(0).getQuestionsList().get(0);
        Assert.assertEquals(question.getId(),
                templatesImported.get(0).getSectionsList().get(0).getGroupsList().get(0).getQuestionsList().
                        get(0).getId());
    }

    @Test
    public void testQuestionText()throws Exception{
        QuestionBean question = TemplateBeanMock.getList().get(0).getSectionsList().
                get(0).getGroupsList().get(0).getQuestionsList().get(0);
        Assert.assertEquals(question.getQuestionTitle(),
                templatesImported.get(0).getSectionsList().get(0).getGroupsList().get(0).getQuestionsList().
                        get(0).getQuestionTitle());
    }

    @Test
    public void testQuestionType()throws Exception{
        QuestionBean question = TemplateBeanMock.getList().get(0).getSectionsList().
                get(0).getGroupsList().get(0).getQuestionsList().get(0);
        Assert.assertEquals(question.getQuestionType(),
                templatesImported.get(0).getSectionsList().get(0).getGroupsList().get(0).getQuestionsList().
                        get(0).getQuestionType());
    }

}
