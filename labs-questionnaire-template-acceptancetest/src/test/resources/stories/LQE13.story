Narrative:
As a template author I want to add "Range"
questions to question groups so that
the template meets my needs.

GivenStories: base_stories/openDefaultPage.story
Scenario: create and fill
Meta: @testName         LQE-13
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionType     RANGE
      @questionText     Question text LQE-13
      @helpText         Help text LQE-13
GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/addQuestion.story,
              base_stories/question/fillCommonPropertiesInQuestion.story
When the user fills 'form2:minRangeValue' field with '1'
When the user fills 'form2:maxRangeValue' field with '7'


Scenario: save and check

Meta: @testName         LQE-13
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionName     Question 1
      @questionText     Question text LQE-13
      @helpText         Help text LQE-13
GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then element 'form2:minRangeValue' has attribute value '1'
Then element 'form2:maxRangeValue' has attribute value '7'


Scenario: edit
Meta: @questionText     Question text LQE-13 edit
      @helpText         Help text LQE-13 edit
GivenStories: base_stories/question/fillCommonPropertiesInQuestion.story
When the user fills 'form2:minRangeValue' field with '2'
When the user fills 'form2:maxRangeValue' field with '6'


Scenario: check and save
Meta: @testName         LQE-13
      @sectionName      Page 1
      @groupName        GROUP_1
      @questionName     Question 1
      @questionText     Question text LQE-13 edit
      @helpText         Help text LQE-13 edit

GivenStories: base_stories/question/saveQuestion.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findQuestionInTree.story,
              base_stories/template/tree/clickEditQuestion.story,
              base_stories/question/checkSavedCommonPropertiesInQuestion.story
Then element 'form2:minRangeValue' has attribute value '2'
Then element 'form2:maxRangeValue' has attribute value '6'
