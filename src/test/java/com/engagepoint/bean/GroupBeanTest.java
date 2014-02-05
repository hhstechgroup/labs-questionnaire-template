package com.engagepoint.bean;

import com.engagepoint.mock.GroupBeanMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class GroupBeanTest {

    @Test
    public void testCloneGroupBean() throws Exception {

        Assert.assertEquals(GroupBeanMock.getSingle(), GroupBeanMock.getSingle().clone());

    }


}
