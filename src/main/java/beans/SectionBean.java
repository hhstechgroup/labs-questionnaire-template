package beans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 1/28/14
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class SectionBean {
    private int pageNumber;

    public List<GroupBean> getGroupsList() {
        return groupsList;
    }

    public void setGroupsList(List<GroupBean> groupsList) {
        this.groupsList = groupsList;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    private List<GroupBean> groupsList;
}
