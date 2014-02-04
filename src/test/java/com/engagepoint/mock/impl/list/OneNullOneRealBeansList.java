package com.engagepoint.mock.impl.list;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;
import com.engagepoint.mock.MockBean;
import com.engagepoint.mock.MockBeansList;
import com.engagepoint.mock.impl.bean.NotNullBeans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurii.kucharskiy on 2/4/14.
 */
public class OneNullOneRealBeansList extends AllNullMockBeansList implements MockBeansList {
    MockBean mockBean = new NotNullBeans();

    @Override
    public List<TemplateBean> getTemplatesList() {
        List<TemplateBean> templatesList = new ArrayList<TemplateBean>();
        templatesList.add(null);
        templatesList.add(mockBean.getTemplate());
        return templatesList;
    }

    @Override
    public List<SectionBean> getSectionsList() {
        return super.getSectionsList();
    }

    @Override
    public List<GroupBean> getGroupsList() {
        return super.getGroupsList();
    }

    @Override
    public List<QuestionBean> getQuestionsList() {
        return super.getQuestionsList();
    }
}
