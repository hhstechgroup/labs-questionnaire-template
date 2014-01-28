package beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 1/28/14
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class SectionBean implements Cloneable {
    private int pageNumber;
    private List<GroupBean> groupsList;

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

    @Override
    protected Object clone() throws CloneNotSupportedException {
        SectionBean copy = (SectionBean) super.clone();
        copy.setPageNumber(this.pageNumber);
        List<GroupBean> copyGroupsList = new ArrayList<GroupBean>();
        for (GroupBean groupBean : copyGroupsList) {
            copyGroupsList.add((GroupBean) groupBean.clone());
        }
        copy.setGroupsList(copyGroupsList);
        return copy;
    }

}
