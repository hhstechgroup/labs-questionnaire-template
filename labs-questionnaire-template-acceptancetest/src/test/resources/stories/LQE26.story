Narrative:
In order to have an ability to edit template 
As a template author
I want to export questionnaire templates LQE-26

Scenario:
Narrative:
User can export the selected template(s).
Templates are exported as XML
files.
Given saved 'http://localhost:8080/questionnaire-template-web-1.0-SNAPSHOT/' link
When the user opens saved link
Then wait for element 'form1:AddTemplate' is visible
When clicks on element with id/name/className 'form1:AddTemplate'
Then should open page with 'Template Editor' title
When the user fills 'formTemplate:name' field with 'LQE-26 test'
When clicks on element with id/name/className 'formTemplate:save'
Then should open page with 'Questionnaire Editor' title
When the user fills 'form1:table:globalFilter' field with 'LQE-26 test'
When the checkbox id/name/className 'ui-chkbox-box' is unchecked make it checked
When clicks on element with id/name/className 'form1:Options_button'
When clicks on element with id/name/className 'form1:export'
Then wait until page content animations completed




