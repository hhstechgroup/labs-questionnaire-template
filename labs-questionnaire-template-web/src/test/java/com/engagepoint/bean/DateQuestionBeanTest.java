package com.engagepoint.bean;

import com.engagepoint.mock.MockTemplate;
import com.engagepoint.model.question.DateQuestionBean;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.questionnaire.QuestionType;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;

/**
 * Created by anton.kovunov on 3/19/14.
 */
public class DateQuestionBeanTest {
    MockTemplate mock = new MockTemplate(QuestionType.DATE);
    MockTemplate mock1 = new MockTemplate(QuestionType.TIME);
    @Test
    public void testDateFormat(){
        DateQuestionBean dateQuestion = (DateQuestionBean)mock.question();
        DateQuestionBean timeQuestion = (DateQuestionBean)mock1.question();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
        timeQuestion.setQuestionType(QuestionType.TIME);
        Assert.assertTrue(dateQuestion.getDateFormat().equals(df));
        Assert.assertTrue(timeQuestion.getDateFormat().equals(tf));

    }
}
