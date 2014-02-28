Narrative:

As a template author I want to add "Paragraph
Text" questions to question groups so that
the template meets my needs.

Scenario:
User can add questions on the
template creation/editing form.
User can enter some text for the
question in the Question Text
field.
User can select "Paragraph Text"
in the Question Type drop-down list.
When the user opens the default page
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-9 test'
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
When choose 'PARAGRAPHTEXT' from drop-down
Then wait for element 'questionForm:form4:formWithCommonProps:qtext' is visible
When the user fills 'questionForm:form4:formWithCommonProps:qtext' field with 'Test text'
Then wait until all animations on page completed
When clicks on element with id/name/className 'buttons:savequestion'
Then should open page with 'Template Editor' title

When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When in tree 'formTemplate:form:treeMultiple' user opens node with 'GROUP_1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '3' elements per page


Scenario:
User can define options for multiple
choice.
User can save the template with added
questions.

