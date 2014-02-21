Narrative:
As a template author I want to access the system
so that I can view the list of existing questionnaire templates.

Scenario:
Given saved 'http://localhost:8080/questionnaire-template-web-1.0-SNAPSHOT/' link
When the user opens saved link
Then should open page with 'Questionnaire Editor' title
Then wait for element 'form1:table' is visible

