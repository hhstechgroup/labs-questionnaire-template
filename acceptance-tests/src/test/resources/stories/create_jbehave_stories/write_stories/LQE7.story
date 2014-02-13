Narrative:
In order to have an ability to edit template 
As a template author
I want to remove question groups from questionnair
       e templates so that they meet my needs (LQE-7)

Scenario:
Given user is on Home page
Then wait for '2' sec
Then the user clicks  button with id 'form1:table:1:btnEdit'
Then wait for '2' sec
When opens tree with className 'ui-icon-triangle-1-e'
Then wait for '2' sec
Then the user clicks element with id 'formTemplate:form:treeMultiple:0_0:treeNode'
Then wait for '2' sec
Then the user clicks  button with id 'formTemplate:form:btnDisplayDelete'
Then wait for '2' sec