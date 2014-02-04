package com.engagepoint;

import com.engagepoint.bean.TemplateBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stanislav.sobolev on 2/4/14.
 */
public class MockBeansCreator {
    TemplateBean templateBean;

    public MockBeansCreator() {
        mockBeansCreator();
    }

    public TemplateBean getTemplateBean() {
        return templateBean;
    }

    public List<TemplateBean> templateBeanList() {
        List<TemplateBean> templateBeans = new ArrayList<TemplateBean>();
        templateBeans.add(templateBean);
        TemplateBean templateBean1 = new TemplateBean();
        templateBean1.setTemplateName("T2");
        templateBeans.add(templateBean1);
        TemplateBean templateBean2 = new TemplateBean();
        templateBean2.setTemplateName("T3");
        templateBeans.add(templateBean2);
        return templateBeans;
    }

    private void mockBeansCreator() {
        templateBean = new TemplateBean();
        templateBean.setTemplateName("Template One");
    }
}
