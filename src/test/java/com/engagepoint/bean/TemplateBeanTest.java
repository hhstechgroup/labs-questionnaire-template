package com.engagepoint.bean;

import com.engagepoint.mock.TemplateBeanMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class TemplateBeanTest {

    @Test
    public void testCloneTemplateBean() throws Exception {
        Assert.assertEquals(TemplateBeanMock.getSingle(),
                TemplateBeanMock.getSingle().clone());

    }
}
