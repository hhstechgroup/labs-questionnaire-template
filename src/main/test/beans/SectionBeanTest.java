package beans;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yurii.kucharskiy on 1/28/14.
 */
public class SectionBeanTest {
    @Test
    public void testClone() throws Exception {
        SectionBean sectionBean = new SectionBean();
        SectionBean cloneSectionBean = (SectionBean) sectionBean.clone();
        Assert.assertEquals(sectionBean, cloneSectionBean);
    }
}
