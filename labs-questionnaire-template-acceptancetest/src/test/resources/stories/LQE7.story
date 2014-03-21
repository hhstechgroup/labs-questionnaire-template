Narrative:
As a template author I want to remove question
groups from questionnaire templates so that they
meet my needs.

GivenStories: base_stories/openDefaultPage.story
Scenario: Create new template, add section, add 2 groups
Meta: @testName         LQE-7 test
      @sectionName      Page 1
      @groupName        Group 1
GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story
Then wait until all animations on page completed

Scenario: Delete second group
Meta: @testName         LQE-7 test
      @sectionName      Page 1
      @groupName        Group 2
GivenStories: base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/deleteGroup.story,
              base_stories/template/tree/findSectionInTree.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page

Scenario: Save template and verify that there is only first group
Meta: @testName         LQE-7 test
      @sectionName      Page 1
      @groupName        Group 1
GivenStories: base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findSectionInTree.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page




