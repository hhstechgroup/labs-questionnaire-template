package com.engagepoint.mock.impl.bean;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;
import com.engagepoint.mock.MockBean;

/**
 * Created by yurii.kucharskiy on 2/4/14.
 */
public class NotNullBeans implements MockBean {

    @Override
    public TemplateBean getTemplate() {
        return new TemplateBean();
    }

    @Override
    public SectionBean getSection() {
        return new SectionBean();
    }

    @Override
    public GroupBean getGroup() {
        return new GroupBean();
    }

    @Override
    public QuestionBean getQuestion() {
        return new QuestionBean();
    }

    @Override
    public String description() {
        return null;
    }
}
