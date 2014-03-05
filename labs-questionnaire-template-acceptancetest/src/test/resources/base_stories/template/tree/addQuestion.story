Scenario:
Create question in group
Given question type
When clicks on element with id/name/className 'formTemplate:form:btnDisplayAddQuestion'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:form:selectOneMenu_label'
Then wait until all animations on page completed
When choose question type from drop-down
Then wait for element 'formTemplate:form:create' is visible
When clicks on element with id/name/className 'formTemplate:form:create'
Then should open page with 'Question Editor' title