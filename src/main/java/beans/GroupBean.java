package beans;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 1/28/14
 * Time: 12:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class GroupBean {
    private String groupName;

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

    private List<QuestionBean> questionsList;
}
