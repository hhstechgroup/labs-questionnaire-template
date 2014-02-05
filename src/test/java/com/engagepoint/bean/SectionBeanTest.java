package com.engagepoint.bean;

import com.engagepoint.mock.SectionBeanMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class SectionBeanTest {

    @Test
    public void testCloneSectionBean() throws Exception {
        Assert.assertEquals(SectionBeanMock.getSingle(), SectionBeanMock.getSingle().clone());

    }
}
