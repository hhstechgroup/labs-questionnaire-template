package com.engagepoint.bean;

import com.engagepoint.mock.QuestionBeanMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class QuestionBeanTest {

    @Test
    public void testCloneQuestionBean() throws Exception {
        Assert.assertEquals(QuestionBeanMock.getSingle(), QuestionBeanMock.getSingle().clone());
    }
}
