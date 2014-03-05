Narrative:
In order to have an ability to edit template 
As a template author
I want to edit questionnaire templates

GivenStories: base_stories/openDefaultPage.story
Scenario: Creating new template
Meta: @testName         LQE-3 test
GivenStories: base_stories/template/createAndStartEditTemplateForStory.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story
Then wait until all animations on page completed

Scenario: Find template and open edit page
Meta: @testName         LQE-3 test edited
GivenStories: base_stories/template/fillNameInTemplate.story,
              base_stories/template/saveTemplate.story,
              base_stories/template/editTemplate.story
Then element 'formTemplate:name' has attribute value 'LQE-3 test edited'



