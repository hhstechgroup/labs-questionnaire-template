Narrative:
As a template author I want to add "Date" questions to question groups so that
the template meets my needs.

GivenStories: base_stories/openDefaultPage.story
Scenario: create and fill
Meta: @testName         LQE-16
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionType     DATE
      @questionText     Question text LQE-16
      @helpText         Help text LQE-16

GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/addQuestion.story,
              base_stories/question/fillCommonPropertiesInQuestion.story
When the user fills 'form2:calendar_input' field with '02/11/2014'


Scenario: save and check

Meta: @testName         LQE-16
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionName     Question 1
      @questionText     Question text LQE-16
      @helpText         Help text LQE-16
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then element 'form2:calendar_input' has attribute value '02/11/2014'

Scenario: edit
Meta: @questionText     Question text LQE-16 edit
      @helpText         Help text LQE-16 edit
GivenStories: base_stories/question/fillCommonPropertiesInQuestion.story
When the user fills 'form2:calendar_input' field with '08/12/2013'



Scenario: check and save
Meta: @testName         LQE-16
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionName     Question 1
      @questionText     Question text LQE-16 edit
      @helpText         Help text LQE-16 edit

GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then element 'form2:calendar_input' has attribute value '08/12/2013'
