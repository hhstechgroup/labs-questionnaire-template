Narrative:
In order to have an ability to edit template 
As a template author
I want to add new sections to questionnaire templates (LQE-4)
GivenStories: stories\create_jbehave_stories\write_stories\editpage.story
Scenario:
When the user clicks button with title 'Add section'
Then wait for element 'formTemplate:form:treeMultiple:3:treeNode' is visible
