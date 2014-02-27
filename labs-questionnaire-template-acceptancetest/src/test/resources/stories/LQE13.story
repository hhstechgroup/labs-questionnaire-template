As a template author I want to add “Range"
questions to question groups so that the
template meets my needs.
Scenario:
Narrative:
User can add questions on the
template creation/editing form.
When the user opens the default page
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-13 test'
When clicks on element with id/name/className 'formTemplate:form:addSection'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '1' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Page 1'
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:form:btnDisplayEdit'
Then wait until all animations on page completed
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'GROUP_1'
When clicks on element with id/name/className 'formTemplate:form:btnDisplayEdit'
Then wait until all animations on page completed
Scenario:
Narrative:
User can select "Range" in the Question
Type drop-down list.

When clicks on element with id/name/className 'form:selectOneMenu_label'
Then wait until all animations on page completed
When choose 'RANGE' from drop-down
Then wait until all animations on page completed
Scenario:
Narrative:
User can enter some text for the question
in the Question Text field

When the user fills 'questionForm:form2:range:qtext' field with 'Test text'
Then wait until all animations on page completed
When the user fills 'questionForm:form2:range:helpText' field with 'Test text'


Scenario:
Narrative:
User can define min
and max values for the range.
When the user fills 'questionForm:form2:minRangeValue' field with '1'
When the user fills 'questionForm:form2:maxRangeValue' field with '7'

Scenario:
Narrative:
User can save the
template with added
questions.
When the user clicks on element with id/name/className 'buttons:savequestion'
Then wait until all animations on page completed
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
When in tree 'formTemplate:form:treeMultiple' user opens node with 'GROUP_1'
Then wait until all animations on page completed