package com.engagepoint.tests.mock.impl.list;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;
import com.engagepoint.tests.mock.MockBeansList;

import java.util.List;

/**
 * Created by yaroslav.nikolaiko on 2/4/14.
 */
public class AllNullMockBeansList implements MockBeansList {

    @Override
    public List<TemplateBean> getTemplatesList() {
        return null;
    }

    @Override
    public List<SectionBean> getSectionsList() {
        return null;
    }

    @Override
    public List<GroupBean> getGroupsList() {
        return null;
    }

    @Override
    public List<QuestionBean> getQuestionsList() {
        return null;
    }
}
