package com.engagepoint.utils.mockBeanListImpl;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;
import com.engagepoint.utils.MockBeansList;

import java.util.List;

/**
 * Created by yaroslav.nikolaiko on 2/4/14.
 */
public class MockBeanListImpl_all_Null implements MockBeansList {

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
