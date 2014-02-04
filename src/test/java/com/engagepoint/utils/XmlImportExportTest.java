package com.engagepoint.utils;

import com.engagepoint.bean.TemplateBean;
import com.engagepoint.mock.MockBeansCreator;
import com.engagepoint.mock.MockBeansList;
import com.engagepoint.mock.impl.list.AllNullMockBeansList;
import com.engagepoint.mock.impl.list.MockBeansListContainer;
import com.engagepoint.mock.impl.list.OneNullOneRealBeansList;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 * Created by stanislav.sobolev on 2/4/14.
 */
public class XmlImportExportTest {
    MockBeansCreator beansCreator = new MockBeansCreator();
    List<MockBeansList> mockBeansListList = new MockBeansListContainer().getList();
    String filePath = "temp.xml";

    public void exportXmlTemplate() throws Exception {
        XmlImportExport.exportXmlTemplate(beansCreator.getTemplatesList(),
                filePath);
    }

    public List<TemplateBean> importXmlTemplate() throws Exception {
        return XmlImportExport.importXmlTemplate(filePath);
    }

    @Ignore
    @Test
    public void testImportExportXmlTemplate() throws Exception {
        for (MockBeansList mockBeansList : mockBeansListList) {
            beansCreator.setMockBeanList(mockBeansList);
            if (beansCreator.getTemplatesList() != null) {
                exportXmlTemplate();
                Assert.assertEquals("export -> import is different" + "\nstep: " + mockBeansList.toString(),
                        beansCreator.getTemplatesList(), importXmlTemplate());
            }
        }
    }
}
