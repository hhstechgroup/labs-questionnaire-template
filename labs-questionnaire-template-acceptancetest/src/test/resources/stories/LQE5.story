Narrative:
As a template author I want to remove sections
from questionnaire templates so that the forms
meet my needs.

GivenStories: base_stories/openDefaultPage.story
Scenario: Create new template, add 2 sections and delete 1 section
Meta: @testName         LQE-5 test
      @sectionName      Page 1
GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/deleteSection.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page

Scenario: Create new template, add 2 sections and delete 1 section
Meta: @testName         LQE-5 test
      @sectionName      Page 2
GivenStories: base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/findSectionInTree.story,
              base_stories/template/tree/deleteSection.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '0' elements per page


