package com.engagepoint.utils;


import com.engagepoint.bean.TemplateBean;
import com.engagepoint.bean.Wrapper;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.swing.*;
import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.List;

public class XmlImportExport {
    /**
     * Unmarshal XML to Wrapper and return List value.
     */
    private static <T> List<T> unmarshal(Unmarshaller unmarshaller,
                                         Class<T> clazz, String xmlLocation) throws JAXBException {
        StreamSource xml = new StreamSource(xmlLocation);
        Wrapper<T> wrapper = (Wrapper<T>) unmarshaller.unmarshal(xml,
                Wrapper.class).getValue();
        return wrapper.getItems();
    }

    /**
     * Wrap List in Wrapper, then leverage JAXBElement to supply root element
     * information.
     */
    private static void marshal(Marshaller marshaller, List<?> list, String name)
            throws JAXBException {
        QName qName = new QName(name);
        Wrapper wrapper = new Wrapper(list);
        JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName,
                Wrapper.class, wrapper);
        marshaller.marshal(jaxbElement, System.out);
    }


    /**
     * Import XML date into TemplateBean objects.
     *
     * @param filePath absolute path to file location
     * @return List of TemplateBean objects.
     */
    public static List<TemplateBean> importXmlTemplate(String filePath) {
        List<TemplateBean> list = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(Wrapper.class, TemplateBean.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            list = unmarshal(unmarshaller, TemplateBean.class, filePath);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Export java objects into XML.
     *
     * @param listTemplateBean list of TemplateBean objects
     */
    public static void exportXmlTemplate(List<TemplateBean> listTemplateBean) {

        try {
            File file = new File("C:\\Users\\stanislav.sobolev\\Desktop\\Software\\file.xml");
            FileOutputStream fileOutputStream = new FileOutputStream(file);

            JAXBContext jc = JAXBContext.newInstance(TemplateBean.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.marshal(listTemplateBean, fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
