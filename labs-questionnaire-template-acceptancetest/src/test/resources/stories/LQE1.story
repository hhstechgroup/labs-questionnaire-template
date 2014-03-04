Narrative:
As a template author I want to access the system
so that I can view the list of existing questionnaire templates.

Scenario:
User can access the application with the
Questionnaire Templates page displayed by default.
When the user opens the default page
Then should open page with 'Questionnaire Editor' title
Then wait for element 'form1:table' is visible

Scenario:
Following actions are available on the list
records: Add New Template
Then wait for element 'form1:AddTemplate' is visible

Scenario:
The page lists questionnaire templates by
Name and sorted alphabetically.
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-1 test 5'
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title

When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-1 test 2'
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title

When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-1 test 4'
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title

When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-1 test 3'
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title

When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-1 test 6'
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title

When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-1 test 1'
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title

Then verify that in table 'form1:table' elements in column 'Name' is sorted by 'Ascending'

Scenario:
Following actions are available on the list
records: Edit, Clone, Delete.
Then wait for element 'form1:table:0:btnEdit' is visible
Then wait for element 'form1:table:0:Clone' is visible
Then wait for element 'form1:table:0:DeleteDialogButton' is visible

Scenario:
There is pagination and the user can
browse between pages
//TODO: uncomment when pagination is fixed
//Then verify that in table 'form1:table' is displayed less than or equal '10' elements per page
//When in table 'form1:table' user chooses to display '5' elements per page
Then verify that in table 'form1:table' is displayed less than or equal '5' elements per page
When clicks on element with id/name/className 'next-page'
Then verify that in table 'form1:table' is displayed less than or equal '5' elements per page


