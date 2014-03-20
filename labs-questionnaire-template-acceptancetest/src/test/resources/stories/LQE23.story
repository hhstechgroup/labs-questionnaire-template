Narrative:
As a template author I want to clone questionnai
re templates so that I can quickly create new forms
based on the existing ones.

GivenStories: base_stories/openDefaultPage.story
Scenario: Create and save template.
Meta: @testName         LQE-23 test
      @sectionName      Page 1
      @groupName        Group 1
      @questionType     TEXT
      @questionText     Question text LQE-23
      @helpText         Help text LQE-23
GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/addQuestion.story,
              base_stories/question/fillCommonPropertiesInQuestion.story,
              base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/cloneTemplate.story,
              base_stories/template/deleteTemplate.story
Then in table 'form1:table' there is a row with 'LQE-23 test - clone'


Scenario: Clone and check content.
Meta: @testName         LQE-23 test - clone
      @sectionName      Page 1
      @groupName        Group 1
      @questionType     TEXT
      @questionName     Question ...
      @questionText     Question text LQE-23
      @helpText         Help text LQE-23
GivenStories: base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then wait until all animations on page completed



