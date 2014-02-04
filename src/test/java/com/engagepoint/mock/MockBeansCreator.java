package com.engagepoint.mock;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;

import java.util.List;

/**
 * Created by stanislav.sobolev on 2/4/14.
 */
public class MockBeansCreator {
    MockBean mockBean;
    MockBeansList mockBeanList;

    public void setMockBeanList(MockBeansList mockBeanList) {
        this.mockBeanList = mockBeanList;
    }

    public void setMockBean(MockBean mockBean) {
        this.mockBean = mockBean;
    }

    public TemplateBean getTemplateBean() {
        return mockBean.getTemplate();
    }
    public SectionBean getSectionBean() {
        return mockBean.getSection();
    }
    public GroupBean getGroupBean() {
        return mockBean.getGroup();
    }
    public QuestionBean getQuestionBean() {
        return mockBean.getQuestion();
    }

    public List<TemplateBean> getTemplatesList() {
        return mockBeanList.getTemplatesList();
    }
    public List<SectionBean> getSectionsList(){
        return mockBeanList.getSectionsList();
    }
    public List<GroupBean> getGroupsList(){
        return mockBeanList.getGroupsList();
    }
    private List<QuestionBean> getQuestionsList(){
        return mockBeanList.getQuestionsList();
    }
}

