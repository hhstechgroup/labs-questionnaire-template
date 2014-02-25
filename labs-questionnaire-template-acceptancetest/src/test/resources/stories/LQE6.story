Narrative:
As a template author I want to add new question
groups to questionnaire templates so that the
forms meet my needs.

Scenario:
Narrative:
User can add a new group of fields on the
template creation form.
User can save the template with the
added group.
When the user opens the default page
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-6 test'
When clicks on element with id/name/className 'formTemplate:form:addSection'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Page 1'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:form:btnDisplayEdit'
Then wait until all animations on page completed
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title
When in table 'form1:table' user presses 'Edit' in row with 'LQE-6 test'
Then should open page with 'Template Editor' title
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page

Scenario:
Narrative:
User can add a new group of fields on the
template editing form.
User can save the template with the
added group.
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Page 1'
When clicks on element with id/name/className 'formTemplate:form:btnDisplayEdit'
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '3' elements per page
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title
When in table 'form1:table' user presses 'Edit' in row with 'LQE-6 test'
Then should open page with 'Template Editor' title
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '3' elements per page

Scenario:
Narrative:
User can enter some alphanumeric text for
the group name.

Scenario:
Narrative:
Adding new group to template and canceling
When clicks on element with id/name/className 'formTemplate:form:btnDisplayEdit'
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '4' elements per page
When clicks on element with id/name/className 'formTemplate:cancel'
When clicks on element with id/name/className 'formTemplate:yes'
Then should open page with 'Questionnaire Editor' title
When in table 'form1:table' user presses 'Edit' in row with 'LQE-6 test'
Then should open page with 'Template Editor' title
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '3' elements per page



