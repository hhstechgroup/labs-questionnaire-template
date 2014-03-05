Narrative:
As a template author I want to add new question
groups to questionnaire templates so that the
forms meet my needs.

GivenStories: base_stories/openDefaultPage.story
Scenario: Create new template, add section, add group and save template
Meta: @testName         LQE-6 test
      @sectionName      Page 1
      @groupName        GROUP_1
GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findGroupInTree.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page

Scenario: Add group in existing template and save
Meta: @testName         LQE-6 test
      @sectionName      Page 1
      @groupName        GROUP_2
GivenStories: base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/tree/findGroupInTree.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findGroupInTree.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '3' elements per page

Scenario: Add group and cancel saving template
Meta: @testName         LQE-6 test
      @sectionName      Page 1
      @groupName        GROUP_2
GivenStories: base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/addGroup.story,
              base_stories/template/cancelSavingTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findGroupInTree.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '3' elements per page



