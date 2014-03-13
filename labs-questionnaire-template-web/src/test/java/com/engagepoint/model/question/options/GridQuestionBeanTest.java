package com.engagepoint.model.question.options;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GridQuestionBeanTest {

    private GridQuestionBean createBean() {
        GridQuestionBean gridQuestionBean = new GridQuestionBean();
        gridQuestionBean.clear();
        List<String> rows = new ArrayList<String>();
        rows.add("row1");
        rows.add("row2");
        rows.add("row3");
        gridQuestionBean.setRows(rows);
        List<String> cols = new ArrayList<String>();
        cols.add("col1");
        cols.add("col2");
        cols.add("col3");
        gridQuestionBean.setCols(cols);
        boolean[][] booleans = new  boolean[3][3];
        gridQuestionBean.setSelected(booleans);
        return gridQuestionBean;
    }

    private void selectAll(GridQuestionBean gridQuestionBean) {
        boolean[][] booleans = gridQuestionBean.getSelected();
        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans[i].length; j++) {
                booleans[i][j] = true;
            }
        }
    }

    private String mkReport(GridQuestionBean gridQuestionBean) {
        String report = "\nRows                : " + gridQuestionBean.getRows().size() +
                        "\nCols                : " + gridQuestionBean.getCols().size() +
                        "\nSelected arr - rows : " + gridQuestionBean.getSelected().length;
        int i = 0;
        for (boolean[] booleans : gridQuestionBean.getSelected()) {
            report += "\n           > row #" + i++ + " : " + booleans.length;
        }
        report += "\n";
        return report;
    }

    private String mkSelectedReport(GridQuestionBean gridQuestionBean) {
        String report = "\nSelected:\n";
        boolean[][] booleans = gridQuestionBean.getSelected();
        for (boolean[] aBoolean : booleans) {
            for (boolean anABoolean : aBoolean) {
                if (anABoolean) {
                    report += "1 ";
                } else {
                    report += "0 ";
                }
            }
            report += "\n";
        }
        return report;
    }

    private void outReportOK(String report) {
        System.out.print("\nTest \"OK\"");
        System.out.println(report);
    }

    @Test
    public void testAddRow() throws Exception {
        System.out.print("Add row");
        GridQuestionBean gridQuestionBean = createBean();
        gridQuestionBean.addRow("newTestRow");
        Assert.assertArrayEquals(mkReport(gridQuestionBean), gridQuestionBean.getSelected(), new boolean[4][3]);
        outReportOK(mkReport(gridQuestionBean));
    }

    @Test
    public void testAddCol() throws Exception {
        System.out.print("Add col");
        GridQuestionBean gridQuestionBean = createBean();
        gridQuestionBean.addCol("newTestCol");
        Assert.assertArrayEquals(mkReport(gridQuestionBean), gridQuestionBean.getSelected(), new boolean[3][4]);
        outReportOK(mkReport(gridQuestionBean));
    }

    @Test
    public void testUnselectRow() throws Exception {
        System.out.print("Unselect row");
        GridQuestionBean gridQuestionBean = createBean();
        selectAll(gridQuestionBean);
        gridQuestionBean.unselectRow(1);
        for (boolean b : gridQuestionBean.getSelected()[1]) {
            Assert.assertTrue(mkSelectedReport(gridQuestionBean), !b);
        }
        outReportOK(mkSelectedReport(gridQuestionBean));
    }

    @Test
    public void testUnselectCol() throws Exception {
        System.out.print("Unselect col");
        GridQuestionBean gridQuestionBean = createBean();
        selectAll(gridQuestionBean);
        gridQuestionBean.unselectCol(1);
        for (boolean[] b : gridQuestionBean.getSelected()) {
            Assert.assertTrue(mkSelectedReport(gridQuestionBean), !b[1]);
        }
        outReportOK(mkSelectedReport(gridQuestionBean));
    }
}
