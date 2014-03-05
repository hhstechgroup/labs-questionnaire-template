Narrative:
As a template author I want to create new
questionnaire templates so that I can use them.

GivenStories: base_stories/openDefaultPage.story
Scenario:
Create and save template.
Meta: @testName         LQE-2 test
GivenStories: base_stories/template/createAndStartEditTemplateForStory.story,
              base_stories/template/saveTemplate.story
Then in table 'form1:table' there is a row with 'LQE-2 test'


Scenario:
Create and cancel saving template.
Meta: @testName         LQE-2 test cancel
GivenStories: base_stories/template/createAndStartEditTemplateForStory.story,
              base_stories/template/cancelSavingTemplate.story
Then in table 'form1:table' there is not a row with 'LQE-2 test cancel'



