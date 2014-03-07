package com.engagepoint.controller.question;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.engagepoint.controller.page.QuestionEditController;
import com.engagepoint.controller.page.TemplateEditController;
import com.engagepoint.model.question.Question;
import com.engagepoint.model.question.options.GridQuestionBean;
import com.engagepoint.model.question.utils.VariantItem;
import com.engagepoint.model.table.ListOfOptionsDataModel;

@Named
@ConversationScoped
public class GridQuestionController extends QuestionEditController {

	private GridQuestionBean currentQuestion;

    //I was forced to write this
    double penetration;

	// dataModel for table
	private ListOfOptionsDataModel dataModel;
	// dataModel for second table
	private ListOfOptionsDataModel dataModel2;

	@Inject
	private TemplateEditController templateEditController;

	@Inject
	private Conversation conversation;

	@PostConstruct
	public void postConstruct() {
		beginConversation();
		Question question = getTemplateTreeController()
				.getCurrentQuestion();
		if (question == null) {
			setNew(true);
			currentQuestion = new GridQuestionBean();
			currentQuestion.setQuestionType(templateEditController
					.getSelectedQuestionType());
			dataModel = new ListOfOptionsDataModel();
			dataModel2 = new ListOfOptionsDataModel();
		} else {
			currentQuestion = (GridQuestionBean) question;
			dataModel = new ListOfOptionsDataModel(currentQuestion.getOptions());
			dataModel2 = new ListOfOptionsDataModel(
					currentQuestion.getOptions2());
		}
	}

	public void beginConversation() {
		if (conversation.isTransient()) {
			conversation.begin();
		}
	}

	public void endConversation() {
		if (!conversation.isTransient()) {
			conversation.end();
		}
	}

	public ListOfOptionsDataModel getDataModel2() {
		return dataModel2;
	}

	public void setDataModel2(ListOfOptionsDataModel dataModel2) {
		this.dataModel2 = dataModel2;
	}

	public GridQuestionBean getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(GridQuestionBean currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public ListOfOptionsDataModel getDataModel() {
		return dataModel;
	}

	public void setDataModel(ListOfOptionsDataModel dataModel) {
		this.dataModel = dataModel;
	}

	/**
	 * Update options in ListOfOptionsDataModel.
	 */
	private void updateModel() {
		getDataModel().setWrappedData(getCurrentQuestion().getOptions());
	}

	/**
	 * Update options2 in ListOfOptionsDataModel.
	 */
	private void updateModel2() {
		getDataModel2().setWrappedData(getCurrentQuestion().getOptions2());
	}

	/**
	 * Add variant to a question.
	 * 
	 * @param option
	 *            VariantItem object
	 */
	public void addOption(String option) {
		getCurrentQuestion().getOptions().add(new VariantItem("New"));
		updateModel();
	}

	/**
	 * Add variant to a question for second table.
	 * 
	 * @param option
	 *            VariantItem object
	 */
	public void addOption2(String option) {
		getCurrentQuestion().getOptions2().add(new VariantItem("New"));
		updateModel2();
	}

	/**
	 * Remove variant from a question.
	 * 
	 * @param option
	 *            VariantItem object
	 */
	public void removeOption(VariantItem option) {
		getCurrentQuestion().getOptions().remove(option);
		updateModel();
	}

	/**
	 * Remove variant from a question.
	 * 
	 * @param option
	 *            VariantItem object
	 */
	public void removeOption2(VariantItem option) {
		getCurrentQuestion().getOptions2().remove(option);
		updateModel2();
	}

	@Override
	public String actionSave() {
		try {
			currentQuestion.setOptions((ArrayList<VariantItem>) dataModel.getWrappedData());
			currentQuestion.setOptions2((ArrayList<VariantItem>) dataModel2.getWrappedData());
		} catch (ClassCastException e) {
			// TODO
		}
		getTemplateTreeController().setCurrentQuestion(currentQuestion);
		endConversation();
		return super.actionSave();
	}

	@Override
	public String actionCancel() {
		endConversation();
		return super.actionCancel();
	}

}
