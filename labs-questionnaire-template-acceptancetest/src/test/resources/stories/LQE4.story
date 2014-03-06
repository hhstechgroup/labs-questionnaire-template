Narrative:
In order to have an ability to edit template 
As a template author I want to
add new sections to questionnaire templates (LQE-4)

GivenStories: base_stories/openDefaultPage.story
Scenario: Create new template, add section and save template
Meta: @testName         LQE-4 test save
GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page

Scenario: Add section to existing template
When clicks on element with id/name/className 'formTemplate:form:addSection'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page

Scenario: Save and check if section is added
Meta: @testName         LQE-4 test save
GivenStories: base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title

Scenario: Create new template, save it. Then add section and cancel saving of template.
Meta: @testName         LQE-4 test cancel
GivenStories: base_stories/template/addTemplate.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story,
              base_stories/template/tree/addSection.story,
              base_stories/template/cancelSavingTemplate.story,
              base_stories/template/editTemplate.story
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '0' elements per page



