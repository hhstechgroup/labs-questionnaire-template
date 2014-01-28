package main.java.beans;

import com.engagepoint.bean.GroupBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class GroupBeanTest {
    GroupBean groupBean;

    @Before
    public void createGroupBean() {
        groupBean = new GroupBean();
        // Calling setters in groupBean
    }

    @Test
    public void testClone() throws Exception {
        GroupBean cloneGroupBean = (GroupBean) groupBean.clone();
        Assert.assertEquals(groupBean, cloneGroupBean);
    }
}
