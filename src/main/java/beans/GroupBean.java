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
public class GroupBean implements Cloneable {
    private String groupName;
    private List<QuestionBean> questionsList;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<QuestionBean> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<QuestionBean> questionsList) {
        this.questionsList = questionsList;
    }

    @Override
    protected GroupBean clone() throws CloneNotSupportedException {
        GroupBean copy = (GroupBean) super.clone();
        copy.setGroupName(this.groupName);
        List<QuestionBean> copyQuestionsList = new ArrayList<QuestionBean>();
        for (QuestionBean questionBean : questionsList) {
            copyQuestionsList.add((QuestionBean) questionBean.clone());
        }
        copy.setQuestionsList(copyQuestionsList);
        return copy;
    }
}
