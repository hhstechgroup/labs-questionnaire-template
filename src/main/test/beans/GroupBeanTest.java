package beans;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yurii.kucharskiy on 1/28/14.
 */
public class GroupBeanTest {
    @Test
    public void testClone() throws Exception {
        GroupBean groupBean = new GroupBean();
        GroupBean cloneGroupBean = (GroupBean) groupBean.clone();
        Assert.assertEquals(groupBean, cloneGroupBean);
    }
}
