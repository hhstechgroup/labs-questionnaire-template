package com.engagepoint.mock;

import com.engagepoint.model.questionnaire.GroupBean;
import com.engagepoint.model.questionnaire.QuestionType;
import com.engagepoint.model.questionnaire.SectionBean;
import com.engagepoint.model.questionnaire.TemplateBean;
import com.engagepoint.model.question.*;

import java.util.ArrayList;
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
    public MockTemplate(TemplateBean templateBean,QuestionType selectedQuestionType) {
        sectionBeans = new ArrayList<SectionBean>();
        groupBeans =new ArrayList<GroupBean>();


        templateBean = new TemplateBean();
        templateBean.setSectionsList(sectionBeans);
        templateBean.getSectionsList().get(0).setGroupsList(groupBeans);
        templateBean.getSectionsList().get(0).getGroupsList().get(0).setQuestionsList(questionBeans);




        this.templateBean = templateBean;
    }


    public QuestionBean typeOfQuestion(){
        questionBeans = new ArrayList<QuestionBean>();

        switch (selectedQuestionType) {
            case TEXT:
                question = new TextQuestionBean();
                question.setHelpText("help u with textQuestion");
                return question;
            case DATE:
                question = new DateQuestionBean();
                question.setHelpText("help u with textQuestion");
                return question;
            case RANGE:
                question = new RangeQuestionBean();
                return question;
            case TIME:
                question = new DateQuestionBean();
                return question;
            case PARAGRAPHTEXT:
                question = new TextQuestionBean();
                return question;
            case CHOOSEFROMLIST:
                question = new OptionsQuestionBean();
                return question;
            case FILEUPLOAD:
                question = new TextQuestionBean();
                return question;
            case MULTIPLECHOICE:
                question = new OptionsQuestionBean();
                return question;

        }

        return question;
    }
}
