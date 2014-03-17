package com.engagepoint.controller;

import com.engagepoint.model.questionnaire.TemplateBean;
import com.engagepoint.controller.page.ListController;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oleksandr.koval
 * Date: 2/12/14
 * Time: 12:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class ListControllerTest {
    private ListController testListController = new ListController();
    private List<TemplateBean> templateBeanList = new ArrayList<TemplateBean>();
    private List<TemplateBean> secondTemplateBeanList = new ArrayList<TemplateBean>();
    @Before
   public void creator(){
        for (long i = 0; i < 10; i++) {
            TemplateBean templateBean = new TemplateBean();
            templateBean.setId(i);
            templateBeanList.add(templateBean);
            secondTemplateBeanList.add(templateBean);
        }
    }


    @Test
    public void shouldAddTemplate(){

        testListController.setTemplates(templateBeanList);
        int startSize = testListController.getTemplates().size();

        // Variant 1: Add with exist id
        TemplateBean startBean = testListController.getTemplates().get(5);
        String formIdOfStartBean = startBean.getFormId();

        TemplateBean createdBean = new TemplateBean();
        createdBean.setFormId(formIdOfStartBean);
        testListController.addTemplateIfNotInList(createdBean);

        Assert.assertTrue("bean has been created, but it shouldn't", testListController.getTemplates().size()==startSize);

        // Variant 2: Add with new id
        TemplateBean addedBean = new TemplateBean();
        addedBean.setFormId(formIdOfStartBean+"11");
        templateBeanList.add(addedBean);

        Assert.assertTrue("bean has not been created, but it should",testListController.getTemplates().get(10).equals(addedBean));
    }
    @Test
    public void shouldDeleteTemplate(){

        TemplateBean template1 =new TemplateBean();
        template1.setId(15L);
        template1.setTemplateName("blahblah");
        templateBeanList.add(template1);

        for (int i = 0; i < templateBeanList.size() ; i++) {
            if (templateBeanList.get(i).getTemplateName().equals("blahblah")){
                templateBeanList.remove(i);
            }

        }
        Assert.assertTrue("Pacan, test zahodit norm", !templateBeanList.contains(template1));

    }
    @Test
    public void shouldAddTemplateToFilteredList(){
        testListController.setFilteredTemplates(templateBeanList);
        //  Add with exist id
        testListController.getFilteredTemplates().get(5).setTemplateName("exist");

        TemplateBean templateBean = new TemplateBean();
        templateBean.setId(5L);
        templateBean.setTemplateName("created");
        testListController.addTemplateToFilteredListIfNeed(templateBean);

        Assert.assertTrue("its exist because their id equals", !testListController.getFilteredTemplates().get(5).getTemplateName().equals("created"));

        // now we set filterValue and see how it works
        testListController.setFilterValue("testing");
        TemplateBean templateBean1 =new TemplateBean();
         templateBean1.setTemplateName("testing");
        testListController.addTemplateToFilteredListIfNeed(templateBean1);
        Assert.assertTrue("templateName and FilterValue not equals",testListController.getFilteredTemplates().contains(templateBean1));

    }
    @Test
    public void shouldRemoveTemplateFromFilteredList(){
       //if FilteredValue was changed after add
        testListController.setFilteredTemplates(templateBeanList);
        testListController.setFilterValue("testing");
        TemplateBean templateBean1 =new TemplateBean();
        templateBean1.setTemplateName("testing");
        testListController.addTemplateToFilteredListIfNeed(templateBean1);
        templateBean1.setTemplateName("lol");
        testListController.removeTemplateFromFilteredListIfNeed(templateBean1);
        Assert.assertTrue("templateName and FilterValue not equals",!testListController.getFilteredTemplates().contains(templateBean1));
        //  if second list dont have this item , method  does work

        testListController.setTemplates(secondTemplateBeanList);
        TemplateBean templateBean =new TemplateBean();
        templateBean.setTemplateName("testing");
         secondTemplateBeanList.add(templateBean);
        testListController.addTemplateToFilteredListIfNeed(templateBean);
        testListController.removeTemplateFromFilteredListIfNeed(templateBean);
        Assert.assertTrue(" second list contains this template",testListController.getFilteredTemplates().contains(templateBean));

    }


}
