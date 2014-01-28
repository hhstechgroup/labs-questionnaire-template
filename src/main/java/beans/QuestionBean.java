package beans;

/**
 * Created with IntelliJ IDEA.
 * User: anton.kovunov
 * Date: 1/28/14
 * Time: 12:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuestionBean implements Cloneable {
    private Long id;
    private String questionTitle;
    private boolean requiredAnswer;
    private QuestionType questionType;


    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRequiredAnswer() {
        return requiredAnswer;
    }

    public void setRequiredAnswer(boolean requiredAnswer) {
        this.requiredAnswer = requiredAnswer;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        QuestionBean copy = (QuestionBean) super.clone();
        copy.setQuestionType(this.questionType);
        return copy;
    }
}
