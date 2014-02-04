package com.engagepoint.utils;

import com.engagepoint.mock.MockBeansCreator;
import com.engagepoint.mock.impl.list.AllNullMockBeansList;
import com.engagepoint.mock.impl.list.OneNullOneRealBeansList;
import org.junit.Test;

/**
 * Created by stanislav.sobolev on 2/4/14.
 */
public class XmlImportExportTest {
    MockBeansCreator beansCreator = new MockBeansCreator();
    String filePath = "temp.xml";

    public void exportXmlTemplate() throws Exception {
        XmlImportExport.exportXmlTemplate(beansCreator.getTemplatesList(),
                filePath);
    }

    public void importXmlTemplate() throws Exception {
        XmlImportExport.importXmlTemplate(filePath);
    }

    @Test
    public void testImportExportXmlTemplate() throws Exception {

    }
}
