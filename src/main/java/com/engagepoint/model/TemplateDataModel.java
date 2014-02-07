package com.engagepoint.model;

import java.util.List;
import javax.faces.model.ListDataModel;
import com.engagepoint.bean.TemplateBean;
import org.primefaces.model.SelectableDataModel;

/**
 * Created with IntelliJ IDEA.
 * User: anna.zagrebelnaya
 * Date: 2/4/14
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */


public class  TemplateDataModel extends ListDataModel<TemplateBean> implements SelectableDataModel<TemplateBean> {

    public TemplateDataModel(List<TemplateBean> data) {
        super(data);
    }

    @Override                             //TODO change name to id
    public TemplateBean getRowData(String templateName) {
        List<TemplateBean> templates = (List<TemplateBean>) getWrappedData();

        for(TemplateBean template : templates) {
            if(template.getTemplateName().equals(templateName))
                return template;
        }

        return null;
    }

    @Override
    public Object getRowKey(TemplateBean template) {
        return template.getTemplateName();
    }
}
