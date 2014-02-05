package com.engagepoint.utils;


import com.engagepoint.bean.TemplateBean;
import com.engagepoint.bean.Wrapper;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
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
    private static void marshal(Marshaller marshaller, List<?> list, String rootElementName, String filePath)
            throws JAXBException, IOException {
        QName qName = new QName(rootElementName);
        Wrapper wrapper = new Wrapper(list);
        JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName,
                Wrapper.class, wrapper);
        OutputStream os = new FileOutputStream(filePath);
        marshaller.marshal(jaxbElement, os);
        os.close();
    }

    /**
     * Wrap List in Wrapper, then leverage JAXBElement to supply root element
     * information.
     */
    private static void marshal(Marshaller marshaller, List<?> list, String rootElementName, OutputStream os)
            throws JAXBException, IOException {
        QName qName = new QName(rootElementName);
        Wrapper wrapper = new Wrapper(list);
        JAXBElement<Wrapper> jaxbElement = new JAXBElement<Wrapper>(qName,
                Wrapper.class, wrapper);
        marshaller.marshal(jaxbElement, os);
        os.close();
    }

    /**
     * Import XML date into TemplateBean objects.
     *
     * @param filePath absolute path to XML file location
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
     * @param filePath         absolute path to XML file location
     */
    public static void exportXmlTemplates(List<TemplateBean> listTemplateBean, String filePath) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Wrapper.class, TemplateBean.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshal(marshaller, listTemplateBean, "questionnaire-forms", filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Export java objects into XML.
     *
     * @param template TemplateBean object
     * @param filePath absolute path to XML file location
     * @param listTemplateBean list of TemplateBean objects
     * @param outputStream     output stream
     */
    public static void exportXmlTemplates(List<TemplateBean> listTemplateBean, OutputStream outputStream) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Wrapper.class, TemplateBean.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshal(marshaller, listTemplateBean, "questionnaire-forms", outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Export java objects into XML.
     *
     * @param template         TemplateBean object
     * @param filePath         absolute path to XML file location
     */
    public static void exportXmlTemplate(TemplateBean template, String filePath) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Wrapper.class, TemplateBean.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            List<TemplateBean> list = new ArrayList<TemplateBean>();
            list.add(template);
            marshal(marshaller, list, "questionnaire-forms", filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Import XML into TemplateBean objects.
     *
     * @param inputStream inputStream of file
     * @return List of TemplateBean objects.
     */
    public static List<TemplateBean> importXmlTemplate(InputStream inputStream) {
        List<TemplateBean> list = null;
        try {
            JAXBContext jc = JAXBContext.newInstance(Wrapper.class, TemplateBean.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            StreamSource xml = new StreamSource(inputStream);
            Wrapper<TemplateBean> wrapper = (Wrapper<TemplateBean>) unmarshaller.unmarshal(xml,
                    Wrapper.class).getValue();
            list = wrapper.getItems();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return list;
    }
}
