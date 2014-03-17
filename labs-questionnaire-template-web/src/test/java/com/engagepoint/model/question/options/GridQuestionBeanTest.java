package com.engagepoint.model.question.options;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GridQuestionBeanTest {

    private GridQuestionBean createBean() {
        GridQuestionBean gridQuestionBean = new GridQuestionBean();
        gridQuestionBean.addRow("row1");
        gridQuestionBean.addRow("row2");
        gridQuestionBean.addRow("row3");
        gridQuestionBean.addCol("col1");
        gridQuestionBean.addCol("col2");
        gridQuestionBean.addCol("col3");
        return gridQuestionBean;
    }

    private void selectAll(GridQuestionBean gridQuestionBean) {
        for (int i = 0; i < gridQuestionBean.getRows().size(); i++) {
            for (int j = 0; j < gridQuestionBean.getRows().size(); j++) {
                gridQuestionBean.setSelect(i, j, true);
            }
        }
    }


    @Test
    public void testAddRow() {
        GridQuestionBean gridQuestionBean = createBean();
        gridQuestionBean.addRow("newTestRow");
        Assert.assertTrue("list do not have this element", gridQuestionBean.getRows().contains("newTestRow"));


    }

    @Test
    public void testAddCol() {
        GridQuestionBean gridQuestionBean = createBean();
        gridQuestionBean.addCol("newTestCol");
        Assert.assertTrue("", gridQuestionBean.getCols().contains("newTestCol"));
    }

    @Test
    public void testUnselectRow()  {
        GridQuestionBean gridQuestionBean = createBean();
        selectAll(gridQuestionBean);
        gridQuestionBean.unselectRow(1);
        for (int i = 0; i <gridQuestionBean.getCols().size() ; i++) {
            Assert.assertTrue("Rows is selected!!!!",!gridQuestionBean.isSelect(1,i));

        }
    }

    @Test
    public void testUnselectCol() throws Exception {
        GridQuestionBean gridQuestionBean = createBean();
        selectAll(gridQuestionBean);
        gridQuestionBean.unselectCol(1);
        for (int i = 0; i <gridQuestionBean.getRows().size() ; i++) {
            Assert.assertTrue("Cols is selected!!!!",!gridQuestionBean.isSelect(i,1));

        }
    }
}
