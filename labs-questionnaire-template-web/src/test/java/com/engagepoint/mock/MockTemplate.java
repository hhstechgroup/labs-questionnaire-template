package com.engagepoint.mock;

import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.QuestionType;
import com.engagepoint.model.questionnaire.SectionBean;
import com.engagepoint.model.questionnaire.TemplateBean;
import com.engagepoint.model.question.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;




/**
 * Created by oleksandr.koval on 2/25/14.
 */
public class MockTemplate {
    TemplateBean templateBean;
    List<SectionBean> sectionBeans;
    List<GroupBean> groupBeans;
    List<QuestionBean> questionBeans;
    QuestionBean question;

    private QuestionType selectedQuestionType  ;
    public MockTemplate(QuestionType selectedQuestionType) {
        sectionBeans = new ArrayList<SectionBean>();
        questionBeans = new ArrayList<QuestionBean>();
        groupBeans =new ArrayList<GroupBean>();
        sectionBeans.add(creatorSections());
        templateBean = new TemplateBean();
        templateBean.setSectionsList(sectionBeans);
        groupBeans.add(creatorGroup());
        questionBeans.add(typeOfQuestion());
    }


    public QuestionBean typeOfQuestion(){


        switch (selectedQuestionType) {
            case TEXT:
                question =  new TextQuestionBean();
                TextQuestionBean tb =(TextQuestionBean)question;
                tb.setDefaultAnswer("i don't know");
                creator(question);
                return question;
            case DATE:
                question = new DateQuestionBean();
                DateQuestionBean dateQuestionBean = (DateQuestionBean)question;

                dateQuestionBean.setDefaultAnswer(new Date());
                creator(question);

                return question;
            case RANGE:
                question = new RangeQuestionBean();
                RangeQuestionBean rangeQuestionBean = (RangeQuestionBean)question;
                rangeQuestionBean.setMaxValue("do not need");
                rangeQuestionBean.setMinValue("help");
                creator(question);

                return question;
            case TIME:
                question = new DateQuestionBean();
                DateQuestionBean timeQuestionBean = (DateQuestionBean)question;
                timeQuestionBean.setDefaultAnswer(new Date());
                creator(question);
                return question;
            case PARAGRAPHTEXT:
                TextQuestionBean paragraph =(TextQuestionBean)question;
                paragraph.setDefaultAnswer("i don't know");
                creator(question);
                return question;

            case CHOOSEFROMLIST:
                question = new OptionsQuestionBean();
                OptionsQuestionBean choose = (OptionsQuestionBean)question;
                VariantItem variantItem = new  VariantItem();
                variantItem.setValue("nice");
                choose.setDefaultOption(variantItem);
                List<VariantItem>variantItemList = new ArrayList<VariantItem>();
                variantItemList.add(variantItem);
                choose.setOptions(variantItemList);
                creator(question);

                return question;
            case FILEUPLOAD:
                question = new TextQuestionBean();
                creator(question);
                return question;

            case MULTIPLECHOICE:
                question = new OptionsQuestionBean();
                creator(question);
                OptionsQuestionBean multiple = (OptionsQuestionBean)question;
                VariantItem variant = new  VariantItem();
                variant.setValue("nice");

                List<VariantItem>variantList = new ArrayList<VariantItem>();
                variantList.add(variant);
                multiple.setOptions(variantList);
                multiple.setDefaultOptions(variantList);

                return question;

        }

        return question;
    }
    public void creator(QuestionBean question){
        question.setHelpText("its my help");
        question.setQuestionText("WHY UYoA ArE SO SAD?");
        question.setId(1567L);

    }

    public SectionBean creatorSections(){
        SectionBean sectionBean=  new  SectionBean();
        sectionBean.setGroupsList(groupBeans);
        sectionBean.setPageNumber(1);
        return sectionBean;
    }
    public GroupBean creatorGroup(){
        GroupBean groupBean = new GroupBean();
        groupBean.setQuestionsList(questionBeans);
        groupBean.setGroupName("GroupName");
        return groupBean;
    }



}
