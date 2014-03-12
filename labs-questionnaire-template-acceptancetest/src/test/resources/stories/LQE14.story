Narrative:
In order to have an ability to edit template 
As a template author
I want to add “Grid" questions to question groups
	
	
GivenStories: base_stories/openDefaultPage.story			 
Scenario: 
User can add questions on the template creation/editing form.
User can select "Grid" in the Question Type drop-down list.
User can enter some text for the question in the Question Text field.
Meta: @testName         LQE-14
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionType     GRID
      @questionText     Question text LQE-14
      @helpText         Help text LQE-14
GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/addQuestion.story,
              base_stories/question/fillCommonPropertiesInQuestion.story
              
When the checkbox id/name/className 'form2:formWithCommonProps:required' is unchecked make it checked

Scenario:
User can define row and column names for the grid..


Scenario:
User can save the template with added questions.
Meta: @testName         LQE-14
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionName     Question 1
      @questionText     Question text LQE-14
      @helpText         Help text LQE-14
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then the checkbox id/name/className 'form2:formWithCommonProps:required' is checked

Scenario:
User can edit question.
Meta: @questionText     Question text LQE-14 edit
      @helpText         Help text LQE-14 edit
GivenStories: base_stories/question/fillCommonPropertiesInQuestion.story
When the checkbox id/name/className 'form2:formWithCommonProps:required' is unchecked make it checked

Scenario: 
check edited and save
Meta: @testName         LQE-14
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionName     Question 1
      @questionText     Question text LQE-14 edit
      @helpText         Help text LQE-14 edit
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then the checkbox id/name/className 'form2:formWithCommonProps:required' is unchecked
