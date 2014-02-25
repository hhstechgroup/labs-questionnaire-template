Narrative:
In order to have an ability to edit template 
As a template author
I want to edit questionnaire templates

Scenario:
Narrative:
Creating new template
When the user opens the default page
Then wait for element 'form1:AddTemplate' is visible
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-3 test'
When clicks on element with id/name/className 'formTemplate:save'


Scenario:
Narrative:
User can edit the template and save
changes.
When in table 'form1:table' user presses 'Edit' in row with 'LQE-3 test'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-3 test edited'
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title
When in table 'form1:table' user presses 'Edit' in row with 'LQE-3 test edited'
Then should open page with 'Template Editor' title
Then element 'formTemplate:name' has attribute value 'LQE-3 test edited'



