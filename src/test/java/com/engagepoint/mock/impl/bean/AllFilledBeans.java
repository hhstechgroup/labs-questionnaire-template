package com.engagepoint.mock.impl.bean;


import com.engagepoint.bean.*;
import com.engagepoint.mock.MockBean;
import com.engagepoint.mock.MockBeansCreator;
import com.engagepoint.mock.impl.list.AllFilledBeansList;

import java.util.ArrayList;
import java.util.List;

public class AllFilledBeans implements MockBean {
    ///  ******************* Question *****************
    QuestionBean question = new QuestionBean();
    boolean requiredAnswer = true;
    String questionTitle = "Hello Question All";
    Long questionID = Long.valueOf(101);
    QuestionType questionType = QuestionType.CHECKBOX;

    /// ********************* Group *******************
    GroupBean group = new GroupBean();
    String groupName = "First Group";
    List<QuestionBean> questionBean = (new AllFilledBeansList()).getQuestionsList();

    /// ********************* Section ******************
    SectionBean section = new SectionBean();
    List<GroupBean> groupList = (new AllFilledBeansList()).getGroupsList();
    int pageNumber = 12;

    ///********************* Template ***************
    TemplateBean template = new TemplateBean();
    List<SectionBean> sectionList = (new AllFilledBeansList()).getSectionsList();

    public AllFilledBeans(){
        MockBeansCreator creator = new MockBeansCreator();
    }

    @Override
    public TemplateBean getTemplate() {
        template.setTemplateName("First Template");
        template.setSectionsList(sectionList);
        return template;
    }

    @Override
    public SectionBean getSection() {

        section.setPageNumber(pageNumber);
        section.setGroupsList(groupList);
        return section;
    }

    @Override
    public GroupBean getGroup() {

        group.setGroupName(groupName);
        group.setQuestionsList(questionBean);
        return group;
    }

    @Override
    public QuestionBean getQuestion() {

        question.setRequiredAnswer(requiredAnswer);
        question.setQuestionTitle(questionTitle);
        question.setId(questionID);
        question.setQuestionType(questionType);
        return question;
    }

    @Override
    public String description() {
        return null;
    }


}
