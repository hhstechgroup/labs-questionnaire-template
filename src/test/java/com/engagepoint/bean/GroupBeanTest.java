package com.engagepoint.bean;

import com.engagepoint.mock.MockBean;
import com.engagepoint.mock.MockBeansCreator;
import com.engagepoint.mock.impl.bean.MockBeanContainer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class GroupBeanTest {
    List<MockBean> mockBeanList = new MockBeanContainer().getList();
    MockBeansCreator  mockBeansCreator = new MockBeansCreator();

    @Test
    public void testClone() throws Exception {
        for (MockBean mockBean : mockBeanList) {
            mockBeansCreator.setMockBean(mockBean);
            if (mockBeansCreator.getGroupBean() != null) {
                Assert.assertEquals(mockBeansCreator.getGroupBean().toString(),
                        mockBeansCreator.getGroupBean(), mockBeansCreator.getGroupBean().clone());
            }
        }
    }
}
