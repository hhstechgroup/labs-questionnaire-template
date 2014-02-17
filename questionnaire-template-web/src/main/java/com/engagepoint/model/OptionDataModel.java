package com.engagepoint.model;

import com.engagepoint.bean.TemplateBean;
import org.primefaces.model.SelectableDataModel;

import javax.faces.model.ListDataModel;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anna.zagrebelnaya
 * Date: 2/4/14
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */


public class OptionDataModel extends ListDataModel<String> implements SelectableDataModel<String> {

    public OptionDataModel(List<String> data) {
        super(data);
    }

    @Override
    public String getRowData(String optionTitle) {
        return optionTitle;
    }

    @Override
    public Object getRowKey(String optionTitle) {
        return optionTitle;
    }
}
