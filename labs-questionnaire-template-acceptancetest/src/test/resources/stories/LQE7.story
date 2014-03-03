Narrative:
As a template author I want to remove question
groups from questionnaire templates so that they
meet my needs.

Scenario:
User can delete the group of questions on the
template creation form.
When the user opens the default page
Then wait for element 'form1:AddTemplate' is visible
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-7 test'
When clicks on element with id/name/className 'formTemplate:form:addSection'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Page 1'
Then wait for element 'formTemplate:form:btnDisplayAddGroup' is visible
When clicks on element with id/name/className 'formTemplate:form:btnDisplayAddGroup'
Then wait until all animations on page completed
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Page 1'
Then wait for element 'formTemplate:form:btnDisplayAddGroup' is visible
When clicks on element with id/name/className 'formTemplate:form:btnDisplayAddGroup'
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '3' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'GROUP_1'
Then wait for element 'formTemplate:form:btnDisplayDelete' is visible
When clicks on element with id/name/className 'formTemplate:form:btnDisplayDelete'
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title

Scenario:
Removed on creation form group is not
displayed in the template.
When in table 'form1:table' user presses 'Edit' in row with 'LQE-7 test'
Then should open page with 'Template Editor' title
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page

Scenario:
User can delete the group of questions on the
template editing form.
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'GROUP_2'
Then wait for element 'formTemplate:form:btnDisplayDelete' is visible
When clicks on element with id/name/className 'formTemplate:form:btnDisplayDelete'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title

Scenario:
Removed on editing form group is not
displayed in the template.
When in table 'form1:table' user presses 'Edit' in row with 'LQE-7 test'
Then should open page with 'Template Editor' title
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page



