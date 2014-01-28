package main.java.beans;

import beans.SectionBean;
import com.engagepoint.controller.SessionController;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class SectionBeanTest {
    SectionBean sectionBean;

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
