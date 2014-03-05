Narrative:
In order to have an ability to edit template 
As a template author
I want to add "Text" questions to question groups (LQE-8)

GivenStories: stories/createQuestionInNewTemplate.story
Scenario:
User can add questions on the
template creation/editing form.
When choose 'TEXT' from drop-down
Then wait for element 'formTemplate:form:create' is visible
When clicks on element with id/name/className 'formTemplate:form:create'
Then should open page with 'Question Editor' title

Scenario:
User can enter some text for the question in the Question Text field.
When the user fills 'form2:formWithCommonProps:qtext' field with 'Test text LQE-8'
Then element 'form2:formWithCommonProps:qtext' has attribute value 'Test text LQE-8'
When the user fills 'form2:formWithCommonProps:helpText' field with 'Help text LQE-8'
Then element 'form2:formWithCommonProps:helpText' has attribute value 'Help text LQE-8'

Scenario:
User can save the template with added questions.
When clicks on element with id/name/className 'form2:formWithSaveButtons:savequestion'
Then should open page with 'Template Editor' title
When in tree 'formTemplate:form:treeMultiple' user opens node with 'Page 1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '2' elements per page
When in tree 'formTemplate:form:treeMultiple' user opens node with 'GROUP_1'
Then verify that in table 'formTemplate:form:treeMultiple' is displayed '3' elements per page
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Question 1'
Then wait for element 'formTemplate:form:btnDisplayEditQuestion' is visible

Scenario:
User can edit question.
When clicks on element with id/name/className 'formTemplate:form:btnDisplayEditQuestion'
Then should open page with 'Question Editor' title
Then element 'form2:formWithCommonProps:qtext' has attribute value 'Test text LQE-8'
Then element 'form2:formWithCommonProps:helpText' has attribute value 'Help text LQE-8'
When the user fills 'form2:formWithCommonProps:qtext' field with 'Test text LQE-8 edit'
Then element 'form2:formWithCommonProps:qtext' has attribute value 'Test text LQE-8 edit'
When the user fills 'form2:formWithCommonProps:helpText' field with 'Help text LQE-8 edit'
Then element 'form2:formWithCommonProps:helpText' has attribute value 'Help text LQE-8 edit'

When clicks on element with id/name/className 'form2:formWithSaveButtons:savequestion'

Then should open page with 'Template Editor' title
When in tree 'formTemplate:form:treeMultiple' user chooses node with 'Question 1'
Then wait for element 'formTemplate:form:btnDisplayEditQuestion' is visible

When clicks on element with id/name/className 'formTemplate:form:btnDisplayEditQuestion'
Then should open page with 'Question Editor' title
Then element 'form2:formWithCommonProps:qtext' has attribute value 'Test text LQE-8 edit'
Then element 'form2:formWithCommonProps:helpText' has attribute value 'Help text LQE-8 edit'
Then the checkbox id/name/className 'form2:formWithCommonProps:required' is unchecked