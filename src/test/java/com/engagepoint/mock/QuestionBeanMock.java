package com.engagepoint.mock;

import com.engagepoint.bean.QuestionBean;
import com.engagepoint.bean.QuestionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionBeanMock {
    static List<QuestionBean> list = new ArrayList<QuestionBean>();
    //static Map<String, QuestionBean> map = new HashMap<String,QuestionBean>();
    static QuestionBean defaultVal;

    /// **************** Create New Examples in static initialisation *******************
    static
    {
        defaultVal=builder(1,"Some text",false,QuestionType.CHECKBOX);
        list.add(defaultVal);
        list.add(builder(2,"Opapa",false, QuestionType.DATE));
    }
    /// ***********************************************************************

    static public List<QuestionBean> getList(){
        return list;
    }
    static public QuestionBean getSingle(){return  defaultVal;}

    static private QuestionBean builder(long id, String questionText, Boolean requiredAnswer,
                                        QuestionType questionType){
        QuestionBean question = new QuestionBean();
        question.setId(Long.valueOf(id));
        question.setQuestionTitle(questionText);
        question.setRequiredAnswer(requiredAnswer);
        question.setQuestionType(questionType);

        return question;
    }

}
