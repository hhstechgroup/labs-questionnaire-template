package com.engagepoint;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stanislav.sobolev on 2/4/14.
 */
public class MockBeansCreator {
    TemplateBean templateBean;

    public MockBeansCreator() {
        mockBeansCreator();
    }

    public TemplateBean getTemplateBean() {
        return templateBean;
    }

    public List<TemplateBean> templateBeanList() {
        List<TemplateBean> templateBeans = new ArrayList<TemplateBean>();
        templateBeans.add(templateBean);
        TemplateBean templateBean1 = new TemplateBean();
        templateBean1.setTemplateName("T2");
        templateBeans.add(templateBean1);
        TemplateBean templateBean2 = new TemplateBean();
        templateBean2.setTemplateName("T3");
        templateBeans.add(templateBean2);
        return templateBeans;
    }

    private void mockBeansCreator() {
        templateBean = new TemplateBean();
        templateBean.setTemplateName("Template One");
        templateBean.setSectionsList(listSections());
    }

    private List<SectionBean> listSections(){
        List<SectionBean> sectionBeans = new ArrayList<SectionBean>();
        /// ********** First Group ************
        SectionBean section = new SectionBean();
        section.setPageNumber(3);
        section.setGroupsList(listGroups());
        /// ****************************************

        sectionBeans.add(section);
        return sectionBeans;
    }
    private List<GroupBean> listGroups(){
        List<GroupBean> groupBeans = new ArrayList<GroupBean>();
        /// ********** First Group ************
        GroupBean group = new GroupBean();
        group.setGroupName("Group First");
        group.setQuestionsList(listQuestions());
        /// ****************************************

        groupBeans.add(group);
        return groupBeans;

    }
    private List<QuestionBean> listQuestions(){
        List<QuestionBean> questionsBeans = new ArrayList<QuestionBean>();
        /// ********** First Question ************
        QuestionBean question = new QuestionBean();
        question.setId(Long.valueOf(666));
        question.setQuestionTitle("First Question");
        question.setRequiredAnswer(true);
        /// ****************************************

        questionsBeans.add(question);
        return questionsBeans;
    }


}

