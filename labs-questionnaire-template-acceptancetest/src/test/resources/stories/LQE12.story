Narrative:
As a template author I want to add “Choose
from a list" questions to question groups so that
the template meets my needs.

Scenario:
Narrative:
User can add questions on the
template creation/editing form.
When the user opens the default page
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-12 test'
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

When clicks on element with id/name/className 'form:selectOneMenu'
Then wait until all animations on page completed
When choose 'CHOOSEFROMLIST' from drop-down
Then wait until all animations on page completed
When the user fills 'questionForm:form3:formWithCommonProps:common' field with 'Test text'
Then wait until all animations on page completed
