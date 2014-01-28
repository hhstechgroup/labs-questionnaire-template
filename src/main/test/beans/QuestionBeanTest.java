package beans;

import org.junit.Assert;

/**
 * Created by yurii.kucharskiy on 1/28/14.
 */
public class QuestionBeanTest {
    @org.junit.Test
    public void testClone() throws Exception {
        QuestionBean questionBean = new QuestionBean();
        QuestionBean cloneQuestionBean = (QuestionBean) questionBean.clone();
        Assert.assertEquals(questionBean, cloneQuestionBean);
    }
}
