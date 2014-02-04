package com.engagepoint;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;
import com.engagepoint.utils.MockBean;
import com.engagepoint.utils.MockBeansList;
import com.engagepoint.utils.mockBeanImpl.MockBeanImpl_all_Null;
import com.engagepoint.utils.mockBeanListImpl.MockBeanListImpl_all_Null;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stanislav.sobolev on 2/4/14.
 */
public class MockBeansCreator {
    TemplateBean templateBean;
    MockBean mockBean;
    MockBeansList mockBeanList;

    public MockBeansCreator() {
        mockBean = new MockBeanImpl_all_Null();
        mockBeanList = new MockBeanListImpl_all_Null();
        mockBeansCreator();
    }
    private void mockBeansCreator() {
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

