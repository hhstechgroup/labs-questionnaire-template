package com.engagepoint.model.question.options;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleksandr.koval on 3/18/14.
 */
public class Grid {
    List<String> rows;
    /**
     * List of columns
     */
    List<String> cols;
    @XmlElementWrapper(name = "rows")
    @XmlElement(name = "row")
    public List<String> getRows() {
        return rows;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }

    @XmlElementWrapper(name = "columns")
    @XmlElement(name = "column")
    public List<String> getCols() {
        return cols;
    }

    public void setCols(List<String> cols) {
        this.cols = cols;
    }
    public void clear() {
        rows =  new ArrayList<String>();
        cols = new ArrayList<String>();
    }

    public Grid() {

    }

}
