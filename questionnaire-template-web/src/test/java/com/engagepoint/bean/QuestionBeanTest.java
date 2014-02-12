package com.engagepoint.bean;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class QuestionBeanTest {

    @Test
    public void testCloneQuestionBean() throws CloneNotSupportedException {
        QuestionBasicBean bean = new QuestionBasicBean("blah",true,QuestionType.CHOOSEFROMLIST);

        Assert.assertTrue(bean.equals(bean.clone()));
    }
    @Test
    public void testEqualsQuestionBean(){
        QuestionBasicBean bean = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        QuestionBasicBean eqBean = new QuestionBasicBean("blah",true, QuestionType.CHECKBOX);
        Assert.assertTrue(bean.equals(eqBean));

    }

}
