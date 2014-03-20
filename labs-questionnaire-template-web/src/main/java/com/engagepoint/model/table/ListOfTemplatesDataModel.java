package com.engagepoint.model.table;

import java.util.List;
import javax.faces.model.ListDataModel;

import com.engagepoint.model.questionnaire.TemplateBean;
import org.primefaces.model.SelectableDataModel;

public class ListOfTemplatesDataModel extends ListDataModel<TemplateBean> implements SelectableDataModel<TemplateBean> {

    public ListOfTemplatesDataModel(List<TemplateBean> data) {
        super(data);
    }

    @Override
    public TemplateBean getRowData(String templateId) {
        List<TemplateBean> templates = (List<TemplateBean>) getWrappedData();
        for (TemplateBean template : templates) {
            if (template.getId().toString().equals(templateId)) {
                return template;
            }
        }
        return null;
    }

    @Override
    public Object getRowKey(TemplateBean template) {
        return template.getId();
    }
}
