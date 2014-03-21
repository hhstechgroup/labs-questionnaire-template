Narrative:
As a template author I want to add "Time" questions to question groups so that
the template meets my needs.

GivenStories: base_stories/openDefaultPage.story
Scenario: create and fill
Meta: @testName         LQE-15
      @sectionName      Page 1
      @groupName        Group 1
      @questionType     TIME
      @questionText     Question text LQE-15
      @helpText         Help text LQE-15

GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/addQuestion.story,
              base_stories/question/fillCommonPropertiesInQuestion.story
When the user fills 'form2:calendar_input' field with '07:00'


Scenario: save and check

Meta: @testName         LQE-15
      @sectionName      Page 1
      @groupName        Group 1
      @questionName     Question ...
      @questionText     Question text LQE-15
      @helpText         Help text LQE-15
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then element 'form2:calendar_input' has attribute value '07:00'

Scenario: edit
Meta: @questionText     Question text LQE-15 edit
      @helpText         Help text LQE-15 edit
GivenStories: base_stories/question/fillCommonPropertiesInQuestion.story
When the user fills 'form2:calendar_input' field with '08:30'



Scenario: check and save
Meta: @testName         LQE-15
      @sectionName      Page 1
      @groupName        Group 1
      @questionName     Question ...
      @questionText     Question text LQE-15 edit
      @helpText         Help text LQE-15 edit

GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then element 'form2:calendar_input' has attribute value '08:30'
