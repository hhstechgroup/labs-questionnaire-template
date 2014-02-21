Narrative:
In order to have an ability to edit template 
As a template author
I want to edit questionnaire templates

Scenario:
Narrative:
Creating new template
Given saved 'http://localhost:8080/questionnaire-template-web-1.0-SNAPSHOT/' link
When the user opens saved link
Then wait for element 'form1:AddTemplate' is visible
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-3 test'
When clicks on element with id/name/className 'formTemplate:save'


Scenario:
Narrative:
User can edit the template and save
changes.
When the user fills 'form1:table:globalFilter' field with 'LQE-3 test'
When clicks on element with id/name/className 'form1:table:0:btnEdit'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-3 test edited'
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title
When clicks on element with id/name/className 'form1:table:0:btnEdit'
Then should open page with 'Template Editor' title
Then element 'formTemplate:name' has attribute value 'LQE-3 test edited'



