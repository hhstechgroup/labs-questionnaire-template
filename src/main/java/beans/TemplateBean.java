package beans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 1/28/14
 * Time: 12:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class TemplateBean {
    private String templateName;
    private List<SectionBean> sectionsList;

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public List<SectionBean> getSectionsList() {
        return sectionsList;
    }

    public void setSectionsList(List<SectionBean> sectionsList) {
        this.sectionsList = sectionsList;
    }
}
