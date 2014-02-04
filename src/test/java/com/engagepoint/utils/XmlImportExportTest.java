package com.engagepoint.utils;

import com.engagepoint.mock.MockBeansCreator;
import com.engagepoint.mock.impl.list.AllNullMockBeansList;
import com.engagepoint.mock.impl.list.OneNullOneRealBeansList;
import org.junit.Test;

/**
 * Created by stanislav.sobolev on 2/4/14.
 */
public class XmlImportExportTest {
    @Test
    public void testExportXmlTemplate() throws Exception {
        MockBeansCreator beansCreator = new MockBeansCreator();
        beansCreator.setMockBeanList(new OneNullOneRealBeansList());
        XmlImportExport.exportXmlTemplate(beansCreator.getTemplatesList(),
                "temp.xml");
    }
}
