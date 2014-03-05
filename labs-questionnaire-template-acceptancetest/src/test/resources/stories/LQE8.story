Narrative:
In order to have an ability to edit template 
As a template author I want to add "Text" questions to question groups (LQE-8)

GivenStories: base_stories/openDefaultPage.story
Scenario: create and fill
Meta: @testName         LQE-8
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionType     TEXT
      @questionText     Question text LQE-8
      @helpText         Help text LQE-8
GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/addQuestion.story,
              base_stories/question/fillCommonPropertiesInQuestion.story
When the checkbox id/name/className 'form2:formWithCommonProps:required' is unchecked make it checked
When the user fills 'form2:defaultAnswer' field with 'Default answer LQE-8'


Scenario: save and check
Meta: @sectionName      Page 1
      @groupName        GROUP_1
      @questionName     Question 1
      @questionText     Question text LQE-8
      @helpText         Help text LQE-8
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then the checkbox id/name/className 'form2:formWithCommonProps:required' is checked
Then element 'form2:defaultAnswer' has attribute value 'Default answer LQE-8'


Scenario: edit
Meta: @questionText     Question text LQE-8 edit
      @helpText         Help text LQE-8 edit
GivenStories: base_stories/question/fillCommonPropertiesInQuestion.story
When the checkbox id/name/className 'form2:formWithCommonProps:required' is unchecked make it checked
When the user fills 'form2:defaultAnswer' field with 'Default answer LQE-8 edit'


Scenario: check and save
Meta: @sectionName      Page 1
      @groupName        GROUP_1
      @questionName     Question 1
      @questionText     Question text LQE-8 edit
      @helpText         Help text LQE-8 edit
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then the checkbox id/name/className 'form2:formWithCommonProps:required' is unchecked
Then element 'form2:defaultAnswer' has attribute value 'Default answer LQE-8 edit'
