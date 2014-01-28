package beans;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by yurii.kucharskiy on 1/28/14.
 */
public class TemplateBeanTest {
    @Test
    public void testClone() throws Exception {
        TemplateBean templateBean = new TemplateBean();
        TemplateBean cloneTemplateBean = (TemplateBean) templateBean.clone();
        Assert.assertEquals(templateBean, cloneTemplateBean);
    }
}
