package com.engagepoint.utils;

import com.engagepoint.MockBeansCreator;
import com.engagepoint.bean.TemplateBean;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stanislav.sobolev on 2/4/14.
 */
public class XmlImportExportTest {
    @Test
    public void testExportXmlTemplate() throws Exception {
        MockBeansCreator beansCreator = new MockBeansCreator();
        XmlImportExport.exportXmlTemplate(beansCreator.templateBeanList(),
                "temp.xml");
    }
}
