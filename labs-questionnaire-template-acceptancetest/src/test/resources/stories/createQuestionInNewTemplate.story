GivenStories: stories/createGroupInNewTemplate.story
Scenario:
Create question in new group of new section of new template
When clicks on element with id/name/className 'formTemplate:form:btnDisplayAddQuestion'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:form:selectOneMenu_label'
Then wait until all animations on page completed