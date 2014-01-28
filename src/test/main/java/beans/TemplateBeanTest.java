package main.java.beans;

import beans.SectionBean;
import beans.TemplateBean;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yurii.kukharskyi on 1/28/14.
 */
public class TemplateBeanTest {
    TemplateBean templateBean;

    public void createSectionBean() {
        templateBean = new TemplateBean();
        // Calling setters in templateBean
    }

    @Test
    public void testClone() throws Exception {
        TemplateBean cloneTemplateBean = (TemplateBean) templateBean.clone();
        Assert.assertEquals(templateBean, cloneTemplateBean);
    }
}
