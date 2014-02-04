package com.engagepoint.utils;

import com.engagepoint.tests.mock.MockBeansCreator;
import org.junit.Test;

/**
 * Created by stanislav.sobolev on 2/4/14.
 */
public class XmlImportExportTest {
    @Test
    public void testExportXmlTemplate() throws Exception {
        MockBeansCreator beansCreator = new MockBeansCreator();
        XmlImportExport.exportXmlTemplate(beansCreator.getTemplatesList(),
                "temp.xml");
    }
}
