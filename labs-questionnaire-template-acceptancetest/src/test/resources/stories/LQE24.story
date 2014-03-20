Narrative:
As a template author I want to clone questionnai
re templates so that I can quickly create new forms
based on the existing ones.

GivenStories: base_stories/openDefaultPage.story
Scenario: Create and save template.
Meta: @testName         LQE-24 test
      @sectionName      Page 1
      @groupName        Group 1
      @questionType     TEXT
      @questionText     Question text LQE-24
      @helpText         Help text LQE-24
GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/addQuestion.story,
              base_stories/question/fillCommonPropertiesInQuestion.story,
              base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/deleteTemplate.story
Then in table 'form1:table' there is not a row with 'LQE-24 test'