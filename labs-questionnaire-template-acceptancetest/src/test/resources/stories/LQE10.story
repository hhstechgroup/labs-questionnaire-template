Narrative:
As a template author I want to add "Multiple
Choice" questions to question groups so that
the template meets my needs.

GivenStories: base_stories/openDefaultPage.story
Scenario: create and fill
Meta: @testName         LQE-10
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionType     MULTIPLECHOICE
      @questionText     Question text LQE-10
      @helpText         Help text LQE-10
      @optionName       Test option 1

GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/addQuestion.story,
              base_stories/question/fillCommonPropertiesInQuestion.story,
              base_stories/question/addoption.story
When the checkbox id/name/className 'form2:formWithCommonProps:required' is unchecked make it checked


Scenario: save and check
Meta: @testName         LQE-10
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionName     Question 1
      @questionText     Question text LQE-10
      @helpText         Help text LQE-10
      @optionName       Test option 1
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story,
              base_stories/question/checkOptions.story
Then the checkbox id/name/className 'form2:formWithCommonProps:required' is checked


Scenario: edit
Meta: @questionText     Question text LQE-10 edit
      @helpText         Help text LQE-10 edit
      @optionName       Test option 2
GivenStories: base_stories/question/fillCommonPropertiesInQuestion.story,
              base_stories/question/addoption.story
When the checkbox id/name/className 'form2:formWithCommonProps:required' is unchecked make it checked


Scenario: check and save
Meta: @testName         LQE-10
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionName     Question 1
      @questionText     Question text LQE-10 edit
      @helpText         Help text LQE-10 edit
      @optionName       Test option 2
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story,
              base_stories/question/checkOptions.story
Then the checkbox id/name/className 'form2:formWithCommonProps:required' is unchecked



