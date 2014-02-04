package com.engagepoint.tests.mock.impl.bean;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;
import com.engagepoint.tests.mock.MockBean;

/**
 * Created by yaroslav.nikolaiko on 2/4/14.
 */
public class AllNullMockBean implements MockBean {
    @Override
    public TemplateBean getTemplate() {
        return null;
    }

    @Override
    public SectionBean getSection() {
        return null;
    }

    @Override
    public GroupBean getGroup() {
        return null;
    }

    @Override
    public QuestionBean getQuestion() {
        return null;
    }
}
