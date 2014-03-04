As a template author I want to specify default
answers to questions so that they can be suggested when running
questionnaires based on templates.

Scenario:
Add new template
When the user opens the default page
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-21 test'
When clicks on element with id/name/className 'formTemplate:form:addSection'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Page 1'
Then wait for element 'formTemplate:form:btnDisplayAddGroup' is visible
When clicks on element with id/name/className 'formTemplate:form:btnDisplayAddGroup'
Then wait until all animations on page completed
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'GROUP_1'
Then wait for element 'formTemplate:form:btnDisplayAddQuestion' is visible
When clicks on element with id/name/className 'formTemplate:form:btnDisplayAddQuestion'
Then wait until all animations on page completed

Scenario:
Add question with default answer


