Narrative:
As a template author I want to remove question
groups from questionnaire templates so that they
meet my needs.

GivenStories: base_stories/openDefaultPage.story
Scenario: Create new template, add section, add 2 groups and delete 1 group
Meta: @testName         LQE-7 test
      @sectionName      Page 1
      @groupName        GROUP_1
GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/deleteGroup.story,
              base_stories/template/tree/findSectionInTree.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page

Scenario: Save template and delete 1 section
Meta: @testName         LQE-7 test
      @sectionName      Page 1
      @groupName        GROUP_2
GivenStories: base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/tree/deleteGroup.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findSectionInTree.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page




