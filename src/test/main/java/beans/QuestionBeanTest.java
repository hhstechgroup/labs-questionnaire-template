package main.java.beans;

import beans.QuestionBean;
import org.junit.Assert;
import org.junit.Before;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class QuestionBeanTest {
    QuestionBean questionBean;

    @Before
    public void createQuestionBean() {
        questionBean = new QuestionBean();
        // Calling setters in questionBean
    }

    @org.junit.Test
    public void testClone() throws Exception {
        QuestionBean cloneQuestionBean = (QuestionBean) questionBean.clone();
        Assert.assertEquals(questionBean, cloneQuestionBean);
    }
}
