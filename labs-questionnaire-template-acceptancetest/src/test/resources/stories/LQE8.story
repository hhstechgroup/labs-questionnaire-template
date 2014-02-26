Narrative:
In order to have an ability to edit template 
As a template author
I want to add "Text" questions to question groups (LQE-8)

					 
Scenario:

User can add questions on the
template creation/editing form.
When the user opens the default page
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-8 test'
When clicks on element with id/name/className 'formTemplate:form:addSection'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Page 1'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:form:btnDisplayEdit'
Then wait until all animations on page completed
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'GROUP_1'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:form:btnDisplayEdit'
Then should open page with 'Question Editor' title

Scenario:
User can select "Text" in the Question Type drop-down list

When clicks on element with id/name/className 'form:selectOneMenu'
Then wait until all animations on page completed
When choose 'TEXT' from drop-down
Then wait until all animations on page completed

Scenario:
User can enter some text for the question in the Question Text field.
When the user fills 'questionForm:form3:formWithCommonProps:common' field with 'Test text'
Then wait until all animations on page completed

Scenario:
User can save the template with added questions.