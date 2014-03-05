Narrative:
As a template author I want to access the system
so that I can view the list of existing questionnaire templates.

GivenStories: base_stories/openDefaultPage.story
Scenario: create templates and check if page lists
          questionnaire templates by name and sorted alphabetically.

Given name of current test
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with testName
Then wait until all animations on page completed
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title
Then verify that in table 'form1:table' elements in column 'Name' is sorted by 'Ascending'

Examples:
|testName    |
|LQE-1 test 5|
|LQE-1 test 2|
|LQE-1 test 4|
|LQE-1 test 3|
|LQE-1 test 6|
|LQE-1 test 1|

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


