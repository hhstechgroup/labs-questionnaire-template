Narrative:
As a template author I want to remove questions
from question groups so that the template meets
my needs.

GivenStories: base_stories/openDefaultPage.story
Scenario: create section, group and text question
Meta: @testName         LQE-18
      @sectionName      Page 1
      @groupName        Group 1
      @questionType     TEXT
      @questionText     Question text LQE-18
      @helpText         Help text LQE-18

GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/addQuestion.story,
              base_stories/question/fillCommonPropertiesInQuestion.story
Then wait until all animations on page completed

Scenario: save and find question in tree
Meta: @testName         LQE-18
      @sectionName      Page 1
      @groupName        Group 1
      @questionName     Question ...
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '3' elements per page

Scenario: delete question, save and verify it has been deleted
Meta: @testName         LQE-18
      @sectionName      Page 1
      @groupName        Group 1
      @questionName     Question ...
GivenStories: base_stories/template/tree/clickDeleteQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findGroupInTree.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page

