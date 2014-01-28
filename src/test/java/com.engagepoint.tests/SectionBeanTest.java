package main.java.beans;

import com.engagepoint.bean.SectionBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class SectionBeanTest {
    SectionBean sectionBean;

    @Before
    public void createSectionBean() {
        sectionBean = new SectionBean();
        // Calling setters in sectionBean
    }

    @Test
    public void testClone() throws Exception {
        SectionBean cloneSectionBean = (SectionBean) sectionBean.clone();
        Assert.assertEquals(sectionBean, cloneSectionBean);
    }
}
