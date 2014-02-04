package com.engagepoint.mock.impl.list;

import com.engagepoint.bean.GroupBean;
import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.SectionBean;
import com.engagepoint.bean.TemplateBean;
import com.engagepoint.mock.MockBeansList;
import com.engagepoint.mock.impl.bean.AllFilledBeans;

import java.util.ArrayList;
import java.util.List;

public class AllFilledBeansList implements MockBeansList {
    List<QuestionBean> questions = new ArrayList<QuestionBean>();
    List<GroupBean> groups = new ArrayList<GroupBean>();
    List<SectionBean> sections = new ArrayList<SectionBean>();
    List<TemplateBean> templates = new ArrayList<TemplateBean>();

    @Override
    public List<TemplateBean> getTemplatesList() {
        templates.add((new AllFilledBeans()).getTemplate());

        return templates;
    }

    @Override
    public List<SectionBean> getSectionsList() {
        sections.add((new AllFilledBeans()).getSection());

        return sections;
    }

    @Override
    public List<GroupBean> getGroupsList() {
        groups.add((new AllFilledBeans()).getGroup());

        return groups;
    }

    @Override
    public List<QuestionBean> getQuestionsList() {
        questions.add((new AllFilledBeans()).getQuestion());

        return questions;
    }

    @Override
    public String description() {
        return null;
    }
}
