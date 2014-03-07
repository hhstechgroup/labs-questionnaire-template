Narrative:
As a template author I want to add
"Checkboxes" questions to question groups so
that the template meets my needs.


GivenStories: base_stories/openDefaultPage.story
Scenario: create and fill
Meta: @testName         LQE-11
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionType     CHECKBOX
      @questionText     Question text LQE-11
      @helpText         Help text LQE-11
      @optionName       Test option 1

GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/addQuestion.story,
              base_stories/question/fillCommonPropertiesInQuestion.story,
              base_stories/question/addoption.story
Then wait until all animations on page completed

Scenario: add one more option
Meta: @optionName       Test option 2
GivenStories: base_stories/question/addOption.story
Then wait until all animations on page completed

Scenario: delete first option
Meta: @optionName       Test option 1
GivenStories: base_stories/question/deleteOption.story
Then wait until all animations on page completed

Scenario: save and check
Meta: @testName         LQE-11
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionName     Question 1
      @questionText     Question text LQE-11
      @helpText         Help text LQE-11
      @optionName       Test option 3
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story,
              base_stories/question/checkOptions.story
Then wait until all animations on page completed


Scenario: edit
Meta: @questionText     Question text LQE-11 edit
      @helpText         Help text LQE-11 edit
      @optionName       Test option 3
GivenStories: base_stories/question/fillCommonPropertiesInQuestion.story,
              base_stories/question/addoption.story
Then wait until all animations on page completed


Scenario: check and save
Meta: @testName         LQE-11
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionName     Question 1
      @questionText     Question text LQE-11 edit
      @helpText         Help text LQE-11 edit
      @optionName       Test option 3
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story,
              base_stories/question/checkOptions.story
Then wait until all animations on page completed


