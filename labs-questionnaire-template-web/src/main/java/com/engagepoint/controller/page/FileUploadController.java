package com.engagepoint.controller.page;

import com.engagepoint.model.questionnaire.TemplateBean;
import com.engagepoint.utils.XmlImportExport;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import java.io.*;
import java.util.Collections;
import java.util.List;

@Named
@SessionScoped
public class FileUploadController implements Serializable {

    private Part uploadFile;

    @Inject
    private ListController listController;

    public FileUploadController() throws IOException {
    }

    public Part getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(Part part) {
        uploadFile = part;
    }

    /**
     * Perform import questionnaire from XML file.
     */
    public void importFromXML() throws IOException {
        listController.addAllTemplates(XmlImportExport.importXmlTemplate(uploadFile.getInputStream()));
    }
}
