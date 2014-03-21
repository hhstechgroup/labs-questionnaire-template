Narrative:
As a template author I want to add "FileUpload" questions to question groups so that
the template meets my needs.

GivenStories: base_stories/openDefaultPage.story
Scenario: create and fill
Meta: @testName         LQE-17
      @sectionName      Page 1
      @groupName        Group 1
      @questionType     FILEUPLOAD
      @questionText     Question text LQE-17
      @helpText         Help text LQE-17

GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/addQuestion.story,
              base_stories/question/fillCommonPropertiesInQuestion.story
Then wait until all animations on page completed


Scenario: save and check

Meta: @testName         LQE-17
      @sectionName      Page 1
      @groupName        Group 1
      @questionName     Question ...
      @questionText     Question text LQE-17
      @helpText         Help text LQE-17
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then wait until all animations on page completed

Scenario: edit
Meta: @questionText     Question text LQE-17 edit
      @helpText         Help text LQE-17 edit
GivenStories: base_stories/question/fillCommonPropertiesInQuestion.story
Then wait until all animations on page completed



Scenario: check and save
Meta: @testName         LQE-17
      @sectionName      Page 1
      @groupName        Group 1
      @questionName     Question ...
      @questionText     Question text LQE-17 edit
      @helpText         Help text LQE-17 edit

GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then wait until all animations on page completed
