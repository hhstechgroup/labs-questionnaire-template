Narrative:
In order to have an ability to edit template 
As a template author
I want to add “Grid" questions to question groups
	
	
GivenStories: stories/createQuestionInNewTemplate.story				 
Scenario: 
User can add questions on the template creation/editing form.
User can select "Grid" in the Question Type drop-down list.
User can enter some text for the question in the Question Text field.
Meta: @testName         LQE-14
      @questionType     GRID
      @questionText     Question text LQE-14
      @helpText         Help text LQE-14
GivenStories: base_stories/template/tree/createQuestionInNewTemplate.story,
              base_stories/question/fillCommonPropertiesInQuestion.story
When the checkbox id/name/className 'form2:formWithCommonProps:required' is unchecked make it checked

Scenario:
User can define row and column names for the grid..


Scenario:
User can save the template with added questions.
Meta: @questionText     Question text LQE-14
      @helpText         Help text LQE-14
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then the checkbox id/name/className 'form2:formWithCommonProps:required' is checked

Scenario:
User can edit question.
Meta: @questionText     Question text LQE-14 edit
      @helpText         Help text LQE-14 edit
GivenStories: base_stories/question/fillCommonPropertiesInQuestion.story

When clicks on element with id/name/className 'formTemplate:form:btnDisplayEditQuestion'
Then should open page with 'Question Editor' title
Then element 'form2:formWithCommonProps:qtext' has attribute value 'Test text LQE-8'
Then element 'form2:formWithCommonProps:helpText' has attribute value 'Help text LQE-8'
When the user fills 'form2:formWithCommonProps:qtext' field with 'Test text LQE-8 edit'
Then element 'form2:formWithCommonProps:qtext' has attribute value 'Test text LQE-8 edit'
When the user fills 'form2:formWithCommonProps:helpText' field with 'Help text LQE-8 edit'
Then element 'form2:formWithCommonProps:helpText' has attribute value 'Help text LQE-8 edit'

When clicks on element with id/name/className 'form2:formWithSaveButtons:savequestion'

Then should open page with 'Template Editor' title
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Question 1'
Then wait for element 'formTemplate:form:btnDisplayEditQuestion' is visible

When clicks on element with id/name/className 'formTemplate:form:btnDisplayEditQuestion'
Then should open page with 'Question Editor' title
Then element 'form2:formWithCommonProps:qtext' has attribute value 'Test text LQE-8 edit'
Then element 'form2:formWithCommonProps:helpText' has attribute value 'Help text LQE-8 edit'
Then the checkbox id/name/className 'form2:formWithCommonProps:required' is unchecked